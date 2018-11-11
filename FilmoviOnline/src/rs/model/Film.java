package rs.model;

import java.sql.Date;
import java.sql.Time;

public class Film implements java.io.Serializable{
	private int id, idVidea;
	
	private String naziv, opis, glumci, reziser, drzava, jezik, urlSlike, urlPrevoda;
	private Date datumPostavljanja;
	private String godinaPremijere;
	private String vremeTrajanja;
	
	


	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdVidea() {
		return idVidea;
	}
	public void setIdVidea(int idVidea) {
		this.idVidea = idVidea;
	}

	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getGlumci() {
		return glumci;
	}
	public void setGlumci(String glumci) {
		this.glumci = glumci;
	}
	public String getReziser() {
		return reziser;
	}
	public void setReziser(String reziser) {
		this.reziser = reziser;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	public String getJezik() {
		return jezik;
	}
	public void setJezik(String jezik) {
		this.jezik = jezik;
	}
	public String getUrlSlike() {
		return urlSlike;
	}
	public void setUrlSlike(String urlSlike) {
		this.urlSlike = urlSlike;
	}
	public String getUrlPrevoda() {
		return urlPrevoda;
	}
	public void setUrlPrevoda(String urlPrevoda) {
		this.urlPrevoda = urlPrevoda;
	}
	public String getGodinaPremijere() {
		return godinaPremijere;
	}
	public void setGodinaPremijere(String godinaPremijere) {
		this.godinaPremijere = godinaPremijere;
	}
	public String getVremeTrajanja() {
		return vremeTrajanja;
	}
	public void setVremeTrajanja(String vremeTrajanja) {
		this.vremeTrajanja = vremeTrajanja;
	}

	public Date getDatumPostavljanja() {
		return datumPostavljanja;
	}

	public void setDatumPostavljanja(Date datumPostavljanja) {
		this.datumPostavljanja = datumPostavljanja;
	}
	public Film(int idVidea, String naziv, String opis, String glumci, String reziser, String drzava, String jezik,
			String urlSlike, String urlPrevoda, String godinaPremijere, String vremeTrajanja) {
		super();
		this.idVidea = idVidea;
		this.naziv = naziv;
		this.opis = opis;
		this.glumci = glumci;
		this.reziser = reziser;
		this.drzava = drzava;
		this.jezik = jezik;
		this.urlSlike = urlSlike;
		this.urlPrevoda = urlPrevoda;
		this.godinaPremijere = godinaPremijere;
		this.vremeTrajanja = vremeTrajanja;
	}
	
	

}
