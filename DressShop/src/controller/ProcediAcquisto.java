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
		Carrello<ProductBean> cart = (Carrello<ProductBean>)request.getSession().getAttribute("cart");
		ProductModel<ProductBean> model = new ProductModelDM();
		
		System.out.println("ciao1");
		 HttpSession session = request.getSession();
		 //String id = request.getSession().getId();
		 String name3 = (String)session.getAttribute("name");
		 if(name3==null) {
			 response.sendRedirect("Registration.html");
		 }
		 else 
		 {
		 if(session!=null) {
		
		 
		 
			
		 
		 
	
		 
		String name = (String)session.getAttribute("name");
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
				 		if((cart.ottieniElem().size())>0) {
				 			Iterator<?> it = cart.ottieniElem().iterator();
				 			while(it.hasNext()) {
				 				ProductBean bean = (ProductBean) it.next();
				 				try {
				 					model.doShop(bean, (String) request.getSession().getAttribute("name"));
				 				} catch(SQLException e) {
				 					e.printStackTrace();
				 					
				 				}
				 				try {
				 					model.doUpdateQuantità(bean);
				 				} catch(SQLException e) {
				 					e.printStackTrace();
				 				}
				 			}
				 			
				 		}
				 		//query aggiornamento prodotti
				 	}
				}
		}
		
		if((request.getSession().getAttribute("name"))!=null) {
			request.getSession().setAttribute("cart1",cart);
			Carrello<ProductBean> cart1= (Carrello<ProductBean>) new Carrello();
			request.getSession().setAttribute("cart",cart1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AcquistoCompletato.jsp");
			dispatcher.forward(request, response);
			
		}
		else {
			response.sendRedirect("home.jsp");
		}
		
		 }	else
				response.sendRedirect("home.jsp");
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
