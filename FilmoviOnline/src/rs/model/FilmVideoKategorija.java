package rs.model;

import java.sql.Date;
import java.sql.Time;

public class FilmVideoKategorija implements java.io.Serializable{
	//FILM
	private int id_filma;
	
	private String nazivFilma, opis, glumci, reziser, drzava, jezik, urlSlike, urlPrevoda;
	private Date datumPostavljanja;
	private String godinaPremijere;
	private String vremeTrajanja;
	//VIDEO
	private int id_videa;
	private String urlVidea;
	//ZANR
	private int id_zanra;
	private String nazivZanra;
	public int getId_filma() {
		return id_filma;
	}
	public void setId_filma(int id_filma) {
		this.id_filma = id_filma;
	}

	public String getNazivFilma() {
		return nazivFilma;
	}
	public void setNazivFilma(String nazivFilma) {
		this.nazivFilma = nazivFilma;
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
	public Date getDatumPostavljanja() {
		return datumPostavljanja;
	}
	public void setDatumPostavljanja(Date datumPostavljanja) {
		this.datumPostavljanja = datumPostavljanja;
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
	public int getId_videa() {
		return id_videa;
	}
	public void setId_videa(int id_videa) {
		this.id_videa = id_videa;
	}
	public String getUrlVidea() {
		return urlVidea;
	}
	public void setUrlVidea(String urlVidea) {
		this.urlVidea = urlVidea;
	}
	public int getId_zanra() {
		return id_zanra;
	}
	public void setId_zanra(int id_zanra) {
		this.id_zanra = id_zanra;
	}
	public String getNazivZanra() {
		return nazivZanra;
	}
	public void setNazivZanra(String nazivZanra) {
		this.nazivZanra = nazivZanra;
	}
	public FilmVideoKategorija() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FilmVideoKategorija(String nazivFilma, String opis, String glumci, String reziser, String drzava,
			String jezik, String urlSlike, String urlPrevoda, Date datumPostavljanja, String godinaPremijere,
			String vremeTrajanja, int id_videa, String urlVidea, int id_zanra, String nazivZanra) {
		super();
		this.nazivFilma = nazivFilma;
		this.opis = opis;
		this.glumci = glumci;
		this.reziser = reziser;
		this.drzava = drzava;
		this.jezik = jezik;
		this.urlSlike = urlSlike;
		this.urlPrevoda = urlPrevoda;
		this.datumPostavljanja = datumPostavljanja;
		this.godinaPremijere = godinaPremijere;
		this.vremeTrajanja = vremeTrajanja;
		this.id_videa = id_videa;
		this.urlVidea = urlVidea;
		this.id_zanra = id_zanra;
		this.nazivZanra = nazivZanra;
	}
	
	
}
