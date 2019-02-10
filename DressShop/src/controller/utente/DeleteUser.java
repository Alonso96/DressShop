package controller.utente;
import model.*;
import model.utente.UtenteBean;
import model.utente.UtenteModel;
import model.utente.UtenteModelDM;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DeleteUser questa servlet cancella un utente
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static UtenteModel<UtenteBean> bean = new UtenteModelDM();


	public DeleteUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("id") != null){
			int id = (int) (request.getSession().getAttribute("id"));
			UtenteModel model = new UtenteModelDM();
			try {
				model.doDelete(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getSession().removeAttribute("tipo");
			request.getSession().setAttribute("tipo", 0);
			request.getSession().removeAttribute("id");
			request.getSession().setAttribute("id", null);
			request.getSession().removeAttribute("email");
			request.getSession().setAttribute("email", null);

		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response); // passo la chiamata alla jsp		
	}

 
}


