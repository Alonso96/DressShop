package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClienteBean;
import model.UserBean;
import model.UserBeanDM;
import model.UserModel;

/**
 * Servlet implementation class RegistrationControl
 */
@WebServlet("/RegistrationControl")
public class RegistrationControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	 UserModel<UserBean> model = new UserBeanDM();
	
    public RegistrationControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// empty	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// prendo il parametro action della form , che equivale al nome della servlet (?)
		
			
				String action = request.getParameter("action");
				try {
				if(action != null) {
					if(action.equalsIgnoreCase("registration")) { 
					String nome = request.getParameter("nome");
					String cognome = request.getParameter("cognome");
					String sDate= request.getParameter("data_nascita");
					Date data_nascita=(Date) new SimpleDateFormat("dd/MM/yy").parse(sDate);		
					String password = request.getParameter("password");
					String eMail = request.getParameter("eMail");	
					String cellulare=request.getParameter("cellulare");
				
					
				

						//response.setContentType("text/html");
				
						ClienteBean newUser = new ClienteBean();
						newUser.setNome(nome);
						newUser.setCognome(cognome);
						newUser.seteMail(eMail);
						newUser.setCellulare(cellulare);
						newUser.setPassword(password);
						newUser.setData_nascita(data_nascita);
						newUser.setTipo("cli");
						
						if(UserBeanDM.checkUser(eMail) == null) {
							RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registrationFailed.jsp");
							dispatcher.forward(request, response);
						}
						else {	
						
						model.saveUsers(newUser);
						System.out.println("Ciao");
						}
						}
				
				}
				else {
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registrationFailed.jsp");
					dispatcher.forward(request, response);
				}
				}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registrationSuccess.jsp");
					dispatcher.forward(request, response);
				
				
				}
	}
	
	

