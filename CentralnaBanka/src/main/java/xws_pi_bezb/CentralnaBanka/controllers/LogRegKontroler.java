package xws_pi_bezb.CentralnaBanka.controllers;

import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bezbednost.poslovna.xml.ws.mt102.MT102Request;
import bezbednost.poslovna.xml.ws.mt900.MT900Request;
import xws_pi_bezb.CentralnaBanka.CentralnaBankaKlijent;
import xws_pi_bezb.CentralnaBanka.iservices.IMT102Services;
import xws_pi_bezb.CentralnaBanka.iservices.IPoslovnaBankaService;
import xws_pi_bezb.CentralnaBanka.models.MT102;
import xws_pi_bezb.CentralnaBanka.models.PoslovnaBanka;

@Controller
@Scope("session")
@RequestMapping("/contr")
public class LogRegKontroler {

	@Autowired
	private IMT102Services mt102Servis;
	
	@Autowired
	private IPoslovnaBankaService poslovnaBankaService;

	@RequestMapping(value = "/posaljiKliring", method = RequestMethod.POST)
	public ResponseEntity<Object> posaljiKliring() {

		obradiKliringe();
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	public void obradiKliringe() {
		List<MT102> mt102s = mt102Servis.findByObradjen(false);

		CentralnaBankaKlijent klijent = new CentralnaBankaKlijent();

		for (MT102 mt102 : mt102s) {
			PoslovnaBanka bankaDuznika = poslovnaBankaService.findBySwiftKod(mt102.getSwiftDuznik());
			PoslovnaBanka bankaPoverioca = poslovnaBankaService.findBySwiftKod(mt102.getSwiftPoverilac());
			
			bankaDuznika.setUkupanNovac(bankaDuznika.getUkupanNovac() - mt102.getUkupanIznos().doubleValue());
			poslovnaBankaService.save(bankaDuznika);
			bankaPoverioca.setUkupanNovac(bankaPoverioca.getUkupanNovac() + mt102.getUkupanIznos().doubleValue());
			poslovnaBankaService.save(bankaPoverioca);
			
			
			mt102.setObradjen(true);
			mt102Servis.save(mt102);

			MT102Request request = konvertujMT102(mt102);

			MT900Request requestMt900 = new MT900Request();
			requestMt900.setBankaDuznika(request.getBankaDuznika());
			requestMt900.setDatumValute(request.getDatumValute());
			requestMt900.setIDPoruke("MT900-" + request.getIDPoruke());
			requestMt900.setIDPorukeNaloga(request.getIDPoruke());
			requestMt900.setIznos(request.getUkupanIznos());
			requestMt900.setSifraValute(request.getSifraValute());
			klijent.posaljiMT900(requestMt900, bankaDuznika.getLink() + "ws/MT900");

			MT900Request requestMt910 = new MT900Request();
			requestMt910.setBankaDuznika(request.getBankaPoverioca());
			requestMt910.setDatumValute(request.getDatumValute());
			requestMt910.setIDPoruke("MT910-" + request.getIDPoruke());
			requestMt910.setIDPorukeNaloga(request.getIDPoruke());
			requestMt910.setIznos(request.getUkupanIznos());
			requestMt910.setSifraValute(request.getSifraValute());
			klijent.posaljiMT910(requestMt910, bankaPoverioca.getLink() + "ws/MT910");

			klijent.posaljiMT102(request, bankaPoverioca.getLink() + "ws/MT102");
		}

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
