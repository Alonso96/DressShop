package controller.prodotto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.prodotto.ProdottoBean;
import model.prodotto.ProdottoModelDM;

/**
 * Servlet implementation class CategoriaControl
 */
@WebServlet("/CategoriaControl")
public class CategoriaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
     ProdottoModelDM model = new ProdottoModelDM();
     Collection<ProdottoBean> lista = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubz
		String categoria =request.getParameter("categoria");
		try {
			  lista =model.doRetrieveByCategory(categoria);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("prodotti", lista);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ricercaProdotti.jsp");
		dispatcher.forward(request, response); // passo la chiamata alla jsp
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
