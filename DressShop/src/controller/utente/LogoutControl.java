package controller.utente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutControl")
public class LogoutControl extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getSession().removeAttribute("tipo");
		request.getSession().setAttribute("tipo", 0);
		request.getSession().removeAttribute("id");
		request.getSession().setAttribute("id", null);
		request.getSession().removeAttribute("email");
		request.getSession().setAttribute("email", null);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response); // passo la chiamata alla jsp
	}
}
