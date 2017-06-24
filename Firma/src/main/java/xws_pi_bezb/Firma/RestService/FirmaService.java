package xws_pi_bezb.Firma.RestService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bezbednost.poslovna.xml.ws.faktura.FakturaRequest;
import bezbednost.poslovna.xml.ws.faktura.FakturaResponse;

@Controller
@RequestMapping("/service")
public class FirmaService {

	@RequestMapping(value = "/method", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<FakturaResponse> method(@RequestBody FakturaRequest faktura) {
		System.out.println("\n***********************************\n");
		System.out.println(faktura.toString());
		System.out.println("***********************************\n");
		FakturaResponse fr = new FakturaResponse();
		fr.setOdgovor("Primljena faktura.");
		return new ResponseEntity<FakturaResponse>(fr, HttpStatus.OK);
	}
}