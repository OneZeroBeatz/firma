package xws_pi_bezb.CentralnaBanka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CentralnaBankaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralnaBankaApplication.class, args);
/*
		MT102Request request102 = new MT102Request();
		MT103Request request103 = new MT103Request();
		MT900Request request900 = new MT900Request();
		MT900Request request910 = new MT900Request();
		
		CentralnaBankaKlijent klijentTest = new CentralnaBankaKlijent();
		klijentTest.posaljiMT102(request102);
		klijentTest.posaljiMT103(request103);
		klijentTest.posaljiMT900(request900);
		klijentTest.posaljiMT910(request910);
*/
	}
}
