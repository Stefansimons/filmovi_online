package rs.model;

//vazni importi 
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.ArrayList;
public class DAO {
 private DataSource ds;

//DEFINICIJA KONEKCIONIH STRINGOVA
	
	
//USERS
 	private static String SELECTUSERNAMES = "SELECT username FROM korisnici";
	private static String SELECTUSERBYUSERNAME = "SELECT * FROM korisnici WHERE username = ? ";
	private static String INSERTUSER = "INSERT INTO korisnici( ime, prezime, username, password, email) VALUES (?,?,?,?,?)";
	private static String DELETEUSERBYUSERNAME = "DELETE FROM korisnici WHERE korisnici.username = ? ";
	private static String SELECTUSERBYUSERNAMEANDPASSWORD="SELECT * FROM korisnici WHERE username=? AND password=?";
	private static String SELECTUSERBYEMAIL="SELECT * FROM korisnici WHERE email=?";
//COMMENTARI
	private static String INSERTCOMMENTS = "INSERT INTO komentari(sadrzaj, id_videa, id_korisnika) VALUES (?,?,?)";
	private static String INSERTREPLY = "INSERT INTO komentari(sadrzaj, datum_objave, id_videa, id_korisnika, odgovor_na) VALUES (?,?,?,?,?)";
	private static String DELETEALLCOMMENTSBYUSERNAME = "DELETE komentari.* FROM komentari , korisnici WHERE korisnici.id = komentari.id_korisnika AND korisnici.username = ? ";
	private static String DELETECOMMENTBYPUBDATE = "DELETE FROM komentari WHERE komentari.datum_objave = ?";
	private static String SELECTCOMMENTSBYVIDEOID ="SELECT korisnici.username, komentari.sadrzaj, komentari.datum_objave, komentari.odgovor_na, komentari.id_korisnika, komentari.id_videa FROM komentari, videi, korisnici WHERE videi.id = komentari.id_videa AND korisnici.id = komentari.id_korisnika AND videi.id = ?  ";

//VIDEI
	private static String INSTERTVIDEO = "INSERT INTO videi(naziv_videa, url_videa) VALUES (?,?)";
	private static String DELETEVIDEOBYID = "DELETE  FROM  videi  WHERE id = ?";
	private static String UPDATEVIDEOBYID= "UPDATE videi SET naziv_videa = ?,url_videa=? WHERE id=?";
	private static String SELECTFILMBYVIDEOID="SELECT filmovi.*, videi.url_videa FROM videi,filmovi WHERE filmovi.id_videa=videi.id AND filmovi.id_videa=?";
	private static String SELECTVIDEOBYID="SELECT * FROM videi WHERE id=?";
	private static String SELECTVIDEOBYURL="SELECT * FROM videi WHERE url_videa=?";
	//FILMOVI
	private static String SELECTCATEGORIJEBYVIDEOID="SELECT zanrovi.naziv FROM videi,filmovi,zanrovi,zanr_videa WHERE filmovi.id_videa=videi.id AND videi.id=zanr_videa.id_videa AND zanr_videa.id_zanra=zanrovi.id AND filmovi.id_videa=?";
	private static String SEARCHFILMBYWORD = "SELECT filmovi.id_videa, filmovi.naziv, filmovi.godina_premijere, filmovi.url_slike, videi.url_videa FROM filmovi, videi WHERE filmovi.id_videa = videi.id AND filmovi.naziv REGEXP ? ORDER BY filmovi.naziv ASC ";
	private static String SEARCHFILMBYCATEGORY = "SELECT filmovi.id_videa, filmovi.naziv, filmovi.godina_premijere, filmovi.url_slike, videi.url_videa FROM filmovi, videi, zanrovi, zanr_videa WHERE filmovi.id_videa = videi.id AND videi.id = zanr_videa.id_videa AND zanrovi.id = zanr_videa.id_zanra AND zanrovi.naziv = ? ORDER BY filmovi.datum_postavljanja DESC ";
	private static String SELECTALLFILMS = "SELECT filmovi.id_videa, filmovi.naziv, filmovi.godina_premijere, filmovi.url_slike, videi.url_videa FROM filmovi, videi WHERE filmovi.id_videa = videi.id ORDER BY filmovi.datum_postavljanja DESC ";
	private static String SELECTFILM = "SELECT filmovi.* FROM filmovi, videi WHERE videi.id = filmovi.id_videa AND filmovi.id_videa = ? ";
	private static String UPDATEFILMBYIDVIDEO="UPDATE filmovi SET naziv=?,drzava=?,glumci=?,godina_premijere=?,reziser=?,vreme_trajanja=?,url_slike=?,url_prevoda=?,opis=?,jezik=?,id_videa=? WHERE id_videa=?";
	private static String INSERTFILM = "INSERT INTO filmovi(naziv, drzava, glumci, godina_premijere, reziser,vreme_trajanja, url_slike, url_prevoda, opis, jezik, id_videa) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static String DELETEFILMBYIDVIDEA = "DELETE FROM filmovi WHERE id_videa=?";
	private static String SELECTFILMBYKATEGORIJA="SELECT filmovi.id_videa, filmovi.naziv, filmovi.godina_premijere, filmovi.url_slike, videi.url_videa, zanrovi.naziv FROM filmovi, videi, zanrovi, zanr_videa WHERE filmovi.id_videa = videi.id AND videi.id = zanr_videa.id_videa AND zanrovi.id = zanr_videa.id_zanra AND zanrovi.id = ? ORDER BY filmovi.datum_postavljanja DESC";
	private static String SELECTFILMBYID="SELECT * FROM filmovi WHERE id=?";
	private static String SELECTFILMOVI="SELECT * FROM filmovi";
	
//CATEGORIJE
	private static String INSERTKATEGORIJA = "INSERT INTO zanrovi( naziv) VALUES (?)";
	private static String DELETECATEGORYBYID = "DELETE FROM zanrovi WHERE id=?";
	private static String SELECTALLKATEGORIJE="SELECT * FROM zanrovi ";
	private static String GETKATEGORIJABYIDKAT="SELECT * FROM zanrovi WHERE id=?";
	private static String UPDATEKATEGORIJABYID="UPDATE zanrovi SET naziv=? WHERE id=?";
	private static String GETKATEGORIJABYNAZIV="SELECT * FROM zanrovi WHERE naziv=?"; 
			
//FILMCATEGORIJA
	private static String INSERTFILMCATEGORIJA = "INSERT INTO zanr_videa(id_videa, id_zanra) VALUES (?,?)";
	private static String DELETEVIDEOKATEGORIJA="DELETE FROM zanr_videa WHERE id_videa=?";
	// DEFINICIJA KONSTRUKTORA ZA PODESAVNJE KONEKCIJE – UVEK ISTO
	public DAO(){
	try {
		InitialContext cxt = new InitialContext();
		if ( cxt == null ) { 
		} 
		ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/mysql" ); 
		if ( ds == null ) { 
		} 		
		} catch (NamingException e) {
		}
	}
	public ArrayList<KorisnikVideoKomentar> selectcommentsByVideoId(int id){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<KorisnikVideoKomentar> lk = new ArrayList<>();
		KorisnikVideoKomentar komentar = null;
				
	   try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTCOMMENTSBYVIDEOID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setInt(1, id);
			pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				komentar = new KorisnikVideoKomentar();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				komentar.setSadrzaj(rs.getString("sadrzaj"));
				komentar.setDatumObjave(rs.getDate("datum_objave"));
				komentar.setIdOdgovora(rs.getInt("odgovor_na"));
				komentar.setIdKorisnika(rs.getInt("id_korisnika"));
				komentar.setIdVidea(rs.getInt("id_videa"));
				komentar.setUsername(rs.getString("username"));

				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lk.add(komentar);
			}
	//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return lk; 
	}
	public Korisnik selectUserByUsername(String username){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		Korisnik pom = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTUSERBYUSERNAME);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, username);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new Korisnik();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setId(rs.getInt("id"));
				pom.setIme(rs.getString("ime"));
				pom.setPrezime(rs.getString("prezime"));
				pom.setUsername(rs.getString("username"));
				pom.setEmail(rs.getString("email"));
				pom.setPassword(rs.getString("password"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return pom;
	}
	public Video selectVideoByid(int id){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		Video pom = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTVIDEOBYID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setInt(1, id);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new Video();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setId(rs.getInt("id"));
			
				pom.setNaziv(rs.getString("naziv_videa"));
				pom.setUrlVidea(rs.getString("url_videa"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return pom;
	}
	public Video selectVideoByUrl(String urlVidea){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		Video pom = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTVIDEOBYURL);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, urlVidea);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new Video();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setId(rs.getInt("id"));
			
				pom.setNaziv(rs.getString("naziv_videa"));
				pom.setUrlVidea(rs.getString("url_videa"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return pom;
	}
	public ArrayList<Zanr> selectKategorijeByIdVidea(int id){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Zanr> lz=new ArrayList<>();
		Zanr pom = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTCATEGORIJEBYVIDEOID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setInt(1, id);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new Zanr();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
			
				pom.setNaziv(rs.getString("naziv"));
				
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lz.add(pom);
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return lz;
	}
	public Zanr getKategorijaById(int id_kat){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		Zanr pom = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETKATEGORIJABYIDKAT);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setInt(1, id_kat);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new Zanr();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setId(rs.getInt("id"));
				pom.setNaziv(rs.getString("naziv"));
				
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return pom;
	}
	public Zanr getKategorijaByNaziv(String naziv){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		Zanr pom = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETKATEGORIJABYNAZIV);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, naziv);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new Zanr();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setId(rs.getInt("id"));
				pom.setNaziv(rs.getString("naziv"));
				
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return pom;
	}
	public Korisnik selectUserByUsernameAndPass(String username,String password){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		Korisnik pom = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTUSERBYUSERNAMEANDPASSWORD);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, username);
			pstm.setString(2, password);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new Korisnik();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setId(rs.getInt("id"));
				pom.setIme(rs.getString("ime"));
				pom.setPrezime(rs.getString("prezime"));
				pom.setUsername(rs.getString("username"));
				pom.setEmail(rs.getString("email"));
				pom.setPassword(rs.getString("password"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return pom;
	}
	public Korisnik selectUserByEmail(String email){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		Korisnik pom = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTUSERBYEMAIL);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, email);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new Korisnik();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setId(rs.getInt("id"));
				pom.setIme(rs.getString("ime"));
				pom.setPrezime(rs.getString("prezime"));
				pom.setUsername(rs.getString("username"));
				pom.setEmail(rs.getString("email"));
				pom.setPassword(rs.getString("password"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return pom;
	}
	public void insertUser(Korisnik k){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		Korisnik pom = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(INSERTUSER);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.setString(1, k.getIme());
			pstm.setString(2, k.getPrezime());
			
			pstm.setString(3, k.getUsername());
			pstm.setString(4, k.getPassword());
			pstm.setString(5, k.getEmail());
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		
	}
	public void insertVideo(Video v){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		Korisnik pom = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(INSTERTVIDEO);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.setString(1, v.getNaziv());
			pstm.setString(2, v.getUrlVidea());
			
		
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		
	}
	public void insertFilm(Film f){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		Korisnik pom = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(INSERTFILM);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.setString(1, f.getNaziv());
			pstm.setString(2, f.getDrzava());
			pstm.setString(3,f.getGlumci());
			pstm.setString(4, f.getGodinaPremijere());
			
			pstm.setString(5, f.getReziser());
			pstm.setString(6, f.getVremeTrajanja());
			pstm.setString(7, f.getUrlSlike());
			pstm.setString(8, f.getUrlPrevoda());
			pstm.setString(9, f.getOpis());
			pstm.setString(10, f.getJezik());
			pstm.setInt(11, f.getIdVidea());

			
		
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		
	}
	public ArrayList<Zanr> getZanrovi(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Zanr> lz=new ArrayList<>();
		Zanr pom = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTALLKATEGORIJE);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new Zanr();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setId(rs.getInt("id"));
				pom.setNaziv(rs.getString("naziv"));
				
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lz.add(pom);
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return lz;
	}
	public ArrayList<FilmVideoKategorija> selectFilmByKategorija(int id_kat){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<FilmVideoKategorija> lista=new ArrayList<>();
		FilmVideoKategorija pom = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTFILMBYKATEGORIJA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setInt(1, id_kat);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new FilmVideoKategorija();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setId_videa(rs.getInt("id_videa"));
				pom.setNazivFilma(rs.getString("filmovi.naziv"));
				pom.setGodinaPremijere(rs.getString("godina_premijere"));
				pom.setUrlSlike(rs.getString("url_slike"));
				pom.setUrlVidea(rs.getString("url_videa"));
				pom.setNazivZanra(rs.getString("zanrovi.naziv"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lista.add(pom);
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return lista;
	}
	
	public FilmVideoKategorija selectFilmByVideoId(int id_video){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
		FilmVideoKategorija pom = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTFILMBYVIDEOID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setInt(1, id_video);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new FilmVideoKategorija();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setId_videa(rs.getInt("id_videa"));
				pom.setNazivFilma(rs.getString("naziv"));
				pom.setGodinaPremijere(rs.getString("godina_premijere"));
				pom.setDrzava(rs.getString("drzava"));
				pom.setJezik(rs.getString("jezik"));
				pom.setGlumci(rs.getString("glumci"));
				pom.setDatumPostavljanja(rs.getDate("datum_postavljanja"));
				pom.setReziser(rs.getString("reziser"));
		
				pom.setVremeTrajanja(rs.getString("vreme_trajanja"));
				pom.setUrlSlike(rs.getString("url_slike"));
				pom.setUrlVidea(rs.getString("url_videa"));
				pom.setUrlPrevoda(rs.getString("url_prevoda"));
				pom.setOpis(rs.getString("opis"));
				pom.setId_filma(rs.getInt("id"));
				
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return pom;
	}
	public void deleteVideoById(int id){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
				
	   try {
			con = ds.getConnection();
			pstm = con.prepareStatement(DELETEVIDEOBYID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setInt(1, id);
			pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 

	//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT

	}
	public void deleteFilmByIdVidea(int id){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
				
	   try {
			con = ds.getConnection();
			pstm = con.prepareStatement(DELETEFILMBYIDVIDEA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setInt(1, id);
			pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 

	//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT

	}
	public void deleteKategorijaById(int id){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
				
	   try {
			con = ds.getConnection();
			pstm = con.prepareStatement(DELETECATEGORYBYID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setInt(1, id);
			pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 

	//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT

	}
	public void updateKategorijaById(String naziv,int id){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
				
	   try {
			con = ds.getConnection();
			pstm = con.prepareStatement(UPDATEKATEGORIJABYID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, naziv);
			pstm.setInt(2, id);
			pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 

	//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT

	}
	public void insertKategorija(Zanr z){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
				
	   try {
			con = ds.getConnection();
			pstm = con.prepareStatement(INSERTKATEGORIJA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, z.getNaziv());
			
			pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 

	//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT

	}
	public void insertFilmKategorija(int id_videa,int id_kat){
		Connection con = null;
		PreparedStatement pstm = null;
		
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
				
	   try {
			con = ds.getConnection();
			pstm = con.prepareStatement(INSERTFILMCATEGORIJA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setInt(1, id_videa);
			pstm.setInt(2, id_kat);
			pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 

	//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT

	}
	public Film selectFilmByid(int idf){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
		Film pom = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTFILMBYID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setInt(1, idf);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new Film();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setNaziv(rs.getString("naziv"));
				
				pom.setDatumPostavljanja(rs.getDate("datum_postavljanja"));
				pom.setDrzava(rs.getString("drzava"));
				pom.setGlumci(rs.getString("glumci"));
				pom.setGodinaPremijere(rs.getString("godina_premijere"));
				
				pom.setIdVidea(rs.getInt("id_videa"));
				pom.setJezik(rs.getString("jezik"));
				
				pom.setOpis(rs.getString("opis"));
				pom.setReziser(rs.getString("reziser"));
				
				pom.setUrlPrevoda(rs.getString("url_prevoda"));
				pom.setUrlSlike(rs.getString("url_slike"));
				pom.setVremeTrajanja(rs.getString("vreme_trajanja"));
				pom.setId(rs.getInt("id"));
			
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return pom;
	}
	public ArrayList<Film> getFilmovi(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Film> lf=new ArrayList<>();
		Film pom = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTFILMOVI);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new Film();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setNaziv(rs.getString("naziv"));
			
				pom.setDatumPostavljanja(rs.getDate("datum_postavljanja"));
				pom.setDrzava(rs.getString("drzava"));
				pom.setGlumci(rs.getString("glumci"));
				pom.setGodinaPremijere(rs.getString("godina_premijere"));
				pom.setId(rs.getInt("id"));
				pom.setIdVidea(rs.getInt("id_videa"));
				pom.setJezik(rs.getString("jezik"));
				
				pom.setOpis(rs.getString("opis"));
				pom.setReziser(rs.getString("reziser"));
				
				pom.setUrlPrevoda(rs.getString("url_prevoda"));
				pom.setUrlSlike(rs.getString("url_slike"));
				pom.setVremeTrajanja(rs.getString("vreme_trajanja"));
				pom.setId(rs.getInt("id"));
				pom.setIdVidea(rs.getInt("id_videa"));
				pom.setJezik(rs.getString("jezik"));

				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lf.add(pom);
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return lf;
	}
	public ArrayList<SearchedFilm> selectFilmoviByDatumPostavljanja(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<SearchedFilm> lf=new ArrayList<>();
		SearchedFilm pom = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTALLFILMS);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new SearchedFilm();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setNaziv(rs.getString("naziv"));

				pom.setGodinaPremijere(rs.getString("godina_premijere"));

				pom.setIdVidea(rs.getInt("id_videa"));

				pom.setUrlSlike(rs.getString("url_slike"));

				pom.setIdVidea(rs.getInt("id_videa"));

				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lf.add(pom);
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return lf;
	}
	public void updateFilmByVideoID(FilmVideoKategorija film,int id_videa){
		Connection con = null;
		PreparedStatement pstm = null;
		
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
				
	   try {
			con = ds.getConnection();
			pstm = con.prepareStatement(UPDATEFILMBYIDVIDEO);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, film.getNazivFilma());
			pstm.setString(2, film.getDrzava());
			pstm.setString(3, film.getGlumci());
			pstm.setString(4, film.getGodinaPremijere());
			pstm.setString(5, film.getReziser());
			pstm.setString(6, film.getVremeTrajanja());
			pstm.setString(7, film.getUrlSlike());
			pstm.setString(8, film.getUrlPrevoda());
			pstm.setString(9, film.getOpis());
			pstm.setString(10, film.getJezik());
			pstm.setInt(11, film.getId_videa());
			pstm.setInt(12, id_videa);
			pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 

	//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT

	}
	public void insertKomentar(KorisnikVideoKomentar kom){
		Connection con = null;
		PreparedStatement pstm = null;
		
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
				
	   try {
			con = ds.getConnection();
			pstm = con.prepareStatement(INSERTCOMMENTS);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, kom.getSadrzaj());
			
			pstm.setInt(2, kom.getIdVidea());
			pstm.setInt(3, kom.getIdKorisnika());
			
			pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 

	//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT

	}
	public void deleteVideoKategorijaByIdVideo(int id_videa){
		Connection con = null;
		PreparedStatement pstm = null;
		
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
				
	   try {
			con = ds.getConnection();
			pstm = con.prepareStatement(DELETEVIDEOKATEGORIJA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
		
		
			pstm.setInt(1, id_videa);
			pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 

	//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT

	}
	public void updateVideoByID(Video v,int id_videa){
		Connection con = null;
		PreparedStatement pstm = null;
		
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
				
	   try {
			con = ds.getConnection();
			pstm = con.prepareStatement(UPDATEVIDEOBYID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, v.getNaziv());
			pstm.setString(2, v.getUrlVidea());
			pstm.setInt(3, id_videa);
		
			pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 

	//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT

	}
	public ArrayList<FilmVideoKategorija> SearchFilm(String word){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<FilmVideoKategorija> lf = new ArrayList<>();
		FilmVideoKategorija film = null;
				
       try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SEARCHFILMBYWORD);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, "(^|[[:space:]])"+ word +"([[:space:]]|$)");
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				film = new FilmVideoKategorija();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				film.setId_videa(rs.getInt("id_videa"));
				film.setNazivFilma(rs.getString("naziv"));
				film.setUrlSlike(rs.getString("url_slike"));
				film.setUrlVidea(rs.getString("url_videa"));
				film.setGodinaPremijere(rs.getString("godina_premijere"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lf.add(film);
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return lf;
	}

}
