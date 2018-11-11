package rs.model;

import java.sql.Date;

public class Komentar {
	private int id,idVidea, idKorisnika, idOdgovora;
    private String sadrzaj;
    private Date datumObjave;
    
	public Komentar(int idVidea, int idKorisnika, String sadrzaj,
			Date datumObjave) {
		super();
		this.idVidea = idVidea;
		this.idKorisnika = idKorisnika;
		this.sadrzaj = sadrzaj;
		this.datumObjave = datumObjave;
	}
	public Komentar() {
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
	public int getIdKorisnika() {
		return idKorisnika;
	}
	public void setIdKorisnika(int idKorisnika) {
		this.idKorisnika = idKorisnika;
	}
	public int getIdOdgovora() {
		return idOdgovora;
	}
	public void setIdOdgovora(int idOdgovora) {
		this.idOdgovora = idOdgovora;
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
    
}
