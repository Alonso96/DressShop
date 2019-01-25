package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductBean;
import model.ProductModel;
import model.ProductModelDM;
import model.UserBean;
import model.UserBeanDM;

/**
 * Servlet implementation class AdminControl
 */
@WebServlet("/AdminControl")
public class AdminControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProductModel<ProductBean> model = new ProductModelDM();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	/*	Carrello<ProductBean> cart = (Carrello<ProductBean>)request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Carrello<ProductBean>();
			request.getSession().setAttribute("cart", cart);
		}
		
		*/
		String action = request.getParameter("action");
		
		try {
			if(action != null) {
				if(action.equalsIgnoreCase("detail")) {
					int id = Integer.valueOf(request.getParameter("id"));
					request.removeAttribute("product");
					request.setAttribute("product", model.doRetrieveByKey(id));
				} else if(action.equalsIgnoreCase("delete")) {
					int id = Integer.valueOf(request.getParameter("id"));
					model.doDelete(id);
				} else if(action.equalsIgnoreCase("insert")) {
					
					
					String codice= request.getParameter("Codice");
					String description= request.getParameter("description");
					String marca = request.getParameter("marca");
					float ivaV = Float.valueOf(request.getParameter("ivaV"));     //iva vendita;
					float prezzoV =Float.valueOf(request.getParameter("prezzoV")); //prezzovendita
					int codC= Integer.valueOf(request.getParameter("codC")); //codice categoria
					int quantity= Integer.valueOf(request.getParameter("quantity"));
					
					
					ProductBean bean = new ProductBean();
					bean.setCodice(codice);
					bean.setDescription(description);
					bean.setMarca(marca);
					bean.setPrezzoV(ivaV);
					bean.setIvaV(prezzoV);
					bean.setCodC(codC);
					bean.setQuantity(quantity);
					
					model.doSave(bean);
					
				} 
			}
		} catch(SQLException e) {
			System.out.println("Error: "+ e.getMessage());
			request.setAttribute("error", e.getMessage());
		}
		
	
		
		
		String sort = request.getParameter("sort");
		
		try {
			request.removeAttribute("products");
			request.setAttribute("products", model.doRetrieveAll(sort));
		} catch(SQLException e) {
			System.out.println("Error: "+ e.getMessage());
			request.setAttribute("error", e.getMessage());
		}
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/inserisciProdotti.jsp");
		dispatcher.forward(request, response); // passo la chiamata alla jsp
		
	}


	
}
