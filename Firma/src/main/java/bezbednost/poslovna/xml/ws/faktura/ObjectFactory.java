//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.24 at 03:52:09 PM CEST 
//


package bezbednost.poslovna.xml.ws.faktura;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bezbednost.poslovna.xml.ws.faktura package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FakturaRequest_QNAME = new QName("http://xml.poslovna.bezbednost/ws/Faktura", "FakturaRequest");
    private final static QName _FakturaResponse_QNAME = new QName("http://xml.poslovna.bezbednost/ws/Faktura", "FakturaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bezbednost.poslovna.xml.ws.faktura
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FakturaRequest }
     * 
     */
    public FakturaRequest createFakturaRequest() {
        return new FakturaRequest();
    }

    /**
     * Create an instance of {@link FakturaResponse }
     * 
     */
    public FakturaResponse createFakturaResponse() {
        return new FakturaResponse();
    }

    /**
     * Create an instance of {@link PodaciOUplati }
     * 
     */
    public PodaciOUplati createPodaciOUplati() {
        return new PodaciOUplati();
    }

    /**
     * Create an instance of {@link PodaciOKupcu }
     * 
     */
    public PodaciOKupcu createPodaciOKupcu() {
        return new PodaciOKupcu();
    }

    /**
     * Create an instance of {@link TPravnoLice }
     * 
     */
    public TPravnoLice createTPravnoLice() {
        return new TPravnoLice();
    }

    /**
     * Create an instance of {@link Zaglavlje }
     * 
     */
    public Zaglavlje createZaglavlje() {
        return new Zaglavlje();
    }

    /**
     * Create an instance of {@link Stavka }
     * 
     */
    public Stavka createStavka() {
        return new Stavka();
    }

    /**
     * Create an instance of {@link PodaciRobaIUsluga }
     * 
     */
    public PodaciRobaIUsluga createPodaciRobaIUsluga() {
        return new PodaciRobaIUsluga();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FakturaRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.poslovna.bezbednost/ws/Faktura", name = "FakturaRequest")
    public JAXBElement<FakturaRequest> createFakturaRequest(FakturaRequest value) {
        return new JAXBElement<FakturaRequest>(_FakturaRequest_QNAME, FakturaRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FakturaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.poslovna.bezbednost/ws/Faktura", name = "FakturaResponse")
    public JAXBElement<FakturaResponse> createFakturaResponse(FakturaResponse value) {
        return new JAXBElement<FakturaResponse>(_FakturaResponse_QNAME, FakturaResponse.class, null, value);
    }

}