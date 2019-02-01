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

import model.Acquisto;
import model.Query;
import model.Utente;

@WebServlet("/VisualizzaProdottiFattura")
public class VisualizzaProdottiFattura extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VisualizzaProdottiFattura() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		synchronized (session) 
		{
			Utente utente=(Utente) session.getAttribute("utente");
			if(utente==null)
			{
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else
			{
				int id_fattura=Integer.parseInt(request.getParameter("id_fattura"));
				try {
					ArrayList<Acquisto> acquisti=Query.restiuisciAcquistiFattura(id_fattura);
					request.setAttribute("acquisti", acquisti);
					request.getRequestDispatcher("VisualizzaAcquistiFattura.jsp").forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
