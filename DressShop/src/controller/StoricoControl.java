package controller;

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

import model.Carrello;
import model.ProductBean;
import model.ProductModel;
import model.ProductModelDM;

/**
 * Servlet implementation class StoricoControl
 */
@WebServlet("/StoricoControl")
public class StoricoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoricoControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductModel<ProductBean> model = new ProductModelDM();
		System.out.println("ciao1");
		 HttpSession session = request.getSession();
		 //String id = request.getSession().getId();
		 if(session!=null) {
		
		 
		 
			
		 
		 
	
		 
		String name = (String)session.getAttribute("name");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		System.out.println("Caricamento dello storico...");
		try {
			request.removeAttribute("products");
			request.setAttribute("products", model.getStorico((String) request.getSession().getAttribute("name")));
			request.setAttribute("date",model.getStoricoData((String) request.getSession().getAttribute("name")));
		} catch(SQLException e) {
			System.out.println("Error: "+ e.getMessage());
			request.setAttribute("error", e.getMessage());
		}
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/storico.jsp");
		dispatcher.forward(request, response); // passo la chiamata alla jsp
		
	}
		 else
			 response.sendRedirect("home.jsp");
		
		 }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
