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

@Endpoint
public class CentralnaBankaEndpoint {

	private static final String HTTP = "http://";
	private static final String NAMESPACE_URI = "ws.xml.poslovna.bezbednost/";
	
	@Autowired
	public CentralnaBankaEndpoint(){
		
	}
	
	@PayloadRoot(namespace = HTTP + "MT102." + NAMESPACE_URI, localPart = "MT102Request")
	@ResponsePayload
	public MT102Response mt102(@RequestPayload MT102Request request){
		MT102Response response = new MT102Response();
		response.setOdgovor("MT102 - odgovor");
		return response;
	}
	
	@PayloadRoot(namespace = HTTP + "MT103." + NAMESPACE_URI, localPart = "MT103Request")
	@ResponsePayload
	public MT103Response mt103(@RequestPayload MT103Request request){
		MT103Response response = new MT103Response();
		response.setOdgovor("MT103 - odgovor");
		return response;
	}
	
}
