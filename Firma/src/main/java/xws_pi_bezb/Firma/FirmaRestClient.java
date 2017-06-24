package xws_pi_bezb.Firma;

import java.math.BigDecimal;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import bezbednost.poslovna.xml.ws.faktura.FakturaRequest;
import bezbednost.poslovna.xml.ws.faktura.FakturaResponse;
import bezbednost.poslovna.xml.ws.faktura.PodaciOKupcu;
import bezbednost.poslovna.xml.ws.faktura.PodaciOUplati;
import bezbednost.poslovna.xml.ws.faktura.PodaciRobaIUsluga;
import bezbednost.poslovna.xml.ws.faktura.Stavka;
import bezbednost.poslovna.xml.ws.faktura.TPravnoLice;
import bezbednost.poslovna.xml.ws.faktura.Zaglavlje;

public class FirmaRestClient {
	public static final String REST_SERVICE_URI = "http://localhost:8999/Firma/service";

	public static void posaljiFakturu() {
		
		FakturaRequest fakturaRequest = new FakturaRequest();
		
		Zaglavlje zaglavlje = new Zaglavlje();
			TPravnoLice tpl = new TPravnoLice();
				tpl.setAdresa("Narodnog Fronta 10");
				tpl.setNaziv("Firma1");
				tpl.setPIB("15258745235");
			
			PodaciOKupcu pok = new PodaciOKupcu();
				pok.setAdresa("Bulevar cara Lazara 20");
				pok.setNaziv("Firma2");
				pok.setPIB("89545235261");
				pok.setBrojRacuna(658452);
				
				try {
					pok.setDatumRacuna(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2017, 4, 15, 1));
				} catch (DatatypeConfigurationException e) {
					e.printStackTrace();
				}
				
			PodaciRobaIUsluga priu = new PodaciRobaIUsluga();
				priu.setUkupanPorez(new BigDecimal(200.15));
				priu.setUkupanRabat(new BigDecimal(500.00));
				priu.setUkupnoRobaIUsluga(new BigDecimal(10000.50));
				priu.setVrednostRobe(new BigDecimal(6000.00));
				priu.setVrednostUsluga(new BigDecimal(4000.50));
				
			PodaciOUplati pou = new PodaciOUplati();
				pou.setOznakaValute("RSD");
				pou.setIznosZaUplatu(new BigDecimal(10700.65));
				pou.setUplataNaRacun("000000001587452635");
				
				try {
					pou.setDatumValute(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2017, 4, 15, 1));
				} catch (DatatypeConfigurationException e) {
					e.printStackTrace();
				}
			
		zaglavlje.setIDPoruke("Faktura");
		zaglavlje.setPodaciODobavljacu(tpl);
		zaglavlje.setPodaciOKupcu(pok);
		zaglavlje.setPodaciRobaIUsluga(priu);
		zaglavlje.setPodaciOUplati(pou);
		
		Stavka stavka1 = new Stavka();	
			stavka1.setRedniBroj(1);
			stavka1.setNazivRobeIliUsluge("Stolica");
			stavka1.setKolicina(new BigDecimal(1));
			stavka1.setJedinicnaCena(new BigDecimal(10000));
			stavka1.setJedinicaMere("Komad");
			stavka1.setVrednost(new BigDecimal(10000));
			stavka1.setProcenatRabata(new BigDecimal(10));
			stavka1.setIznosRabata(new BigDecimal(1000));
			stavka1.setUmanjenoZaRabat(new BigDecimal(1000));
			stavka1.setUkupanPorez(new BigDecimal(11000));
			
		Stavka stavka2 = new Stavka();	
			stavka2.setRedniBroj(1);
			stavka2.setNazivRobeIliUsluge("Krevet");
			stavka2.setKolicina(new BigDecimal(1));
			stavka2.setJedinicnaCena(new BigDecimal(50000));
			stavka2.setJedinicaMere("Komad");
			stavka2.setVrednost(new BigDecimal(50000));
			stavka2.setProcenatRabata(new BigDecimal(10));
			stavka2.setIznosRabata(new BigDecimal(5000));
			stavka2.setUmanjenoZaRabat(new BigDecimal(5000));
			stavka2.setUkupanPorez(new BigDecimal(55000));
		
		fakturaRequest.setZaglavlje(zaglavlje);
		fakturaRequest.getStavka().add(stavka1);
		fakturaRequest.getStavka().add(stavka2);

		try {
		
			RestTemplate restTemplate = new RestTemplate();
			FakturaResponse fakturaResponse = (FakturaResponse) restTemplate
					.postForObject(REST_SERVICE_URI + "/method/", fakturaRequest, FakturaResponse.class);

			System.out.println(fakturaResponse.getOdgovor());
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
