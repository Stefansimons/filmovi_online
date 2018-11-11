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
import rs.model.FilmVideoKategorija;
import rs.model.Korisnik;
import rs.model.Zanr;


@WebServlet("/Kategorija")
public class ServletKategorija extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletKategorija() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_kat=request.getParameter("id");
		if(id_kat!=null && id_kat.length()>0) {
			try {
				int idK=Integer.parseInt(id_kat);
				//KACIM SE NA BAZU...
				DAO dao=new DAO();
				//UZIMAM SVE FILMOVE IZ KATEGORIJE...
				Zanr z=dao.getKategorijaById(idK);
				ArrayList<Zanr> lz=dao.getZanrovi();
				HttpSession sesija=request.getSession();
				Korisnik ulogovani=(Korisnik)sesija.getAttribute("ulogovani");
				Korisnik admin=(Korisnik)sesija.getAttribute("admin");
				ArrayList<FilmVideoKategorija> lfvk=dao.selectFilmByKategorija(idK);
			/*	if(lfvk==null) {
					request.setAttribute("msg", "nema filmova iz odabrane kategorije");
					request.getRequestDispatcher("filmoviIzKategorije.jsp").forward(request, response);
				}*/
					
				if(ulogovani!=null) {
					if(lfvk!=null && lfvk.size()>0) {
						sesija.setAttribute("filmoviByKat", lfvk);
						
						sesija.setAttribute("zanrovi", lz);
						sesija.setAttribute("nazivZanra", z);
						request.getRequestDispatcher("filmoviIzKatSesija.jsp").forward(request, response);
					}else {
						request.setAttribute("msgk", "nema filmova iz odabrane kategorije");
						request.getRequestDispatcher("filmoviIzKatSesija.jsp").forward(request, response);
			
					}
				}else if(admin!=null){
					if(lfvk!=null && lfvk.size()>0) {
						sesija.setAttribute("filmoviByKat", lfvk);
						sesija.setAttribute("zanrovi", lz);
						sesija.setAttribute("nazivZanra", z);
						request.getRequestDispatcher("filmoviIzKatSesijaAdmin.jsp").forward(request, response);
					}else {
						request.setAttribute("msgk", "nema filmova iz odabrane kategorije");
						request.getRequestDispatcher("filmoviIzKatSesijaAdmin.jsp").forward(request, response);
						}
				}else {
					if (lfvk != null && lfvk.size() > 0) {
						sesija.setAttribute("filmoviByKat", lfvk);

						sesija.setAttribute("zanrovi", lz);
						sesija.setAttribute("nazivZanra", z);
						request.getRequestDispatcher("filmoviIzKategorije.jsp").forward(request, response);
					} else {
						sesija.setAttribute("filmoviByKat", lfvk);

						sesija.setAttribute("zanrovi", lz);
						sesija.setAttribute("nazivZanra", z);
				
						request.setAttribute("msgk", "nema filmova iz odabrane kategorije");
						request.getRequestDispatcher("filmoviIzKategorije.jsp").forward(request, response);
					}
								
					}
				} catch (Exception e) {
				request.setAttribute("errmsg", "Pogresan format");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}else {
			response.sendRedirect("index.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
