<%@page import="rs.model.KorisnikVideoKomentar"%>
<%@page import="rs.model.Video"%>
<%@page import="java.sql.Time"%>
<%@page import="rs.model.SearchedFilm"%>
<%@page import="rs.model.Film"%>
<%@page import="rs.model.FilmVideoKategorija"%>
<%@page import="rs.model.Zanr"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rs.model.Korisnik"%>
<%@page import="rs.model.DAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
DAO dao=new DAO();
/* FilmVideoKategorija fvk=dao.selectFilmByVideoId(5);
out.println(fvk.toString());
ArrayList<Zanr> lz=dao.selectKategorijeByIdVidea(5);

out.println(lz.toString()); */
 /*  FilmVideoKategorija f=dao.selectFilmByVideoId(1);


 out.print(f.toString());
 */
  /* Zanr z=dao.getNazivByIdKat(1);
 
 out.print(z); */
 /* ArrayList<Zanr> lz=dao.getZanrovi();
 for(Zanr pom:lz)	
	 out.print(pom); */
/* Korisnik admin=dao.selectUserByUsername("StefanAdmin");
out.print(admin.toString()); */
/* dao.deleteVideoById(18);
out.print("deleted"); */
/* Film f=dao.selectFilmByid(15);
out.print(f.toString()); */
/* ArrayList<SearchedFilm> lf=dao.selectFilmoviByDatumPostavljanja();
for(SearchedFilm f:lf){
	out.print(f.toString());
} */

/* Film f=new Film();
f.setNaziv("novi");
f.setDrzava("novi");
f.setGlumci("saasas");
f.setGodinaPremijere("2015");
f.setReziser("nke");
f.setUrlSlike("asas");
f.setUrlPrevoda("aaaaaaa");
//f.setVremeTrajanja(1 :56 :4);
f.setOpis("opisss");
f.setJezik("jezikkkk");
Time t=new Time(1,25,30);
/* f.setVremeTrajanja(t);
f.setIdVidea(20);
dao.updateFilmByVideoID(f, 20);
out.print("updated"); */

//Video v = dao.selectVideoByid(idv);
/* FilmVideoKategorija fv=new FilmVideoKategorija();
fv.setNazivFilma("aaaaaa");
fv.setReziser("ssssss");
fv.setOpis("ddddddd");

/* for(String kat:kategorija) {
	Zanr z=dao.getKategorijaByNaziv(kat);
	
	dao.insertFilmKategorija(idv, z.getId());
} */
	
/* fv.setDrzava("ffff");
fv.setGlumci("ggggg");
fv.setGodinaPremijere("2016");
fv.setVremeTrajanja("1:53:32");
//fv.setUrlVidea(urlVidea); OVO JE ZA UPDATE VIDEA
fv.setUrlSlike("hhhhh");
fv.setUrlPrevoda("jjjjj");
fv.setOpis("lllll");
fv.setJezik("ooooo");
fv.setId_videa(20);
//Video noviVideo=new Video(urlVidea, naziv);
//dao.updateVideoByID(noviVideo, 20);
/* dao.updateFilmByVideoID( fv,20);
out.print("updated"); */
/* Video novi=new Video("ASASASAS","NAZIV FILMA");
dao.updateVideoByID(novi, 20);
out.print("updated");  */
/* FilmVideoKategorija fv=dao.selectFilmByVideoId(20);
out.print(fv.toString()); */
/* ArrayList<FilmVideoKategorija> pr=dao.SearchFilm("nueve");
for(FilmVideoKategorija f:pr)
out.print(f.toString()); */

ArrayList<KorisnikVideoKomentar> lk=dao.selectcommentsByVideoId(5);
for(KorisnikVideoKomentar k:lk)
	out.print(k.toString());

 %>
</body>
</html>