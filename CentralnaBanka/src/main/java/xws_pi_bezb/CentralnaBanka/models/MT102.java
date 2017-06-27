package xws_pi_bezb.CentralnaBanka.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mt102")
public class MT102 {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "idPoruke", nullable = false, unique = true)
	protected String idPoruke;

	@Column(name = "swiftDuznik", nullable = false)
	protected String swiftDuznik;

	@Column(name = "obracunskiRacunDuznik", nullable = false)
	protected String obracunskiRacunDuznik;

	@Column(name = "swiftPoverilac", nullable = false)
	protected String swiftPoverilac;

	@Column(name = "obracunskiRacunPoverilac", nullable = false)
	protected String obracunskiRacunPoverilac;

	@Column(name = "ukupanIznos", nullable = false)
	protected BigDecimal ukupanIznos;

	@Column(name = "sifraValute", nullable = false)
	protected String sifraValute;

	@Column(name = "datumValute", nullable = false)
	protected Date datumValute;

	@Column(name = "datum", nullable = false)
	protected Date datum;

	@Column(name = "obradjen", nullable = false)
	protected boolean obradjen;

	@OneToMany(mappedBy = "mt102")
	protected List<PojedinacnoPlacanje> pojedinacnoPlacanje;

	public MT102() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdPoruke() {
		return idPoruke;
	}

	public void setIdPoruke(String idPoruke) {
		this.idPoruke = idPoruke;
	}

	public String getSwiftDuznik() {
		return swiftDuznik;
	}

	public void setSwiftDuznik(String swiftDuznik) {
		this.swiftDuznik = swiftDuznik;
	}

	public String getObracunskiRacunDuznik() {
		return obracunskiRacunDuznik;
	}

	public void setObracunskiRacunDuznik(String obracunskiRacunDuznik) {
		this.obracunskiRacunDuznik = obracunskiRacunDuznik;
	}

	public String getSwiftPoverilac() {
		return swiftPoverilac;
	}

	public void setSwiftPoverilac(String swiftPoverilac) {
		this.swiftPoverilac = swiftPoverilac;
	}

	public String getObracunskiRacunPoverilac() {
		return obracunskiRacunPoverilac;
	}

	public void setObracunskiRacunPoverilac(String obracunskiRacunPoverilac) {
		this.obracunskiRacunPoverilac = obracunskiRacunPoverilac;
	}

	public BigDecimal getUkupanIznos() {
		return ukupanIznos;
	}

	public void setUkupanIznos(BigDecimal ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}

	public String getSifraValute() {
		return sifraValute;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public void setSifraValute(String sifraValute) {
		this.sifraValute = sifraValute;
	}

	public List<PojedinacnoPlacanje> getPojedinacnoPlacanje() {
		return pojedinacnoPlacanje;
	}

	public void setPojedinacnoPlacanje(List<PojedinacnoPlacanje> pojedinacnoPlacanje) {
		this.pojedinacnoPlacanje = pojedinacnoPlacanje;
	}

	public boolean isObradjen() {
		return obradjen;
	}

	public void setObradjen(boolean obradjen) {
		this.obradjen = obradjen;
	}

}
