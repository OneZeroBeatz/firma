//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.24 at 03:52:09 PM CEST 
//


package bezbednost.poslovna.xml.ws.faktura;

import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PodaciOKupcu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PodaciOKupcu">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.poslovna.bezbednost/ws/Faktura}TPravnoLice">
 *       &lt;sequence>
 *         &lt;element name="BrojRacuna" type="{http://xml.poslovna.bezbednost/ws/Faktura}BrojRacuna"/>
 *         &lt;element name="DatumRacuna" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PodaciOKupcu", propOrder = {
    "brojRacuna",
    "datumRacuna"
})
public class PodaciOKupcu
    extends TPravnoLice
{

    @XmlElement(name = "BrojRacuna")
    protected int brojRacuna;
    @XmlElement(name = "DatumRacuna", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumRacuna;

    /**
     * Gets the value of the brojRacuna property.
     * 
     */
    public int getBrojRacuna() {
        return brojRacuna;
    }

    /**
     * Sets the value of the brojRacuna property.
     * 
     */
    public void setBrojRacuna(int value) {
        this.brojRacuna = value;
    }

    /**
     * Gets the value of the datumRacuna property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumRacuna() {
        return datumRacuna;
    }

    /**
     * Sets the value of the datumRacuna property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumRacuna(XMLGregorianCalendar value) {
        this.datumRacuna = value;
    }

	@Override
	public String toString() {
		return "PodaciOKupcu [brojRacuna=" + Integer.toString(brojRacuna) + ", datumRacuna=" + datumRacuna.toString() + "]";
	}
    
    

}
