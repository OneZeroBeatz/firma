package xws_pi_bezb.CentralnaBanka.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("session")
@RequestMapping("/contr")
public class LogRegKontroler {

	@RequestMapping(value = "/posaljiKliring", method = RequestMethod.POST)
	public ResponseEntity<Object> posaljiKliring() {
		
		//TODO Ovde coa kod
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
