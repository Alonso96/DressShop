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

import model.Film;
import model.Query;
import model.Utente;

@WebServlet("/VisualizzaProdotto")
public class VisualizzaProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VisualizzaProdotto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codice_film= request.getParameter("codice_film");
		Film film= new Film();
		try {
			film=(Film) Query.restituisciFilm(codice_film);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		session.setAttribute("prodotto", film);
		request.getRequestDispatcher("visualizzaProdotto.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
