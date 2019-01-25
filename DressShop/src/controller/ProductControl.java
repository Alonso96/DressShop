package controller;
import model.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ProductControl")
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static ProductModel<ProductBean> model = new ProductModelDM();
	
	public ProductControl() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Carrello<ProductBean> cart = (Carrello<ProductBean>)request.getSession().getAttribute("cart");
		
		
		if(cart == null) {
			cart = new Carrello<ProductBean>();
			request.getSession().setAttribute("cart", cart);
		}
		
		System.out.println("ciao");
		String action = request.getParameter("action");
		
		try {
			if(action != null) {
				if(action.equalsIgnoreCase("detail")) {
					int id = Integer.parseInt(request.getParameter("id"));
					request.removeAttribute("product");
					request.setAttribute("product", model.doRetrieveByKey(id));
				} else if(action.equalsIgnoreCase("delete")) {
					int id = Integer.parseInt(request.getParameter("id"));
					model.doDelete(id);
				} else if(action.equalsIgnoreCase("insert")) {
					
					int id = Integer.parseInt(request.getParameter("Id"));
					String codice= request.getParameter("codice");
					String description= request.getParameter("description");
					String marca = request.getParameter("marca");
					float ivaV = Float.parseFloat(request.getParameter("ivaVendita"));     //iva vendita;
					float prezzoV =Float.parseFloat(request.getParameter("prezzoVendita")); //prezzovendita
					int codC= Integer.parseInt(request.getParameter("codiceC")); //codice categoria
					int quantity= Integer.parseInt(request.getParameter("quantity"));
					
					
					ProductBean bean = new ProductBean();
					bean.setCodice(codice);
					bean.setDescription(description);
					bean.setMarca(marca);
					bean.setPrezzoV(ivaV);
					bean.setIvaV(prezzoV);
					bean.setCodC(codC);
					bean.setQuantity(quantity);
					
					model.doSave(bean);
				} else if(action.equalsIgnoreCase("addCart")) {
					int id = Integer.parseInt(request.getParameter("id"));
					cart.aggElemento(model.doRetrieveByKey(id));
					
				} else if(action.equalsIgnoreCase("delCart")) {
					int id = Integer.parseInt(request.getParameter("id"));
					System.out.println("rimuovo elemento con id "+ id);
					cart.rimElemento(model.doRetrieveByKey(id));
				}
				
				
			
				
			}
		} catch(SQLException e) {
			System.out.println("Error: "+ e.getMessage());
			request.setAttribute("error", e.getMessage());
		}
		
		request.getSession().setAttribute("cart", cart);
		request.setAttribute("cart", cart);
		
		
		
		String sort = request.getParameter("sort");
		
		try {
			request.removeAttribute("products");
			request.setAttribute("products", model.doRetrieveAll(sort));
		} catch(SQLException e) {
			System.out.println("Error: "+ e.getMessage());
			request.setAttribute("error", e.getMessage());
		}
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VisualizzaProdotti.jsp");
		dispatcher.forward(request, response); // passo la chiamata alla jsp
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
