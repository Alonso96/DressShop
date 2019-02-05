package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UtenteBean;
import model.UtenteModelDM;
import model.UtenteModel;

/**
 * Servlet implementation class RegistrationControl
 */
@WebServlet("/RegistrationControl")
public class RegistrationControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	 UtenteModel<UtenteBean> model = new UtenteModelDM();
	
    public RegistrationControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// empty	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// prendo il parametro action della form , che equivale al nome della servlet dd(?)
		        response.setContentType("text/html");
		        String action = request.getParameter("action");
		        System.out.println("Mi ha chiamato il bottone registrazione");
		        System.out.println(request.getParameter("nome"));
		        System.out.println(request.getParameter(action));
				PrintWriter out = response.getWriter();  
				
				try {
				if(action != null) {
				 
					String nome = request.getParameter("nome");
					String cognome = request.getParameter("cognome");
					String sDate= request.getParameter("data_nascita");
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/YY");
					Date   data_nascita=  (Date) format.parse(sDate);    
					String password = request.getParameter("password");
					String eMail = request.getParameter("email");					
					
				

						
				
						UtenteBean newUser = new UtenteBean();
						newUser.setNome(nome);
						newUser.setCognome(cognome);
						newUser.setEmail(eMail);
						newUser.setPassword(password);
						newUser.setData_nascita(data_nascita);
						newUser.setTipo(1);
						
						if(UtenteModelDM.checkUser(eMail)) {
							RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registrationFailed.jsp");
							dispatcher.forward(request, response);
						}
						else {	
						
						model.doSave(newUser);
						System.out.println("Ciao");
						}
						}
				
				
				else if(action==null){
					   out.print("<p style=\"color:red\">Spiacente registrazione fallita, riprova</p><br>");  
					    
					    
					    RequestDispatcher rd=request.getRequestDispatcher("registrationFailed.jsp");  
					    rd.include(request,response);  
					}
				
				}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registrationSuccess.jsp");
					dispatcher.forward(request, response);
				
				
				}
	}
	
	

