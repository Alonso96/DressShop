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

@WebServlet("/SezioneTipoProdotto")
public class SezioneTipoProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SezioneTipoProdotto() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		synchronized (session) 
		{

				String tipo=request.getParameter("tipo");
				try {
					ArrayList<Film> films=Query.restiuisciFilmTipo(tipo);
					request.setAttribute("film", films);
					request.setAttribute("tipo", tipo);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("sezioneTipoProdotto.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
