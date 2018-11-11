package rs.model;

public class Video {
	private int id;
	private String urlVidea;
	private String naziv;
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	@Override
	public String toString() {
		return "Video [id=" + id + ", urlVidea=" + urlVidea + ", naziv=" + naziv + "]";
	}
	
	public Video(String urlVidea, String naziv) {
		super();
		this.urlVidea = urlVidea;
		this.naziv = naziv;
	}
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrlVidea() {
		return urlVidea;
	}
	public void setUrlVidea(String urlVidea) {
		this.urlVidea = urlVidea;
	}
	
}
