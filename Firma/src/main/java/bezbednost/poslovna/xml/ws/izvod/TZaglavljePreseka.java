//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.27 at 10:41:51 PM CEST 
//


package bezbednost.poslovna.xml.ws.izvod;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TZaglavljePreseka complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TZaglavljePreseka">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Zahtev" type="{http://xml.poslovna.bezbednost/ws/Izvod}TZahtev"/>
 *         &lt;element name="PrethodnoStanje" type="{http://xml.poslovna.bezbednost/ws/Izvod}TStanjeIliSuma"/>
 *         &lt;element name="BrojPromenaUKorist" type="{http://xml.poslovna.bezbednost/ws/Izvod}TBrojPromena"/>
 *         &lt;element name="UkupnoUKorist" type="{http://xml.poslovna.bezbednost/ws/Izvod}TStanjeIliSuma"/>
 *         &lt;element name="BrojPromenaNaTeret" type="{http://xml.poslovna.bezbednost/ws/Izvod}TStanjeIliSuma"/>
 *         &lt;element name="UkupnoNaTeret" type="{http://xml.poslovna.bezbednost/ws/Izvod}TStanjeIliSuma"/>
 *         &lt;element name="NovoStanje" type="{http://xml.poslovna.bezbednost/ws/Izvod}TStanjeIliSuma"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TZaglavljePreseka", propOrder = {
    "zahtev",
    "prethodnoStanje",
    "brojPromenaUKorist",
    "ukupnoUKorist",
    "brojPromenaNaTeret",
    "ukupnoNaTeret",
    "novoStanje"
})
public class TZaglavljePreseka {

    @XmlElement(name = "Zahtev", required = true)
    protected TZahtev zahtev;
    @XmlElement(name = "PrethodnoStanje", required = true)
    protected BigDecimal prethodnoStanje;
    @XmlElement(name = "BrojPromenaUKorist")
    protected int brojPromenaUKorist;
    @XmlElement(name = "UkupnoUKorist", required = true)
    protected BigDecimal ukupnoUKorist;
    @XmlElement(name = "BrojPromenaNaTeret", required = true)
    protected BigDecimal brojPromenaNaTeret;
    @XmlElement(name = "UkupnoNaTeret", required = true)
    protected BigDecimal ukupnoNaTeret;
    @XmlElement(name = "NovoStanje", required = true)
    protected BigDecimal novoStanje;

    /**
     * Gets the value of the zahtev property.
     * 
     * @return
     *     possible object is
     *     {@link TZahtev }
     *     
     */
    public TZahtev getZahtev() {
        return zahtev;
    }

    /**
     * Sets the value of the zahtev property.
     * 
     * @param value
     *     allowed object is
     *     {@link TZahtev }
     *     
     */
    public void setZahtev(TZahtev value) {
        this.zahtev = value;
    }

    /**
     * Gets the value of the prethodnoStanje property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrethodnoStanje() {
        return prethodnoStanje;
    }

    /**
     * Sets the value of the prethodnoStanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrethodnoStanje(BigDecimal value) {
        this.prethodnoStanje = value;
    }

    /**
     * Gets the value of the brojPromenaUKorist property.
     * 
     */
    public int getBrojPromenaUKorist() {
        return brojPromenaUKorist;
    }

    /**
     * Sets the value of the brojPromenaUKorist property.
     * 
     */
    public void setBrojPromenaUKorist(int value) {
        this.brojPromenaUKorist = value;
    }

    /**
     * Gets the value of the ukupnoUKorist property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUkupnoUKorist() {
        return ukupnoUKorist;
    }

    /**
     * Sets the value of the ukupnoUKorist property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUkupnoUKorist(BigDecimal value) {
        this.ukupnoUKorist = value;
    }

    /**
     * Gets the value of the brojPromenaNaTeret property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBrojPromenaNaTeret() {
        return brojPromenaNaTeret;
    }

    /**
     * Sets the value of the brojPromenaNaTeret property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBrojPromenaNaTeret(BigDecimal value) {
        this.brojPromenaNaTeret = value;
    }

    /**
     * Gets the value of the ukupnoNaTeret property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUkupnoNaTeret() {
        return ukupnoNaTeret;
    }

    /**
     * Sets the value of the ukupnoNaTeret property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUkupnoNaTeret(BigDecimal value) {
        this.ukupnoNaTeret = value;
    }

    /**
     * Gets the value of the novoStanje property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNovoStanje() {
        return novoStanje;
    }

    /**
     * Sets the value of the novoStanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNovoStanje(BigDecimal value) {
        this.novoStanje = value;
    }

	@Override
	public String toString() {
		return "TZaglavljePreseka [zahtev=" + zahtev.toString() + ",\n prethodnoStanje=" + prethodnoStanje + ",\n brojPromenaUKorist="
				+ Integer.toString(brojPromenaUKorist) + ",\n ukupnoUKorist=" + new DecimalFormat("#0.##").format(ukupnoUKorist) + ",\n brojPromenaNaTeret=" + new DecimalFormat("#0.##").format(brojPromenaNaTeret)
				+ ",\n ukupnoNaTeret=" + new DecimalFormat("#0.##").format(ukupnoNaTeret)  + ",\n novoStanje=" + new DecimalFormat("#0.##").format(novoStanje) + "]";
	}
    
    

}
