package xws_pi_bezb.CentralnaBanka.webservis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import bezbednost.poslovna.xml.ws.mt102.MT102Request;
import bezbednost.poslovna.xml.ws.mt102.MT102Response;
import bezbednost.poslovna.xml.ws.mt103.MT103Request;
import bezbednost.poslovna.xml.ws.mt103.MT103Response;
import bezbednost.poslovna.xml.ws.mt900.MT900Request;
import xws_pi_bezb.CentralnaBanka.CentralnaBankaKlijent;

@Endpoint
public class CentralnaBankaEndpoint {

	private static final String HTTP = "http://";
	private static final String NAMESPACE_URI = "ws.xml.poslovna.bezbednost/";
	
	//@Autowired
	//private 
	
	@Autowired
	public CentralnaBankaEndpoint(){
		
	}
	
	@PayloadRoot(namespace = HTTP + "MT102." + NAMESPACE_URI, localPart = "MT102Request")
	@ResponsePayload
	public MT102Response mt102(@RequestPayload MT102Request request){
		MT102Response response = new MT102Response();
		
		//TODO:A Cuvati u bazi, MT102, dodati mu oznaku boolean obradjen
		//MT102 mt102 = konvertujMt102Request(request);
		
		
		response.setOdgovor("MT102 - sve ok");
		return response;
	}
	
	@PayloadRoot(namespace = HTTP + "MT103." + NAMESPACE_URI, localPart = "MT103Request")
	@ResponsePayload
	public MT103Response mt103(@RequestPayload MT103Request request){
		MT103Response response = new MT103Response();	
		CentralnaBankaKlijent klijent = new CentralnaBankaKlijent();
		
		// poruka o zaduzenju MT900
		MT900Request mt900 = new MT900Request();
		mt900.setIDPoruke("MT900");
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
		mt910.setIDPoruke("MT910");
		mt910.setIDPorukeNaloga(request.getIDPoruke());
		mt910.setIznos(request.getNalog().getIznos());
		mt910.setSifraValute(request.getSifraValute());
		mt910.setDatumValute(request.getNalog().getDatumValute());
		mt910.setBankaDuznika(request.getBankaPoverioca());
		
		klijent.posaljiMT910(mt910, "http://localhost:9090/ws/MT910");
		
		response.setOdgovor("MT103 - sve ok");
		return response;
	}
	
}
