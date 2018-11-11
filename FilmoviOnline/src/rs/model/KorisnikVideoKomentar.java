package rs.model;

import java.sql.Date;

public class KorisnikVideoKomentar  {
	
	private String  username;

	private String urlVidea;
	
	private int   idVidea,  idOdgovora, idKorisnika;
	private String sadrzaj;
    private Date datumObjave;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUrlVidea() {
		return urlVidea;
	}
	public void setUrlVidea(String urlVidea) {
		this.urlVidea = urlVidea;
	}
	
	public int getIdVidea() {
		return idVidea;
	}
	public void setIdVidea(int idVidea) {
		this.idVidea = idVidea;
	}
	public int getIdOdgovora() {
		return idOdgovora;
	}
	public void setIdOdgovora(int idOdgovora) {
		this.idOdgovora = idOdgovora;
	}
	public int getIdKorisnika() {
		return idKorisnika;
	}
	public void setIdKorisnika(int idKorisnika) {
		this.idKorisnika = idKorisnika;
	}
	public String getSadrzaj() {
		return sadrzaj;
	}
	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}
	
	public Date getDatumObjave() {
		return datumObjave;
	}
	public void setDatumObjave(Date datumObjave) {
		this.datumObjave = datumObjave;
	}
	
	public KorisnikVideoKomentar(String username, String urlVidea, int lajk, int dislajk, int idVidea, int idOdgovora,
			int idKorisnika, String sadrzaj) {
		super();
		this.username = username;
		this.urlVidea = urlVidea;
		
		this.idVidea = idVidea;
		this.idOdgovora = idOdgovora;
		this.idKorisnika = idKorisnika;
		this.sadrzaj = sadrzaj;
	}
	public KorisnikVideoKomentar() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
