package xws_pi_bezb.CentralnaBanka.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "pojedinacno_placanje")
public class PojedinacnoPlacanje {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "idNalogaZaPlacanje", nullable = false)
	protected String idNalogaZaPlacanje;

	@Column(name = "duznik", nullable = false)
	protected String duznik;

	@Column(name = "svrhaPlacanja", nullable = false)
	protected String svrhaPlacanja;

	@Column(name = "primalac", nullable = false)
	protected String primalac;

	@Column(name = "idPoruke", nullable = false)
	protected Date datumNaloga;

	@Column(name = "racunDruznik", nullable = false)
	protected String racunDruznik;

	@XmlElement(name = "modelDuznik")
	protected int modelDuznik;

	@XmlElement(name = "PozivNaBrojDuznik", required = true)
	protected String PozivNaBrojDuznik;

	@Column(name = "racunPoverilac", nullable = false)
	protected String racunPoverilac;

	@Column(name = "modelPoverilac", nullable = false)
	protected int modelPoverilac;

	@Column(name = "PozivNaBrojPoverilac", nullable = false)
	protected String PozivNaBrojPoverilac;

	@Column(name = "iznos", nullable = false)
	protected BigDecimal iznos;

	@Column(name = "sifraValute", nullable = false)
	protected String sifraValute;

	@ManyToOne
	public MT102 mt102;

	public PojedinacnoPlacanje() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdNalogaZaPlacanje() {
		return idNalogaZaPlacanje;
	}

	public void setIdNalogaZaPlacanje(String idNalogaZaPlacanje) {
		this.idNalogaZaPlacanje = idNalogaZaPlacanje;
	}

	public String getDuznik() {
		return duznik;
	}

	public void setDuznik(String duznik) {
		this.duznik = duznik;
	}

	public String getSvrhaPlacanja() {
		return svrhaPlacanja;
	}

	public void setSvrhaPlacanja(String svrhaPlacanja) {
		this.svrhaPlacanja = svrhaPlacanja;
	}

	public String getPrimalac() {
		return primalac;
	}

	public void setPrimalac(String primalac) {
		this.primalac = primalac;
	}

	public Date getDatumNaloga() {
		return datumNaloga;
	}

	public void setDatumNaloga(Date datumNaloga) {
		this.datumNaloga = datumNaloga;
	}

	public String getRacunDruznik() {
		return racunDruznik;
	}

	public void setRacunDruznik(String racunDruznik) {
		this.racunDruznik = racunDruznik;
	}

	public int getModelDuznik() {
		return modelDuznik;
	}

	public void setModelDuznik(int modelDuznik) {
		this.modelDuznik = modelDuznik;
	}

	public String getPozivNaBrojDuznik() {
		return PozivNaBrojDuznik;
	}

	public void setPozivNaBrojDuznik(String pozivNaBrojDuznik) {
		PozivNaBrojDuznik = pozivNaBrojDuznik;
	}

	public String getRacunPoverilac() {
		return racunPoverilac;
	}

	public void setRacunPoverilac(String racunPoverilac) {
		this.racunPoverilac = racunPoverilac;
	}

	public int getModelPoverilac() {
		return modelPoverilac;
	}

	public void setModelPoverilac(int modelPoverilac) {
		this.modelPoverilac = modelPoverilac;
	}

	public String getPozivNaBrojPoverilac() {
		return PozivNaBrojPoverilac;
	}

	public void setPozivNaBrojPoverilac(String pozivNaBrojPoverilac) {
		PozivNaBrojPoverilac = pozivNaBrojPoverilac;
	}

	public BigDecimal getIznos() {
		return iznos;
	}

	public void setIznos(BigDecimal iznos) {
		this.iznos = iznos;
	}

	public String getSifraValute() {
		return sifraValute;
	}

	public void setSifraValute(String sifraValute) {
		this.sifraValute = sifraValute;
	}

	public MT102 getMt102() {
		return mt102;
	}
	
	public void setMt102(MT102 mt102) {
		this.mt102 = mt102;
	}
}
