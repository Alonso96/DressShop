package controller;
import model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		Carrello<ProdottoInCarrello> cart = (Carrello<ProdottoInCarrello>)request.getSession().getAttribute("cart");
		ProdottoModel<ProdottoBean> model = new ProdottoInCatalogoModelDM();
		
		System.out.println("ciao1");
		 HttpSession session = request.getSession();
		 //String id = request.getSession().getId();
		 String name3 = (String)session.getAttribute("email");
		 if(name3==null) {
			 response.sendRedirect("login.jsp");
		 }
		 else 
		 {
		 if(session!=null) {
		
		 
		 
			
		 
		 
	
		 
		String name = (String)session.getAttribute("email");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(cart == null) {
		out.println("<h2>Inserisci prima qualcosa nel carrello</h2>");
		}
		
		System.out.println("Procedo...");
		String action = request.getParameter("action");
		if(action!=null) {
			 if(action.equalsIgnoreCase("ProcediAcquisto")) {
				 	if(cart!=null) {
				 		if(!(cart.isEmpty())) {
				 		/*	Iterator<?> it = cart.ottieniElem().iterator();
				 			while(it.hasNext()) {
				 				ProdottoInCarrello bean = (ProdottoInCarrello) it.next();
				 				try {
				 					model.doShop(bean, (String) request.getSession().getAttribute("name"));
				 				 *
				 				 * Inserire qui codice per l'acquisto
				 				 la riga di sotto è da cancellare 
				 				 * 
				 				 model.doRetrieveAll();
				 				} catch(SQLException e) {
				 					e.printStackTrace();
				 					
				 				}
				 				try {
				 					model.doUpdate(bean);
				 				} catch(SQLException e) {
				 					e.printStackTrace();
				 				}
				 				*/
				 			int id_utente = (int) request.getSession().getAttribute("id");
							IndirizzoBean indirizzo = (IndirizzoBean) request.getSession().getAttribute("indirizzo");
							int id_indirizzo = indirizzo.getId_indirizzo();
							CartaDiCreditoBean carta = (CartaDiCreditoBean) request.getSession().getAttribute("carta");
							String numero_carta = carta.getNumero_carta();
							try {
								cart.acquista(numero_carta, id_utente, id_indirizzo);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}				 			
							}
				 			
				 		}
				 		//query aggiornamento prodotti
				 	}
				}
		}
		
		if((request.getSession().getAttribute("email"))!=null) {
			request.getSession().setAttribute("cart1",cart);
			Carrello<ProdottoInCarrello> cart1= (Carrello<ProdottoInCarrello>) new Carrello();
			request.getSession().setAttribute("cart",cart1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AcquistoCompletato.jsp");
			dispatcher.forward(request, response);
			
		}
		else {
			response.sendRedirect("home.jsp");
		}
		
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
