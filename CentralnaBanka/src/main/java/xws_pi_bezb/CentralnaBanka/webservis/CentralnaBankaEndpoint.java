package xws_pi_bezb.CentralnaBanka.webservis;

import java.math.BigDecimal;

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
import bezbednost.poslovna.xml.ws.mt900.MT900Request;
import xws_pi_bezb.CentralnaBanka.CentralnaBankaKlijent;
import xws_pi_bezb.CentralnaBanka.iservices.IMT102Services;
import xws_pi_bezb.CentralnaBanka.iservices.IPojedinacnoPlacanjeService;
import xws_pi_bezb.CentralnaBanka.iservices.IPoslovnaBankaService;
import xws_pi_bezb.CentralnaBanka.models.MT102;
import xws_pi_bezb.CentralnaBanka.models.PojedinacnoPlacanje;
import xws_pi_bezb.CentralnaBanka.models.PoslovnaBanka;

@Endpoint
public class CentralnaBankaEndpoint {

	private static final String HTTP = "http://";
	private static final String NAMESPACE_URI = "ws.xml.poslovna.bezbednost/";

	@Autowired
	private IMT102Services mt102Servis;

	@Autowired
	private IPojedinacnoPlacanjeService pojedinacnoPlacanjeServis;

	@Autowired
	private IPoslovnaBankaService poslovnaBankaService;

	@Autowired
	public CentralnaBankaEndpoint() {

	}

	@PayloadRoot(namespace = HTTP + "MT102." + NAMESPACE_URI, localPart = "MT102Request")
	@ResponsePayload
	public MT102Response mt102(@RequestPayload MT102Request request) {
		MT102Response response = new MT102Response();
		
		System.out.println("*** Stigao je MT102 u CB");
		System.out.println(request.toString());

		MT102 mt102 = konvertujMt102Request(request);
		
		// toString od mt102 vratiti
		response.setOdgovor("MT102 - sve ok");
		return response;
	}

	@PayloadRoot(namespace = HTTP + "MT103." + NAMESPACE_URI, localPart = "MT103Request")
	@ResponsePayload
	public MT103Response mt103(@RequestPayload MT103Request request) {
		MT103Response response = new MT103Response();
		
		System.out.println("*** Stigao je MT103 u CB");
		System.out.println(request.toString());
		
		CentralnaBankaKlijent klijent = new CentralnaBankaKlijent();

		PoslovnaBanka bankaDuznika = poslovnaBankaService.findBySwiftKod(request.getBankaDuznika().getSWIFT());
		PoslovnaBanka bankaPoverioca = poslovnaBankaService.findBySwiftKod(request.getBankaPoverioca().getSWIFT());

		bankaDuznika.setUkupanNovac(bankaDuznika.getUkupanNovac() - request.getNalog().getIznos().doubleValue());
		poslovnaBankaService.save(bankaDuznika);
		bankaPoverioca.setUkupanNovac(bankaPoverioca.getUkupanNovac() + request.getNalog().getIznos().doubleValue());
		poslovnaBankaService.save(bankaPoverioca);

		// poruka o zaduzenju MT900
		MT900Request mt900 = new MT900Request();
		mt900.setIDPoruke("MT900-" + request.getIDPoruke());
		mt900.setIDPorukeNaloga(request.getIDPoruke());
		mt900.setIznos(request.getNalog().getIznos());
		mt900.setSifraValute(request.getSifraValute());
		mt900.setDatumValute(request.getNalog().getDatumValute());
		mt900.setBankaDuznika(request.getBankaDuznika());

		klijent.posaljiMT900(mt900, bankaDuznika.getLink() + "ws/MT900");

		// poruka MT103 drugoj banci
		klijent.posaljiMT103(request, bankaPoverioca.getLink() + "ws/MT103");

		// poruka o odobrenju MT900
		MT900Request mt910 = new MT900Request();
		mt910.setIDPoruke("MT910-" + request.getIDPoruke());
		mt910.setIDPorukeNaloga(request.getIDPoruke());
		mt910.setIznos(request.getNalog().getIznos());
		mt910.setSifraValute(request.getSifraValute());
		mt910.setDatumValute(request.getNalog().getDatumValute());
		mt910.setBankaDuznika(request.getBankaPoverioca());

		klijent.posaljiMT910(mt910, bankaPoverioca.getLink() + "ws/MT910");

		response.setOdgovor("MT103 - sve ok");
		return response;
	}

	private MT102 konvertujMt102Request(MT102Request request) {
		MT102 mt102 = new MT102();
		mt102.setDatum(request.getDatum().toGregorianCalendar().getTime());
		mt102.setDatumValute(request.getDatumValute().toGregorianCalendar().getTime());
		mt102.setIdPoruke(request.getIDPoruke());
		mt102.setObracunskiRacunDuznik(request.getBankaDuznika().getObracunskiRacun());
		mt102.setObracunskiRacunPoverilac(request.getBankaPoverioca().getObracunskiRacun());
		mt102.setObradjen(false);
		mt102.setSifraValute(request.getSifraValute());
		mt102.setSwiftDuznik(request.getBankaDuznika().getSWIFT());
		mt102.setSwiftPoverilac(request.getBankaPoverioca().getSWIFT());
		mt102.setUkupanIznos(new BigDecimal(request.getUkupanIznos().doubleValue()));
		mt102Servis.save(mt102);
		
		for (TPojedinacnoPlacanje pojPlacanje : request.getPojedinacnoPlacanje()) {
			PojedinacnoPlacanje pp = new PojedinacnoPlacanje();
			pp.setDatumNaloga(pojPlacanje.getDatumNaloga().toGregorianCalendar().getTime());
			pp.setDuznik(pojPlacanje.getDuznik());
			pp.setIdNalogaZaPlacanje(pojPlacanje.getIDNalogaZaPlacanje());
			pp.setIznos(new BigDecimal(pojPlacanje.getIznos().doubleValue()));
			pp.setModelDuznik(pojPlacanje.getDuznikRacun().getModel());
			pp.setModelPoverilac(pojPlacanje.getPoverilacRacun().getModel());
			pp.setPozivNaBrojDuznik(pojPlacanje.getDuznikRacun().getPozivNaBroj());
			pp.setPozivNaBrojPoverilac(pojPlacanje.getPoverilacRacun().getPozivNaBroj());
			pp.setPrimalac(pojPlacanje.getPrimalac());
			pp.setRacunDruznik(pojPlacanje.getDuznikRacun().getRacun());
			pp.setRacunPoverilac(pojPlacanje.getPoverilacRacun().getRacun());
			pp.setSifraValute(pojPlacanje.getSifraValute());
			pp.setSvrhaPlacanja(pojPlacanje.getSvrhaPlacanja());
			pp.setMt102(mt102);
			pojedinacnoPlacanjeServis.save(pp);

		}

		return mt102;
	}

}
