package xws_pi_bezb.CentralnaBanka;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import bezbednost.poslovna.xml.ws.mt102.MT102Request;
import bezbednost.poslovna.xml.ws.mt102.MT102Response;
import bezbednost.poslovna.xml.ws.mt103.MT103Request;
import bezbednost.poslovna.xml.ws.mt103.MT103Response;
import bezbednost.poslovna.xml.ws.mt900.MT900Request;
import bezbednost.poslovna.xml.ws.mt900.MT900Response;

public class CentralnaBankaKlijent extends WebServiceGatewaySupport {

	public void posaljiMT102(MT102Request request, String uri) {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(MT102Request.class, MT102Response.class);
		setMarshaller(marshaller);
		setUnmarshaller(marshaller);

		if (uri == null)
			uri = "http://localhost:9000/ws/MT102";

		Object o = getWebServiceTemplate().marshalSendAndReceive(uri, request);
		MT102Response response = (MT102Response) o;
		System.out.println("CB primila odgovor MT102:  " + response.getOdgovor());

	}

	public void posaljiMT103(MT103Request request, String uri) {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(MT103Request.class, MT103Response.class);
		setMarshaller(marshaller);
		setUnmarshaller(marshaller);

		if (uri == null)
			uri = "http://localhost:9090/ws/MT103";

		Object o = getWebServiceTemplate().marshalSendAndReceive(uri, request);
		MT103Response response = (MT103Response) o;
		System.out.println("CB primila odgovor MT103:  " + response.getOdgovor());

	}

	public void posaljiMT900(MT900Request request, String uri) {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(MT900Request.class, MT900Response.class);
		setMarshaller(marshaller);
		setUnmarshaller(marshaller);

		if (uri == null)
			uri = "http://localhost:9000/ws/MT900";

		Object o = getWebServiceTemplate().marshalSendAndReceive(uri, request);
		MT900Response response = (MT900Response) o;
		System.out.println("CB primila odgovor MT900:  " + response.getOdgovor());

	}

	public void posaljiMT910(MT900Request request, String uri) {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(MT900Request.class, MT900Response.class);
		setMarshaller(marshaller);
		setUnmarshaller(marshaller);

		if (uri == null)
			uri = "http://localhost:9090/ws/MT910";

		Object o = getWebServiceTemplate().marshalSendAndReceive(uri, request);
		MT900Response response = (MT900Response) o;
		System.out.println("CB primila odgovor MT910:  " + response.getOdgovor());

	}

	

}
