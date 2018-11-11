package rs.model;

public class Zanr implements java.io.Serializable {
	
	private int id;
	private String naziv;
	public Zanr(String naziv) {
		super();
		this.naziv = naziv;
	}
	public Zanr() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	

}
