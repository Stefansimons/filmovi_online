package rs.controler;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.model.DAO;
import rs.model.Film;
import rs.model.FilmVideoKategorija;
import rs.model.Video;
import rs.model.Zanr;


@WebServlet("/Admin")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String akcija=request.getParameter("akcija");
		if(akcija!=null && akcija.length()>0) {
			if(akcija.equals("brisanjeKategorije")) {
				String id=request.getParameter("id");
				try {
					int idkat=Integer.parseInt(id);
					DAO dao=new DAO();
					dao.deleteKategorijaById(idkat);
					ArrayList<Zanr> lz=dao.getZanrovi();
					if(lz!=null && lz.size()>0) {
						HttpSession sesija=request.getSession();
						sesija.setAttribute("zanrovi", lz);
						request.getRequestDispatcher("Svekategorije.jsp").forward(request, response);
					}else {
						request.setAttribute("msg", "nema kategorija");
						request.getRequestDispatcher("Svekategorije.jsp").forward(request, response);
					}
				} catch (Exception e) {
					request.setAttribute("errmsg", "Pogresan format");
					request.getRequestDispatcher("error.jsp").forward(request, response);
			
				}
				
			}else if(akcija.equals("izmenaKategorije")) {
				String id=request.getParameter("id");
				try {
					int idkat=Integer.parseInt(id);
					DAO dao=new DAO();
					Zanr z=dao.getKategorijaById(idkat);
					HttpSession sesija=request.getSession();
					sesija.setAttribute("zanr", z);
					request.getRequestDispatcher("izmenaKategorije.jsp").forward(request, response);
				} catch (Exception e) {
					request.setAttribute("errmsg", "Pogresan format");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}else if(akcija.equals("brisanjeFilma")){
				String idvidea=request.getParameter("id_v");//Id_videa iz filma
				try {
					int idv=Integer.parseInt(idvidea);
					
					DAO dao=new DAO();
					
					dao.deleteFilmByIdVidea(idv);//PRVO BRISEM FILM..
					dao.deleteVideoById(idv);//PA VIDEO POD ISTIM NAZIVOM
					dao.deleteVideoKategorijaByIdVideo(idv);
					ArrayList<Film> lf=dao.getFilmovi();
					if(lf!=null && lf.size()>0) {
						HttpSession sesija=request.getSession();
						sesija.setAttribute("filmovi", lf);
						request.getRequestDispatcher("SviFilmovi.jsp").forward(request, response);
					}else {
						request.setAttribute("msg", "nema filmova");
						request.getRequestDispatcher("SviFilmovi.jsp").forward(request, response);
					}
				} catch (Exception e) {
					response.sendRedirect("404 error.html");			
				}
			}else if(akcija.equals("izmenaFilma")) {
				String idvidea=request.getParameter("id_v");
				try {
					int idv=Integer.parseInt(idvidea);
					DAO dao=new DAO();
					
					FilmVideoKategorija fv=dao.selectFilmByVideoId(idv);//UPDATE-UJEM I VIDEO I FILM
					HttpSession sesija=request.getSession();
					sesija.setAttribute("film", fv);
					request.getRequestDispatcher("IzmenaFilmova.jsp").forward(request, response);
				} catch (Exception e) {
					request.setAttribute("errmsg", "Pogresan format");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}else if(akcija.equals("unosFilma")){
				DAO dao=new DAO();
				ArrayList<Zanr> lz=dao.getZanrovi();
				HttpSession sesija=request.getSession();
				sesija.setAttribute("zanrovi", lz);
				request.getRequestDispatcher("UnosFilmova.jsp").forward(request, response);;
			}else if(akcija.equals("filmovi")) {
				request.getRequestDispatcher("SviFilmovi.jsp").forward(request, response);
			}else if(akcija.equals("unosKategorije")) {
				request.getRequestDispatcher("UnosKategorija.jsp").forward(request, response);
			}else if(akcija.equals("kategorije")) {
				request.getRequestDispatcher("Svekategorije.jsp").forward(request, response);
			}else {
				response.sendRedirect("404 error.html");
			}
		}else {
			response.sendRedirect("404 error.html");
		/*	request.setAttribute("errmsg", "Greska");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		*/}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PARAMETAR ZA IZMENU KATEGORIJE
		String akcija=request.getParameter("akcija");//AKCIJE ZA IZMENU KATEGORIJE I IZMENU FILMA
		if(akcija!=null && akcija.length()>0) {
			if(akcija.equals("izmeni kategoriju")) {
				String naziv=request.getParameter("naziv");
				String id=request.getParameter("id");
				if(naziv!=null && naziv.trim().length()>0 ) {
					try {
						int idKat=Integer.parseInt(id);
						DAO dao=new DAO();
					
						dao.updateKategorijaById(naziv, idKat);
						ArrayList<Zanr> lz=dao.getZanrovi();
						HttpSession sesija=request.getSession();
						request.setAttribute("succmsg", "uspesna izmena kategorije");
						sesija.setAttribute("zanrovi", lz);
						request.getRequestDispatcher("Svekategorije.jsp").forward(request, response);

					} catch (Exception e) {
						request.setAttribute("errmsg", "Greska");
						request.getRequestDispatcher("error.jsp").forward(request, response);

				}
				}else {
					request.setAttribute("errmsg", "Unesi naziv kategorije");
					request.getRequestDispatcher("izmenaKategorije.jsp").forward(request, response);
				}
			}else if(akcija.equals("izmeni film")) {
				String naziv=request.getParameter("naziv");
				String reziser=request.getParameter("reziser");
				String opis=request.getParameter("opis");
				String[] kategorija=request.getParameterValues("kategorija");//ZA KATEGORIJU MI TREBA I TABELA ZANR VIDEO
				String drzava=request.getParameter("drzava");
				String glumci=request.getParameter("glumci");
				String godPremijere=request.getParameter("godina_premijere");
				String jezik=request.getParameter("jezik");
				String urlPrevoda=request.getParameter("url_prevoda");
				String urlSlike=request.getParameter("url_slike");
				String urlVidea=request.getParameter("url_videa");
				String vremeTrajanja=request.getParameter("vreme_trajanja");
				String id=request.getParameter("id");
				String idVidea=request.getParameter("id_videa");//FILM..HIDEN POLJE,NE UPDATE-UJE SE
				
				if(naziv!=null && naziv.trim().length()>0 && reziser!=null && reziser.length()>0 && opis!=null && opis.length()>0  && 
						drzava!=null && drzava.length()>0 && glumci!=null && glumci.length()>0 && godPremijere!=null && godPremijere.length()>0 && 
						jezik!=null && jezik.length()>0 && urlPrevoda!=null && urlPrevoda.length()>0 && urlSlike!=null && urlSlike.length()>0 && 
						urlVidea!=null && urlVidea.length()>0 && vremeTrajanja!=null && vremeTrajanja.length()>0 ) {
					try {
						int idv=Integer.parseInt(idVidea);
						//int idf=Integer.parseInt(id); //NE TREBA NI ZA STA
						int godpr=Integer.parseInt(godPremijere);
						
						if(godpr>=1900 && godpr<=2018) {
							DAO dao=new DAO();
							
							Video v = dao.selectVideoByid(idv);
							FilmVideoKategorija fv=new FilmVideoKategorija();
							
							fv.setId_videa(idv);//film-NE UPDATE-UJE SE
							fv.setNazivFilma(naziv);
							fv.setReziser(reziser);
							fv.setOpis(opis);
							
							for(String kat:kategorija) {
								Zanr z=dao.getKategorijaByNaziv(kat);
								
								dao.insertFilmKategorija(idv, z.getId());
							}
								
							fv.setDrzava(drzava);
							fv.setGlumci(glumci);
							fv.setGodinaPremijere(godPremijere);
							fv.setVremeTrajanja(vremeTrajanja);
						//	fv.setUrlVidea(urlVidea); OVO JE ZA UPDATE VIDEA
							fv.setUrlSlike(urlSlike);
							fv.setUrlPrevoda(urlPrevoda);
							fv.setOpis(opis);
							fv.setJezik(jezik);
							
							Video noviVideo=new Video(urlVidea, naziv);
						
							dao.updateFilmByVideoID( fv,idv);
							dao.updateVideoByID(noviVideo, idv);
							
							ArrayList<Film> lf = dao.getFilmovi();
							HttpSession sesija=request.getSession();
							sesija.setAttribute("filmovi", lf);
							request.setAttribute("succmsg", " uspesna izmena filma");
							request.getRequestDispatcher("SviFilmovi.jsp").forward(request, response);
			
						}else {
							request.setAttribute("errmsg", " godina premijere mora biti  broj izmedju 1900 i 2018");
							request.getRequestDispatcher("IzmenaFilmova.jsp").forward(request, response);
						}
					} catch (Exception e) {
						request.setAttribute("errmsg", " godina premijere mora biti ceo broj");
						request.getRequestDispatcher("IzmenaFilmova.jsp").forward(request, response);
					}
				}else {
					request.setAttribute("errmsg", "popuni sva polja");
					request.getRequestDispatcher("IzmenaFilmova.jsp").forward(request, response);
				}
				
				
				
				
				
			}else if(akcija.equals("unesi kategoriju")) {
				String naziv=request.getParameter("naziv");
				if(naziv!=null && naziv.trim().length()>0) {
					DAO dao=new DAO();
					Zanr z=new Zanr(naziv);
					dao.insertKategorija(z);
					ArrayList<Zanr> lz=dao.getZanrovi();
					HttpSession sesija=request.getSession();
					sesija.setAttribute("zanrovi", lz);
					request.setAttribute("succmsg", "uneta kategorija");
					request.getRequestDispatcher("Svekategorije.jsp").forward(request, response);
				}else {
					request.setAttribute("errmsg", "Unesi naziv kategorije");
					request.getRequestDispatcher("UnosKategorija.jsp").forward(request, response);
				}
			}else if(akcija.equals("unesi film")) {
				String urlVidea=request.getParameter("url_videa");
				String naziv=request.getParameter("naziv");
				String drzava=request.getParameter("drzava");
				String glumci=request.getParameter("glumci");
				String godPremijere=request.getParameter("godina_premijere");
				String reziser=request.getParameter("reziser");
				String vremeTrajanja=request.getParameter("vreme_trajanja");
				String urlSlike=request.getParameter("url_slike");
				String urlPrevoda=request.getParameter("url_prevoda");
				String opis=request.getParameter("opis");
				String jezik=request.getParameter("jezik");
				String[] kategorija=request.getParameterValues("kategorija");//ZA KATEGORIJU MI TREBA I TABELA ZANR VIDEO

				String id=request.getParameter("id");
				String idVidea=request.getParameter("id_videa");//FILM..HIDEN POLJE,NE UPDATE-UJE SE
				
			if(naziv!=null && naziv.trim().length()>0 && reziser!=null && reziser.length()>0 && opis!=null && opis.length()>0  && 
						drzava!=null && drzava.length()>0 && glumci!=null && glumci.length()>0 && godPremijere!=null && godPremijere.length()>0 && 
						jezik!=null && jezik.length()>0 && urlPrevoda!=null && urlPrevoda.length()>0 && urlSlike!=null && urlSlike.length()>0 && 
						urlVidea!=null && urlVidea.length()>0 && vremeTrajanja!=null && vremeTrajanja.length()>0 && kategorija!=null && kategorija.length>0) {
			
				
					try {
						int godPr = Integer.parseInt(godPremijere);
					//	int vrTrajanja=Integer.parseInt(vremeTrajanja);
						if(godPremijere.charAt(0) != '0') {
							if(godPremijere.length()==4) {
								if(godPr >1900 && godPr<=Calendar.getInstance().get(Calendar.YEAR)) {
									if(vremeTrajanja.charAt(0) != '0'  ) {
										
											DAO dao=new DAO();
											Video v=new Video(urlVidea, naziv);
											dao.insertVideo(v);
											Video v1=dao.selectVideoByUrl(urlVidea);
											Film f=new Film(v1.getId(), naziv, opis, glumci, reziser, drzava, jezik, urlSlike, urlPrevoda, godPremijere, vremeTrajanja);
											dao.insertFilm(f);
											for(String kat:kategorija) {
												Zanr z=dao.getKategorijaByNaziv(kat);
												
												dao.insertFilmKategorija(v1.getId(), z.getId());
											}
											ArrayList<Film>lf=dao.getFilmovi();
											HttpSession sesija=request.getSession();
											sesija.setAttribute("filmovi", lf);
										request.setAttribute("succmsg", "Uneli ste film");
										request.getRequestDispatcher("SviFilmovi.jsp").forward(request, response);
											
									
								}else {request.setAttribute("errmsg", "Vreme trajanja ne sme poceti sa 0 ");
								request.getRequestDispatcher("UnosFilmova.jsp").forward(request, response);

							}
								}else {
									request.setAttribute("errmsg", "Godina premijere mora biti veca od 1900 i ne sme biti veca  od sadasnje godine");
									request.getRequestDispatcher("UnosFilmova.jsp").forward(request, response);

								}
							
							}
							else {
								request.setAttribute("errmsg", "Godina premijere mora imati 4 cifre ");
								request.getRequestDispatcher("UnosFilmova.jsp").forward(request, response);

						}
					}else {request.setAttribute("errmsg", "Godina ne sme poceti sa 0 ");
					request.getRequestDispatcher("UnosFilmova.jsp").forward(request, response);

				}
						
						
					} catch (Exception e) {
						request.setAttribute("errmsg", "Godina premijere i vreme trajanja moraju  biti celi brojevi");
						request.getRequestDispatcher("UnosFilmova.jsp").forward(request, response);

					}
			
				
				
				
				
				
			}else {
				request.setAttribute("errmsg", "Popuni sva polja");
				request.getRequestDispatcher("UnosFilmova.jsp").forward(request, response);

			}
			}else  {
				request.setAttribute("errmsg", "Pogresna akcija");
				request.getRequestDispatcher("error.jsp").forward(request, response);

			}
		}else {
			request.setAttribute("errmsg", "Greska");
			request.getRequestDispatcher("error.jsp").forward(request, response);

		}
	}

}
