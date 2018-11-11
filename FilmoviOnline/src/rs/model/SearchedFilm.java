package rs.model;

import java.sql.Date;

public class SearchedFilm implements java.io.Serializable{
	private int idVidea;
	private String naziv, urlSlike, urlVidea;
	private String godinaPremijere;
	public SearchedFilm(int idVidea,String naziv, String urlSlike, String urlVidea, String godinaPremijere) {
		super();
		this.naziv = naziv;
		this.urlSlike = urlSlike;
		this.urlVidea = urlVidea;
		this.idVidea = idVidea;
		this.godinaPremijere = godinaPremijere;
	}
	public SearchedFilm() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getUrlSlike() {
		return urlSlike;
	}
	public void setUrlSlike(String urlSlike) {
		this.urlSlike = urlSlike;
	}
	public String getUrlVidea() {
		return urlVidea;
	}
	public void setUrlVidea(String urlVidea) {
		this.urlVidea = urlVidea;
	}
	public String getGodinaPremijere() {
		return godinaPremijere;
	}
	public void setGodinaPremijere(String godinaPremijere) {
		this.godinaPremijere = godinaPremijere;
	}
	@Override
	public String toString() {
		return "SearchedFilm [idVidea=" + idVidea + ", naziv=" + naziv + ", urlSlike=" + urlSlike + ", urlVidea="
				+ urlVidea + ", godinaPremijere=" + godinaPremijere + "]";
	}
	

}
