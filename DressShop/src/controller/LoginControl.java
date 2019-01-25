package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;
import model.UserBeanDM;
import model.UserModel;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static UserModel<UserBean> model = new UserBeanDM();
	
    public LoginControl() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");  
	        PrintWriter out = response.getWriter();  
	        int flag;
	        String n=request.getParameter("userName");  
	        String p=request.getParameter("password"); 
	        
	        
	        HttpSession session = request.getSession(false);
	        if(session!=null)
	        session.setAttribute("name", n);

	        try {
				if(UserBeanDM.validate(n, p)){  
					flag=UserBeanDM.getFlag(n,p );
					session.setAttribute("flag", String.valueOf(flag));
					if(flag==1) { // se utente è admin, cioe flag =1 vado su amministrazione
					System.out.println(flag);	
					RequestDispatcher rd=request.getRequestDispatcher("/amministrazione.jsp");  
					rd.forward(request,response);  
					}
					else { // altrimenti utente normale
				    RequestDispatcher rd=request.getRequestDispatcher("/userLogged.jsp");  
				    rd.forward(request,response);  
					}
				}  
				else{  
				    out.print("<p style=\"color:red\">Spiacente username o password invalidi, riprova</p><br>");  
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
