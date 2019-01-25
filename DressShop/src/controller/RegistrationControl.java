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
					String firstName = request.getParameter("firstName");
					String lastName = request.getParameter("lastName");
					String userName = request.getParameter("userName");
								
					String password = request.getParameter("password");
					String eMail = request.getParameter("email");	
					String cap = request.getParameter("cap");
					String city = request.getParameter("city");
					String address = request.getParameter("address");
				
					
				

						//response.setContentType("text/html");
				
						UserBean newUser = new UserBean();
						newUser.setFirstName(firstName);
						newUser.setLastName(lastName);
						newUser.setUserName(userName);
						newUser.seteMail(eMail);
						newUser.setCap(cap);
						newUser.setPassword(password);
						newUser.setCity(city);
						newUser.setAddress(address);
						
						if(UserBeanDM.checkUser(userName)) {
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
	
	

