package xws_pi_bezb.CentralnaBanka.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "poslovna_banka")
public class PoslovnaBanka implements Serializable {

	private static final long serialVersionUID = 8883757998359915913L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "naziv_banke", nullable = false)
	private String nazivBanke;
	
	@Column(name = "sifra_banke", nullable = false)
	private int sifraBanke;
	
	@Column(name = "swift_kod", nullable = false)
	private String swiftKod;
	
	@Column(name = "obracunski_racun", nullable = false)
	private String obracunskiRacun;
	
	@Column(name = "ukupan_novac", nullable = false)
	private double ukupanNovac;
	
	@Column(name = "link", nullable = false)
	private String link;
	
	public PoslovnaBanka(){}

	public String getNazivBanke() {
		return nazivBanke;
	}

	public void setNazivBanke(String nazivBanke) {
		this.nazivBanke = nazivBanke;
	}

	public int getSifraBanke() {
		return sifraBanke;
	}

	public void setSifraBanke(int sifraBanke) {
		this.sifraBanke = sifraBanke;
	}

	public String getSwiftKod() {
		return swiftKod;
	}

	public void setSwiftKod(String swiftKod) {
		this.swiftKod = swiftKod;
	}

	public String getObracunskiRacun() {
		return obracunskiRacun;
	}

	public void setObracunskiRacun(String obracunskiRacun) {
		this.obracunskiRacun = obracunskiRacun;
	}

	public double getUkupanNovac() {
		return ukupanNovac;
	}

	public void setUkupanNovac(double ukupanNovac) {
		this.ukupanNovac = ukupanNovac;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
