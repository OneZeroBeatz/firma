//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.16 at 10:56:06 PM CEST 
//


package bezbednost.poslovna.xml.ws.nalogzaprenos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TPodaciORacunu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPodaciORacunu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Racun" type="{http://xml.poslovna.bezbednost/ws/NalogZaPrenos}TBrojRacuna"/>
 *         &lt;element name="Model" type="{http://xml.poslovna.bezbednost/ws/NalogZaPrenos}TModel"/>
 *         &lt;element name="PozivNaBroj" type="{http://xml.poslovna.bezbednost/ws/NalogZaPrenos}TPozivNaBroj"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPodaciORacunu", propOrder = {
    "racun",
    "model",
    "pozivNaBroj"
})
public class TPodaciORacunu {

    @XmlElement(name = "Racun", required = true)
    protected String racun;
    @XmlElement(name = "Model")
    protected int model;
    @XmlElement(name = "PozivNaBroj", required = true)
    protected String pozivNaBroj;

    /**
     * Gets the value of the racun property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRacun() {
        return racun;
    }

    /**
     * Sets the value of the racun property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRacun(String value) {
        this.racun = value;
    }

    /**
     * Gets the value of the model property.
     * 
     */
    public int getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     */
    public void setModel(int value) {
        this.model = value;
    }

    /**
     * Gets the value of the pozivNaBroj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPozivNaBroj() {
        return pozivNaBroj;
    }

    /**
     * Sets the value of the pozivNaBroj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPozivNaBroj(String value) {
        this.pozivNaBroj = value;
    }

}