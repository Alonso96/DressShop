package controller.acquisto;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import model.carrello.Carrello;
import model.carta.CartaDiCreditoBean;
import model.indirizzo.IndirizzoBean;

@WebServlet("/ConfermaAcquistoControl")
public class ConfermaAcquistoControl extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("c");
		IndirizzoBean indirizzo = new IndirizzoBean();
		CartaDiCreditoBean carta = new CartaDiCreditoBean();
		int utente;
		Carrello cart = new Carrello();
		
		if(request.getSession().getAttribute("indirizzo") != null){
			indirizzo = (IndirizzoBean) request.getSession().getAttribute("indirizzo");
		
			if(request.getSession().getAttribute("carta") != null){
				carta = (CartaDiCreditoBean) request.getSession().getAttribute("carta");
		
				if(request.getSession().getAttribute("id") != null){
					utente = (int) request.getSession().getAttribute("id");
		
					if(request.getSession().getAttribute("cart") != null){
						cart = (Carrello) request.getSession().getAttribute("cart");
						try {
							cart.acquista(carta.getNumero_carta(), utente, indirizzo.getId_indirizzo());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						request.getSession().removeAttribute("indirizzo");
						request.getSession().removeAttribute("carta");
						request.getSession().removeAttribute("cart");
						request.getSession().setAttribute("cart", cart);
						
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/acquisto_completato.jsp");
						dispatcher.forward(request, response); // passo la chiamata alla jsp
					}
					System.out.println("cart");
				}
				System.out.println("id");
			}
			System.out.println("carta");
		}
		System.out.println("indirizzo");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}
