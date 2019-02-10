package controller.utente;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.utente.UtenteBean;
import model.utente.UtenteModel;
import model.utente.UtenteModelDM;

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
	        int tipo;
	        String n=request.getParameter("email");  
	        String p=request.getParameter("password"); //
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
				session.setAttribute("nome", utente.getNome());
			
	        

	        try {
				if(UtenteModelDM.validate(n, p)){  
					tipo=UtenteModelDM.getTipo(n,p);
					session.setAttribute("tipo", tipo);
					System.out.println(tipo);	
					switch(tipo) {
					case(2) : // se utente magazziniere dcd
					
					session.setAttribute("tipo", 2);
					RequestDispatcher rd=request.getRequestDispatcher("/magazzinierePage.jsp");  
				    rd.forward(request,response);
					break;
					case(1): // se utente e' cliente
						session.setAttribute("tipo", 1);
					RequestDispatcher rd1=request.getRequestDispatcher("/index.jsp");  
				    rd1.forward(request,response);
					break;
					case(4)://se utente e' proprietario
						session.setAttribute("tipo", 4);
						RequestDispatcher rd2=request.getRequestDispatcher("/proprietarioPage.jsp");  
						rd2.forward(request,response);
						break;
							
					case (3):// se utente e' gestore marketing
						session.setAttribute("tipo", 3);
						RequestDispatcher rd3=request.getRequestDispatcher("/managerPage.jsp");  
					    rd3.forward(request,response);
						
						
					}
					}
					
				 
				else{  
				    out.print("<p style=\"color:red\">Spiacente E-Mail o password invalidi, riprova</p><br>");  
				    out.print("<p style=\"color:blue\">Nuovo utente? <a href=\"registrazione.jsp\">Registrati subito!</a> </br></p>");
				    session.removeAttribute("tipo");
				    session.invalidate();
				    RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
				    rd.include(request,response);  
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

	        out.close();  
	    }  

}
