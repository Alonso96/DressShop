package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Query;
import model.Utente;

@WebServlet("/RimuoviCarta")
public class RimuoviCarta extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RimuoviCarta() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		synchronized (session) {
			Utente utente=(Utente)session.getAttribute("utente");
			if(utente==null)
			{
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			else
			{
				int carta=Integer.parseInt(request.getParameter("numero_carta"));
				try {
					Query.rimuoviCarta(carta, utente.getUsername());
					request.getRequestDispatcher("MostraCarte").forward(request, response);
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
