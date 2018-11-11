package rs.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.model.DAO;
import rs.model.Korisnik;


@WebServlet("/Registracija")
public class ServletRegistracija extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletRegistracija() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ime=request.getParameter("ime");
		String prezime=request.getParameter("prezime");
		String username=request.getParameter("username");//KORISNICKO MORA BITI JEDINSTVENO
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String passP=request.getParameter("passP");//POTVRDA SIFRE
		
		if(ime!=null && ime.trim().length()>0 && prezime!=null && prezime.trim().length()>0 && username!=null && username.trim().length()>0 && email!=null && email.trim().length()>0 &&  pass!=null && pass.trim().length()>0 && passP!=null && passP.trim().length()>0 ) {
			DAO dao=new DAO();
			Korisnik user=dao.selectUserByUsername(username);
			if(user==null ) {
				  user= new Korisnik() ;
				user =dao.selectUserByEmail(email);
					if(user==null) {
						if(pass.equals(passP)) {
							 user=new Korisnik(ime, prezime, username, pass, email);
							dao.insertUser(user);
							request.setAttribute("succmsg", "uspesna registracija-ulogujte se");
							request.getRequestDispatcher("Logovanje.jsp").forward(request, response);//ILI TREBA SAMO REGISTRACIJA.JSP.??
		
						}else {
							request.setAttribute("errmsgr", "potvrdi sifru ");
							request.getRequestDispatcher("Registracija.jsp").forward(request, response);//ILI TREBA SAMO REGISTRACIJA.JSP.??
					
						}
					}else {
						request.setAttribute("errmsgr", "zauzeta email adresa ");
						request.getRequestDispatcher("Registracija.jsp").forward(request, response);//ILI TREBA SAMO REGISTRACIJA.JSP.??
				
					}
				
				
			}else {
				request.setAttribute("errmsgr", "zauzeto korisnicko ime");
				request.getRequestDispatcher("Registracija.jsp").forward(request, response);//ILI TREBA SAMO REGISTRACIJA.JSP.??
		
			}
		}else {
			request.setAttribute("errmsgr", "popunite sva polja");
			request.getRequestDispatcher("Registracija.jsp").forward(request, response);
		}
	}

}
