package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UtenteBean;
import model.UtenteModel;
import model.UtenteModelDM;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static UtenteModel<UtenteBean> model = new UtenteModelDM();
	
    public LoginControl() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");  
	        PrintWriter out = response.getWriter();  
	        String tipo;
	        String n=request.getParameter("eMail");  
	        String p=request.getParameter("password"); 
	        UtenteBean utente = new UtenteBean();
	        try {
				utente = model.doRetrieveByEmail(n);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	        
	        HttpSession session = request.getSession(false);
	        if(session!=null)
	        session.setAttribute("email", n);
	        
				session.setAttribute("id", utente.getId_utente()); //assegno l'id
			
	        

	        try {
				if(UtenteModelDM.validate(n, p)){  
					tipo=UtenteModelDM.getTipo(n,p);
					session.setAttribute("tipo", tipo);
					System.out.println(tipo);	
					switch(tipo) {
					case("mag") : // se utente magazziniere
					
					session.setAttribute("tipo", "mag");
					RequestDispatcher rd=request.getRequestDispatcher("/magazzinierePage.jsp");  
				    rd.forward(request,response);
					break;
					case("cli"): // se utente e' cliente
						session.setAttribute("tipo", "cli");
					RequestDispatcher rd1=request.getRequestDispatcher("/index.jsp");  
				    rd1.forward(request,response);
					break;
					case("pro")://se utente e' proprietario
						session.setAttribute("tipo", "prog");
						RequestDispatcher rd2=request.getRequestDispatcher("/proprietarioPage.jsp");  
						rd2.forward(request,response);
						break;
							
					case ("mkt"):// se utente e' gestore marketing
						session.setAttribute("tipo", "mkt");
						RequestDispatcher rd3=request.getRequestDispatcher("/managerPage.jsp");  
					    rd3.forward(request,response);
						
						
					}
					}
					
				 
				else{  
				    out.print("<p style=\"color:red\">Spiacente E-Mail o password invalidi, riprova</p><br>");  
				    out.print("<p style=\"color:blue\">Nuovo utente? <a href=\"Registration.html\">Registrati subito!</a> </br></p>");
				    session.invalidate();
				    RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
				    rd.include(request,response);  
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

	        out.close();  
	    }  

}
