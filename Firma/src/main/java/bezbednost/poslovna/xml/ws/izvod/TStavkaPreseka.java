//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.16 at 10:56:06 PM CEST 
//


package bezbednost.poslovna.xml.ws.izvod;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import bezbednost.poslovna.xml.ws.nalogzaprenos.TNalog;


/**
 * <p>Java class for TStavkaPreseka complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TStavkaPreseka">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nalog" type="{http://xml.poslovna.bezbednost/ws/NalogZaPrenos}TNalog"/>
 *         &lt;element name="Smer" type="{http://xml.poslovna.bezbednost/ws/Izvod}TSmer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TStavkaPreseka", propOrder = {
    "nalog",
    "smer"
})
public class TStavkaPreseka {

    @XmlElement(name = "Nalog", required = true)
    protected TNalog nalog;
    @XmlElement(name = "Smer", required = true)
    protected String smer;

    /**
     * Gets the value of the nalog property.
     * 
     * @return
     *     possible object is
     *     {@link TNalog }
     *     
     */
    public TNalog getNalog() {
        return nalog;
    }

    /**
     * Sets the value of the nalog property.
     * 
     * @param value
     *     allowed object is
     *     {@link TNalog }
     *     
     */
    public void setNalog(TNalog value) {
        this.nalog = value;
    }

    /**
     * Gets the value of the smer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmer() {
        return smer;
    }

    /**
     * Sets the value of the smer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmer(String value) {
        this.smer = value;
    }

}
