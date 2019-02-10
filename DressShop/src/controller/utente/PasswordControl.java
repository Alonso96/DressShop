package controller.utente;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.utente.UtenteBean;
import model.utente.UtenteModel;
import model.utente.UtenteModelDM;

/**
 * Servlet implementation class PasswordControl
 */
@WebServlet("/PasswordControl")
public class PasswordControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtenteModel<UtenteBean> model = new UtenteModelDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String action = request.getParameter("insP");
         System.out.println(action);
       
         int id = (int) (request.getSession().getAttribute("id"));
         	System.out.println("id utente è: " + id);
         	String password = request.getParameter("password");
         	try {
					try {
						model.doUpdatePassword(password, id);
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
         	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/area_utente.jsp");
			dispatcher.forward(request, response); // passo la chiamata alla jsp;
         
	}

	}


