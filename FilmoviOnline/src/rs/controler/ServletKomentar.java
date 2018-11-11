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
import rs.model.Korisnik;
import rs.model.KorisnikVideoKomentar;


@WebServlet("/Komentar")
public class ServletKomentar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletKomentar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String akcija=request.getParameter("akcija");
		if(akcija!=null && akcija.length()>0) {
			if(akcija.equals("komentar")) {
				HttpSession sesija=request.getSession();
				Korisnik ulogovani=(Korisnik)sesija.getAttribute("ulogovani");
				if(ulogovani!=null) {
					String idVidea = request.getParameter("videoId");
					String kom=request.getParameter("kom");
					if(kom!=null && kom.trim().length()>0) {
						try {
							int idV = Integer.parseInt(idVidea);
							DAO dao = new DAO();
							
							
							KorisnikVideoKomentar kvk=new KorisnikVideoKomentar();
							kvk.setSadrzaj(kom);
							kvk.setIdKorisnika(ulogovani.getId());
							kvk.setIdVidea(idV);
							
							dao.insertKomentar(kvk);
							
							ArrayList<KorisnikVideoKomentar> lk=dao.selectcommentsByVideoId(idV);
							
							sesija.setAttribute("komentari", lk);
							request.getRequestDispatcher("filmSesijaKorisnik.jsp").forward(request, response);
						}
						catch (Exception e) {
							request.setAttribute("errmsg", "Pogresan format");
							request.getRequestDispatcher("error.jsp").forward(request, response);
						}
					}else {
						request.setAttribute("errmsg", "Unesi komentar");
						request.getRequestDispatcher("filmSesijaKorisnik.jsp").forward(request, response);
				
					}
					
				}else {
					request.setAttribute("linkZaLog", "<a href= \"Logovanje.jsp\"> LOGIN</a> ");
					request.setAttribute("msglog", "Morate se prvo ulogovati");
					request.getRequestDispatcher("film.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("errmsg", "Pogresna akcija");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				}
		}else {
			response.sendRedirect("index.jsp");
		}
	}

}
