//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.27 at 10:41:51 PM CEST 
//


package bezbednost.poslovna.xml.ws.faktura;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FakturaRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FakturaRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Zaglavlje" type="{http://xml.poslovna.bezbednost/ws/Faktura}Zaglavlje"/>
 *         &lt;element name="Stavka" type="{http://xml.poslovna.bezbednost/ws/Faktura}Stavka" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FakturaRequest", propOrder = {
    "zaglavlje",
    "stavka"
})
public class FakturaRequest {

    @XmlElement(name = "Zaglavlje", required = true)
    protected Zaglavlje zaglavlje;
    @XmlElement(name = "Stavka", required = true)
    protected List<Stavka> stavka;

    /**
     * Gets the value of the zaglavlje property.
     * 
     * @return
     *     possible object is
     *     {@link Zaglavlje }
     *     
     */
    public Zaglavlje getZaglavlje() {
        return zaglavlje;
    }

    /**
     * Sets the value of the zaglavlje property.
     * 
     * @param value
     *     allowed object is
     *     {@link Zaglavlje }
     *     
     */
    public void setZaglavlje(Zaglavlje value) {
        this.zaglavlje = value;
    }

    /**
     * Gets the value of the stavka property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stavka property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStavka().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Stavka }
     * 
     * 
     */
    public List<Stavka> getStavka() {
        if (stavka == null) {
            stavka = new ArrayList<Stavka>();
        }
        return this.stavka;
    }
    
    @Override
	public String toString() {
		String stavke = "";
		for(Stavka stavka: stavka){
			stavke += stavka.toString() + "\n\n";
		}
		return "FakturaRequest:\n" + zaglavlje.toString() + "\n, stavka=" + stavke + "]";
	}

}
