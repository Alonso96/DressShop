package controller.acquisto;
import model.*;
import model.carrello.Carrello;
import model.indirizzo.IndirizzoBean;
import model.indirizzo.IndirizzoModel;
import model.indirizzo.IndirizzoModelDM;
import model.prodotto.ProdottoInCarrello;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcediAcquisto
 */
@WebServlet("/ProcediAcquisto")
public class ProcediAcquisto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcediAcquisto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Carrello<ProdottoInCarrello> cart = (Carrello<ProdottoInCarrello>)request.getSession().getAttribute("cart");
		IndirizzoModel model = new IndirizzoModelDM();
		HttpSession session = request.getSession();
		
		if((cart == null) || (cart.isEmpty())){
			RequestDispatcher dispatcher = request.getRequestDispatcher("carrello.jsp");
			dispatcher.forward(request, response);
			System.out.println("carrello nullo o vuoto");
		} else if(session.getAttribute("id") == null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		} else {
			int id = (int) session.getAttribute("id");
			Collection<IndirizzoBean> indirizzi = new ArrayList<IndirizzoBean>();
			System.out.println(id);
			try {
				indirizzi = model.doRetrieveByUtente(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("indirizzi", indirizzi);
			RequestDispatcher dispatcher = request.getRequestDispatcher("carrello_indirizzo.jsp");
			dispatcher.forward(request, response);			
		}
	}	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
