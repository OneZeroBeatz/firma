package xws_pi_bezb.CentralnaBanka.webservis;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import bezbednost.poslovna.xml.ws.mt102.MT102Request;
import bezbednost.poslovna.xml.ws.mt102.MT102Response;
import bezbednost.poslovna.xml.ws.mt102.TPojedinacnoPlacanje;
import bezbednost.poslovna.xml.ws.mt103.MT103Request;
import bezbednost.poslovna.xml.ws.mt103.MT103Response;
import bezbednost.poslovna.xml.ws.mt103.TSWIFTIRacun;
import bezbednost.poslovna.xml.ws.mt900.MT900Request;
import xws_pi_bezb.CentralnaBanka.CentralnaBankaKlijent;
import xws_pi_bezb.CentralnaBanka.iservices.IMT102Services;
import xws_pi_bezb.CentralnaBanka.iservices.IPojedinacnoPlacanjeService;
import xws_pi_bezb.CentralnaBanka.models.MT102;
import xws_pi_bezb.CentralnaBanka.models.PojedinacnoPlacanje;

@Endpoint
public class CentralnaBankaEndpoint {

	private static final String HTTP = "http://";
	private static final String NAMESPACE_URI = "ws.xml.poslovna.bezbednost/";

	@Autowired
	private IMT102Services mt102Servis;

	@Autowired
	private IPojedinacnoPlacanjeService pojedinacnoPlacanjeServis;

	@Autowired
	public CentralnaBankaEndpoint() {

	}

	@PayloadRoot(namespace = HTTP + "MT102." + NAMESPACE_URI, localPart = "MT102Request")
	@ResponsePayload
	public MT102Response mt102(@RequestPayload MT102Request request) {
		MT102Response response = new MT102Response();

		MT102 mt102 = konvertujMt102Request(request);
		mt102Servis.save(mt102);

		response.setOdgovor("MT102 - sve ok");
		return response;
	}

	@PayloadRoot(namespace = HTTP + "MT103." + NAMESPACE_URI, localPart = "MT103Request")
	@ResponsePayload
	public MT103Response mt103(@RequestPayload MT103Request request) {
		MT103Response response = new MT103Response();
		CentralnaBankaKlijent klijent = new CentralnaBankaKlijent();

		// poruka o zaduzenju MT900
		MT900Request mt900 = new MT900Request();
		mt900.setIDPoruke("MT900-"+request.getIDPoruke());//kompleksije
		mt900.setIDPorukeNaloga(request.getIDPoruke());
		mt900.setIznos(request.getNalog().getIznos());
		mt900.setSifraValute(request.getSifraValute());
		mt900.setDatumValute(request.getNalog().getDatumValute());
		mt900.setBankaDuznika(request.getBankaDuznika());

		klijent.posaljiMT900(mt900, "http://localhost:9000/ws/MT900");

		// poruka MT103 drugoj banci
		klijent.posaljiMT103(request, "http://localhost:9090/ws/MT103");

		// poruka o odobrenju MT900
		MT900Request mt910 = new MT900Request();
		mt910.setIDPoruke("MT910-"+request.getIDPoruke());
		mt910.setIDPorukeNaloga(request.getIDPoruke());
		mt910.setIznos(request.getNalog().getIznos());
		mt910.setSifraValute(request.getSifraValute());
		mt910.setDatumValute(request.getNalog().getDatumValute());
		mt910.setBankaDuznika(request.getBankaPoverioca());

		klijent.posaljiMT910(mt910, "http://localhost:9090/ws/MT910");

		response.setOdgovor("MT103 - sve ok");
		return response;
	}

	// Ovo ide u kontroler!
	public void obradiKliringe() {
		List<MT102> mt102s = mt102Servis.findByObradjen(false);

		// TODO:A Odraditi bileteralni obracun...

		CentralnaBankaKlijent klijent = new CentralnaBankaKlijent();
		
		for (MT102 mt102 : mt102s) {
			mt102.setObradjen(true);
			mt102Servis.save(mt102);
			
			MT102Request request = konvertujMT102(mt102);
			
			MT900Request requestMt900 = new MT900Request();	
			requestMt900.setBankaDuznika(request.getBankaDuznika());
			requestMt900.setDatumValute(request.getDatumValute());
			requestMt900.setIDPoruke("MT900-"+request.getIDPoruke());
			requestMt900.setIDPorukeNaloga(request.getIDPoruke());
			requestMt900.setIznos(request.getUkupanIznos());
			requestMt900.setSifraValute(request.getSifraValute());
			klijent.posaljiMT900(requestMt900, "http://localhost:9000/ws/MT900");
			
			MT900Request requestMt910 = new MT900Request();	
			requestMt910.setBankaDuznika(request.getBankaPoverioca());
			requestMt910.setDatumValute(request.getDatumValute());
			requestMt910.setIDPoruke("MT910-"+request.getIDPoruke());
			requestMt910.setIDPorukeNaloga(request.getIDPoruke());
			requestMt910.setIznos(request.getUkupanIznos());
			requestMt910.setSifraValute(request.getSifraValute());
			klijent.posaljiMT910(requestMt910, "http://localhost:9090/ws/MT910");
			
			klijent.posaljiMT102(request, "http://localhost:9090/ws/MT102");
		}

	}
	
	private MT102 konvertujMt102Request(MT102Request request) {
		MT102 mt102 = new MT102();
		mt102.setDatum(request.getDatum().toGregorianCalendar().getTime());
		mt102.setDatumValute(request.getDatumValute().toGregorianCalendar().getTime());
		mt102.setIdPoruke(request.getIDPoruke());
		mt102.setObracunskiRacunDuznik(request.getBankaDuznika().getObracunskiRacun());
		mt102.setObracunskiRacunPoverilac(request.getBankaPoverioca().getObracunskiRacun());
		mt102.setObradjen(false);

		List<PojedinacnoPlacanje> pojedinacnoPlacanje = new ArrayList<PojedinacnoPlacanje>();

		for (TPojedinacnoPlacanje pojPlacanje : request.getPojedinacnoPlacanje()) {
			PojedinacnoPlacanje pp = new PojedinacnoPlacanje();
			pp.setDatumNaloga(pojPlacanje.getDatumNaloga().toGregorianCalendar().getTime());
			pp.setDuznik(pojPlacanje.getDuznik());
			pp.setIdNalogaZaPlacanje(pojPlacanje.getIDNalogaZaPlacanje());
			pp.setIznos(pojPlacanje.getIznos());
			pp.setModelDuznik(pojPlacanje.getDuznikRacun().getModel());
			pp.setModelPoverilac(pojPlacanje.getPoverilacRacun().getModel());
			pp.setPozivNaBrojDuznik(pojPlacanje.getDuznikRacun().getPozivNaBroj());
			pp.setPozivNaBrojPoverilac(pojPlacanje.getPoverilacRacun().getPozivNaBroj());
			pp.setPrimalac(pojPlacanje.getPrimalac());
			pp.setRacunDruznik(pojPlacanje.getDuznikRacun().getRacun());
			pp.setRacunPoverilac(pojPlacanje.getPoverilacRacun().getRacun());
			pp.setSifraValute(pojPlacanje.getSifraValute());
			pp.setSvrhaPlacanja(pojPlacanje.getSvrhaPlacanja());

			pojedinacnoPlacanjeServis.save(pp);
			pojedinacnoPlacanje.add(pp);
		}

		mt102.setPojedinacnoPlacanje(pojedinacnoPlacanje);
		mt102.setSifraValute(request.getSifraValute());
		mt102.setSwiftDuznik(request.getBankaDuznika().getSWIFT());
		mt102.setSwiftPoverilac(request.getBankaPoverioca().getSWIFT());
		mt102.setUkupanIznos(request.getUkupanIznos());
		return mt102;
	}

	private MT102Request konvertujMT102(MT102 mt102) {

		MT102Request req = new MT102Request();

		req.setIDPoruke(mt102.getIdPoruke());

		req.getBankaDuznika().setSWIFT(mt102.getSwiftDuznik());
		req.getBankaDuznika().setObracunskiRacun(mt102.getObracunskiRacunDuznik());

		req.getBankaPoverioca().setSWIFT(mt102.getSwiftPoverilac());
		req.getBankaPoverioca().setObracunskiRacun(mt102.getObracunskiRacunPoverilac());

		req.setUkupanIznos(mt102.getUkupanIznos());
		req.setSifraValute(mt102.getSifraValute());

		GregorianCalendar gcal = (GregorianCalendar) GregorianCalendar.getInstance();
		gcal.setTime(mt102.getDatumValute());

		XMLGregorianCalendar xgcal;
		try {
			xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
			req.setDatumValute(xgcal);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}

		gcal = (GregorianCalendar) GregorianCalendar.getInstance();
		gcal.setTime(mt102.getDatum());

		try {
			xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
			req.setDatum(xgcal);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < mt102.getPojedinacnoPlacanje().size(); i++) {
			req.getPojedinacnoPlacanje().get(i)
					.setIDNalogaZaPlacanje(mt102.getPojedinacnoPlacanje().get(i).getIdNalogaZaPlacanje());

			req.getPojedinacnoPlacanje().get(i).setDuznik(mt102.getPojedinacnoPlacanje().get(i).getDuznik());

			req.getPojedinacnoPlacanje().get(i)
					.setSvrhaPlacanja(mt102.getPojedinacnoPlacanje().get(i).getSvrhaPlacanja());

			gcal = (GregorianCalendar) GregorianCalendar.getInstance();
			gcal.setTime(mt102.getPojedinacnoPlacanje().get(i).getDatumNaloga());

			try {
				xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
				req.getPojedinacnoPlacanje().get(i).setDatumNaloga(xgcal);
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
			}

			req.getPojedinacnoPlacanje().get(i).getDuznikRacun()
					.setPozivNaBroj(mt102.getPojedinacnoPlacanje().get(i).getPozivNaBrojDuznik());
			req.getPojedinacnoPlacanje().get(i).getDuznikRacun()
					.setModel(mt102.getPojedinacnoPlacanje().get(i).getModelDuznik());
			req.getPojedinacnoPlacanje().get(i).getDuznikRacun()
					.setRacun(mt102.getPojedinacnoPlacanje().get(i).getRacunDruznik());

			req.getPojedinacnoPlacanje().get(i).getPoverilacRacun()
					.setPozivNaBroj(mt102.getPojedinacnoPlacanje().get(i).getPozivNaBrojPoverilac());
			req.getPojedinacnoPlacanje().get(i).getPoverilacRacun()
					.setModel(mt102.getPojedinacnoPlacanje().get(i).getModelDuznik());
			req.getPojedinacnoPlacanje().get(i).getPoverilacRacun()
					.setRacun(mt102.getPojedinacnoPlacanje().get(i).getRacunPoverilac());

		}

		return req;
	}

}
