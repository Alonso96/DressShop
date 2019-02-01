package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carta;
import model.Query;
import model.Utente;

@WebServlet("/MostraCarte")
public class MostraCarte extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MostraCarte() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		synchronized(session)
	    {
	    	Utente utente=(Utente) session.getAttribute("utente");
	    	if(utente==null)
	    	{
	    		request.getRequestDispatcher("login.jsp").forward(request, response);
	    	}
	    	else
	    	{
	    		try {
					ArrayList<Carta> carte=Query.RestiuisciCarte(utente.getUsername());
					if(carte!=null)
					{
						session.setAttribute("carte", carte);
					}
					request.getRequestDispatcher("MostraCarte.jsp").forward(request, response);
				} catch (SQLException e) {
					request.getRequestDispatcher("MostraCarte.jsp").forward(request, response);
					e.printStackTrace();
				}
	    	}
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
