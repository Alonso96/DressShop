package controller.acquisto;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import model.carrello.Carrello;
import model.prodotto.ProdottoBean;
import model.prodotto.ProdottoInCarrello;
import model.prodotto.ProdottoModel;
import model.prodotto.ProdottoModelDM;

/**a
 * Servlet implementation class CartControl
 */
@WebServlet("/CartControl")
public class CartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProdottoModel<ProdottoBean> model = new ProdottoModelDM();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Carrello<ProdottoBean> cart = (Carrello<ProdottoBean>)request.getSession().getAttribute("cart");
		
		
		if(cart == null) {
			cart = new Carrello<ProdottoBean>();
			request.getSession().setAttribute("cart", cart);
		}
		
		String invia = request.getParameter("invia");
		System.out.println(invia);
		if(invia != null) {
			if(invia.equalsIgnoreCase("Aggiungi al carrello")) {
				System.out.println("ciao");
				ProdottoBean prod = (ProdottoBean) request.getSession().getAttribute("product");
				String taglia = (String) request.getParameter("beantype");
				System.out.println(taglia);
				ProdottoInCarrello prodotto = new ProdottoInCarrello(prod);
				prodotto.setQuantita(1);
				prodotto.setTaglia(taglia);
				cart.addProd(prodotto);
			} else if(invia.equalsIgnoreCase("rimuovi")) {
				int id = Integer.parseInt(request.getParameter("id"));
				cart.rimElemento(id);
				System.out.println("rimuovo elemento con id "+ id);
			}				
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response); // passo la chiamata alla jsp				
		}
		request.getSession().setAttribute("cart", cart);
		request.setAttribute("cart", cart);
				
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/carrello.jsp");
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
