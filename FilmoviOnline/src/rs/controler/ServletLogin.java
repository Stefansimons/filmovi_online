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
import rs.model.Korisnik;
import rs.model.SearchedFilm;
import rs.model.Zanr;

@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesija=request.getSession();
		sesija.invalidate();
		response.sendRedirect("index.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//KAD SE ULOGUJE ADMIN PROSLEDJUJEM GA NA STRANU ADMINISTRACIJA.JSP
		
		String username=request.getParameter("username");
		String pass=request.getParameter("pass");
		if(username!=null && username.trim().length()>0 && pass!=null && pass.length()>0) {
			DAO dao=new DAO();
			//AKO POSTOJI KORISNIK SA UNETIM PARAMETRIMA...
			Korisnik user=dao.selectUserByUsername(username);
			if(user!=null) {
				user=new Korisnik();
				user=dao.selectUserByUsernameAndPass(username, pass);
				if(user!=null) {
					if (user.getUsername().equals("StefanAdmin") && user.getPassword().equals("admin")) {
						HttpSession sesija=request.getSession();
						sesija.setAttribute("admin", user);
						ArrayList<Zanr> lz=dao.getZanrovi();
						ArrayList<Film> lf=dao.getFilmovi();
						ArrayList<SearchedFilm> lfnajnoviji=dao.selectFilmoviByDatumPostavljanja();
						sesija.setAttribute("zanrovi", lz);
						sesija.setAttribute("filmovi", lf);
						sesija.setAttribute("najnovijiFilmovi", lfnajnoviji);
						request.getRequestDispatcher("indexSesijaAdmin.jsp").forward(request, response);
					}else if(user.getUsername().equals("StefanAdmin") && !user.getPassword().equals("admin")) {//ili contains?
						request.setAttribute("errmsgl", "pogresna sifra");
						request.getRequestDispatcher("Logovanje.jsp").forward(request, response);
					}else {
						ArrayList<Zanr> lz=dao.getZanrovi();
						ArrayList<Film> lf=dao.getFilmovi();
						HttpSession sesija = request.getSession();
						sesija.setAttribute("ulogovani", user);
						sesija.setAttribute("filmovi", lf);
						sesija.setAttribute("zanrovi", lz);
						request.getRequestDispatcher("indexSesija.jsp").forward(request, response);
						}
				}else {
					request.setAttribute("errmsgl", "pogresan password");
					request.getRequestDispatcher("Logovanje.jsp").forward(request, response);

				}
			}else {
				request.setAttribute("errmsgl", "pogresan username");
				request.getRequestDispatcher("Logovanje.jsp").forward(request, response);

			}
		}else {
			request.setAttribute("errmsgl", "popunite oba polja");
			request.getRequestDispatcher("Logovanje.jsp").forward(request, response);
		}
	}

}
