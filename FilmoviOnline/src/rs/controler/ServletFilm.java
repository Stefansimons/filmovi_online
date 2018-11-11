package rs.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.model.DAO;
import rs.model.Film;
import rs.model.FilmVideoKategorija;
import rs.model.Korisnik;
import rs.model.KorisnikVideoKomentar;
import rs.model.SearchedFilm;
import rs.model.Zanr;


@WebServlet("/Film")
public class ServletFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletFilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String akcija=request.getParameter("akcija");
		if (akcija!=null && akcija.length()>0) {
			if(akcija.equals("gledaj")) {
				String id_videa=request.getParameter("id_videa");
				try {
					int id_v=Integer.parseInt(id_videa);
					DAO dao=new DAO();
					FilmVideoKategorija fvk=dao.selectFilmByVideoId(id_v);
					ArrayList<Zanr> lz=dao.selectKategorijeByIdVidea(id_v);
					ArrayList<Zanr> filmKat=dao.selectKategorijeByIdVidea(id_v);
					
					ArrayList<KorisnikVideoKomentar> lk = dao.selectcommentsByVideoId(id_v);
					HttpSession sesija = request.getSession();
					sesija.setAttribute("film", fvk);
					sesija.setAttribute("kategorije", lz);
					sesija.setAttribute("filmKat", filmKat);
					sesija.setAttribute("komentari", lk);
					Korisnik ulogovani=(Korisnik)sesija.getAttribute("ulogovani");
					Korisnik admin=(Korisnik)sesija.getAttribute("admin");
					if(lk != null && lk.size() > 0) {
						
						if(ulogovani!=null) {
							request.getRequestDispatcher("filmSesijaKorisnik.jsp").forward(request, response);
						

						}else if(admin!=null) {
							request.getRequestDispatcher("filmSesijaAdmin.jsp").forward(request, response);
							
							
						}else {
							request.getRequestDispatcher("film.jsp").forward(request, response);
						}
					}
					else {
						if(ulogovani!=null) {
							request.setAttribute("msgkomentari", "Nema komentara");
							request.getRequestDispatcher("filmSesijaKorisnik.jsp").forward(request, response);
						

						}else if(admin!=null) {
							request.setAttribute("msgkomentari", "Nema komentara");
							request.getRequestDispatcher("filmSesijaAdmin.jsp").forward(request, response);
							
							
						}else {
							request.setAttribute("msgkomentari", "Nema komentara");
							request.getRequestDispatcher("film.jsp").forward(request, response);
							}
						}
					} catch (Exception e) {
						response.sendRedirect("404 error.html");	}
			}else if(akcija.equals("najnoviji")) {
				DAO dao=new DAO();
				ArrayList<SearchedFilm> najnoviji=dao.selectFilmoviByDatumPostavljanja();
				ArrayList<Zanr> lz=dao.getZanrovi();
				HttpSession sesija=request.getSession();
				Korisnik ulogovani=(Korisnik)sesija.getAttribute("ulogovani");
				Korisnik admin=(Korisnik)sesija.getAttribute("admin");
				if(ulogovani!=null) {
					
					sesija.setAttribute("zanrovi", lz);
					sesija.setAttribute("najnoviji", najnoviji);
					request.getRequestDispatcher("najnovijiFilmoviSesijaKorisnik.jsp").forward(request, response);
					
				}else if(admin!=null) {
					sesija.setAttribute("zanrovi", lz);
					sesija.setAttribute("najnoviji", najnoviji);
					request.getRequestDispatcher("najnovijiFilmoviSesijaAdmin.jsp").forward(request, response);
		
				}else {
					sesija.setAttribute("zanrovi", lz);
					sesija.setAttribute("najnoviji", najnoviji);
					request.getRequestDispatcher("najnovijiFilmovi.jsp").forward(request, response);
				
				}
				
			}
		}else {
			response.sendRedirect("404 error.html");	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String akcija=request.getParameter("akcija");
		
		
		if(akcija!=null && akcija.length()>0) {
			if(akcija.equals("search")) {
				String pageName=request.getParameter("pageName");
				String word=request.getParameter("word");
				HttpSession sesija=request.getSession();
				Korisnik ulogovani=(Korisnik)sesija.getAttribute("ulogovani");
				Korisnik admin=(Korisnik)sesija.getAttribute("admin");
			
			if(word!=null && word.trim().length()>0) {
				
				DAO dao=new DAO();
				ArrayList<FilmVideoKategorija> rezultatPretrage=dao.SearchFilm(word);
				if(rezultatPretrage!=null && rezultatPretrage.size()>0 ) {
					//request.setAttribute("pretraga",rezultatPretrage );
					
					if(ulogovani!=null) {
						request.setAttribute("pretraga",rezultatPretrage );
						request.getRequestDispatcher("rezultatiPretrageKorisnik.jsp").forward(request, response);
				

					}else if(admin!=null) {
						request.setAttribute("pretraga",rezultatPretrage );
						request.getRequestDispatcher("rezultatiPretrageAdmin.jsp").forward(request, response);

								
					}else {
						request.setAttribute("pretraga",rezultatPretrage );
						request.getRequestDispatcher("RezultatPretrage.jsp").forward(request, response);
					
					}
					
				}else {
					
					if(ulogovani!=null) {
						request.setAttribute("msgr", "nema rezultata");
						request.getRequestDispatcher("rezultatiPretrageKorisnik.jsp").forward(request, response);

					}else if(admin!=null) {
						request.setAttribute("msgr", "nema rezultata");
						
						request.getRequestDispatcher("rezultatiPretrageAdmin.jsp").forward(request, response);
	
					}else {
						request.setAttribute("msgr", "nema rezultata");
						
						request.getRequestDispatcher("RezultatPretrage.jsp").forward(request, response);
							
					}
					
					
					}
				
			
			}else {	
				if(ulogovani!=null) {
					
					request.setAttribute("msg", "Pretrazi");
					request.getRequestDispatcher(pageName).forward(request, response);
				}else if(admin!=null) {
					request.setAttribute("msg", "Pretrazi");
					request.getRequestDispatcher(pageName).forward(request, response);
			
				}else {
					request.setAttribute("msg", "Pretrazi");
					request.getRequestDispatcher(pageName).forward(request, response);
				
				}
				
				
				}
			
			}else {
				response.sendRedirect("404 error.html");
			}
			
		}else {
			response.sendRedirect("404 error.html");	}
	}

}
