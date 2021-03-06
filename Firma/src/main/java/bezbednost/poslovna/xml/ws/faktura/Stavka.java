//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.27 at 10:41:51 PM CEST 
//


package bezbednost.poslovna.xml.ws.faktura;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Stavka complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Stavka">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RedniBroj" type="{http://xml.poslovna.bezbednost/ws/Faktura}RedniBroj"/>
 *         &lt;element name="NazivRobeIliUsluge" type="{http://xml.poslovna.bezbednost/ws/Faktura}NazivRobeIliUsluge"/>
 *         &lt;element name="Kolicina" type="{http://xml.poslovna.bezbednost/ws/Faktura}Kolicina"/>
 *         &lt;element name="JedinicaMere" type="{http://xml.poslovna.bezbednost/ws/Faktura}JedinicaMere"/>
 *         &lt;element name="JedinicnaCena" type="{http://xml.poslovna.bezbednost/ws/Faktura}JedinicnaCena"/>
 *         &lt;element name="Vrednost" type="{http://xml.poslovna.bezbednost/ws/Faktura}Vrednost"/>
 *         &lt;element name="ProcenatRabata" type="{http://xml.poslovna.bezbednost/ws/Faktura}ProcenatRabata"/>
 *         &lt;element name="IznosRabata" type="{http://xml.poslovna.bezbednost/ws/Faktura}IznosRabata"/>
 *         &lt;element name="UmanjenoZaRabat" type="{http://xml.poslovna.bezbednost/ws/Faktura}UmanjenoZaRabat"/>
 *         &lt;element name="UkupanPorez" type="{http://xml.poslovna.bezbednost/ws/Faktura}UkupanPorez"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Stavka", propOrder = {
    "redniBroj",
    "nazivRobeIliUsluge",
    "kolicina",
    "jedinicaMere",
    "jedinicnaCena",
    "vrednost",
    "procenatRabata",
    "iznosRabata",
    "umanjenoZaRabat",
    "ukupanPorez"
})
public class Stavka {

    @XmlElement(name = "RedniBroj")
    protected int redniBroj;
    @XmlElement(name = "NazivRobeIliUsluge", required = true)
    protected String nazivRobeIliUsluge;
    @XmlElement(name = "Kolicina", required = true)
    protected BigDecimal kolicina;
    @XmlElement(name = "JedinicaMere", required = true)
    protected String jedinicaMere;
    @XmlElement(name = "JedinicnaCena", required = true)
    protected BigDecimal jedinicnaCena;
    @XmlElement(name = "Vrednost", required = true)
    protected BigDecimal vrednost;
    @XmlElement(name = "ProcenatRabata", required = true)
    protected BigDecimal procenatRabata;
    @XmlElement(name = "IznosRabata", required = true)
    protected BigDecimal iznosRabata;
    @XmlElement(name = "UmanjenoZaRabat", required = true)
    protected BigDecimal umanjenoZaRabat;
    @XmlElement(name = "UkupanPorez", required = true)
    protected BigDecimal ukupanPorez;

    /**
     * Gets the value of the redniBroj property.
     * 
     */
    public int getRedniBroj() {
        return redniBroj;
    }

    /**
     * Sets the value of the redniBroj property.
     * 
     */
    public void setRedniBroj(int value) {
        this.redniBroj = value;
    }

    /**
     * Gets the value of the nazivRobeIliUsluge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivRobeIliUsluge() {
        return nazivRobeIliUsluge;
    }

    /**
     * Sets the value of the nazivRobeIliUsluge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivRobeIliUsluge(String value) {
        this.nazivRobeIliUsluge = value;
    }

    /**
     * Gets the value of the kolicina property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getKolicina() {
        return kolicina;
    }

    /**
     * Sets the value of the kolicina property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setKolicina(BigDecimal value) {
        this.kolicina = value;
    }

    /**
     * Gets the value of the jedinicaMere property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJedinicaMere() {
        return jedinicaMere;
    }

    /**
     * Sets the value of the jedinicaMere property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJedinicaMere(String value) {
        this.jedinicaMere = value;
    }

    /**
     * Gets the value of the jedinicnaCena property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getJedinicnaCena() {
        return jedinicnaCena;
    }

    /**
     * Sets the value of the jedinicnaCena property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setJedinicnaCena(BigDecimal value) {
        this.jedinicnaCena = value;
    }

    /**
     * Gets the value of the vrednost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVrednost() {
        return vrednost;
    }

    /**
     * Sets the value of the vrednost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVrednost(BigDecimal value) {
        this.vrednost = value;
    }

    /**
     * Gets the value of the procenatRabata property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProcenatRabata() {
        return procenatRabata;
    }

    /**
     * Sets the value of the procenatRabata property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProcenatRabata(BigDecimal value) {
        this.procenatRabata = value;
    }

    /**
     * Gets the value of the iznosRabata property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIznosRabata() {
        return iznosRabata;
    }

    /**
     * Sets the value of the iznosRabata property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIznosRabata(BigDecimal value) {
        this.iznosRabata = value;
    }

    /**
     * Gets the value of the umanjenoZaRabat property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUmanjenoZaRabat() {
        return umanjenoZaRabat;
    }

    /**
     * Sets the value of the umanjenoZaRabat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUmanjenoZaRabat(BigDecimal value) {
        this.umanjenoZaRabat = value;
    }

    /**
     * Gets the value of the ukupanPorez property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUkupanPorez() {
        return ukupanPorez;
    }

    /**
     * Sets the value of the ukupanPorez property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUkupanPorez(BigDecimal value) {
        this.ukupanPorez = value;
    }
    
    @Override
	public String toString() {
		return "Stavka [redniBroj=" + Integer.toString(redniBroj)  + ", \nnazivRobeIliUsluge=" + nazivRobeIliUsluge + ", \nkolicina="
				+ new DecimalFormat("#0.##").format(kolicina)  + ", "
				+ "\njedinicaMere=" + jedinicaMere + ", \njedinicnaCena=" + new DecimalFormat("#0.##").format(jedinicnaCena) + ", \nvrednost="
				+ vrednost + ", \nprocenatRabata=" + procenatRabata + ", \niznosRabata=" + iznosRabata
				+ ", \numanjenoZaRabat=" + new DecimalFormat("#0.##").format(umanjenoZaRabat) + ", \nukupanPorez=" + new DecimalFormat("#0.##").format(ukupanPorez) + "]\n\n";
	}

}
