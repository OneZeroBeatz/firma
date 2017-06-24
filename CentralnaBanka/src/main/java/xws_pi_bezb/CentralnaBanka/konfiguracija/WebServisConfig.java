package xws_pi_bezb.CentralnaBanka.konfiguracija;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServisConfig extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	@Bean(name = "MT102")
	public DefaultWsdl11Definition mt102Wsdl11Definition(XsdSchema mt102Schema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("MT102Port");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://xml.poslovna.bezbednost/ws/MT102");
		wsdl11Definition.setSchema(mt102Schema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema mt102Schema() {
		return new SimpleXsdSchema(new ClassPathResource("seme/MT102.xsd"));
	}

	@Bean(name = "MT103")
	public DefaultWsdl11Definition mt103Wsdl11Definition(XsdSchema mt103Schema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("MT103Port");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://xml.poslovna.bezbednost/ws/MT103");
		wsdl11Definition.setSchema(mt103Schema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema mt103Schema() {
		return new SimpleXsdSchema(new ClassPathResource("seme/MT103.xsd"));
	}

}
