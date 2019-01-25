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

/**
 * Servlet implementation class AdminControl1
 */
@WebServlet("/AdminControl1")
public class AdminControl1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static ProductModel<ProductBean> model = new ProductModelDM();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminControl1() {
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

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String action = request.getParameter("action");
	try {
	if(action != null) {
		if(action.equalsIgnoreCase("insert")) { 
		String codice = request.getParameter("Codice");
		String descrizione = request.getParameter("description");
		String marca= request.getParameter("marca");
					
		float prezzo = Float.parseFloat(request.getParameter("prezzoV"));
		int codCat = Integer.parseInt(request.getParameter("codC"));	
	    int quantità = Integer.parseInt(request.getParameter("quantity"));

	
		
	

			//response.setContentType("text/html");
	
			ProductBean bean = new ProductBean();
			bean.setCodice(codice);
			bean.setDescription(descrizione);
			bean.setMarca(marca);
			bean.setPrezzoV(prezzo);
			bean.setCodC(codCat);
			bean.setQuantity(quantità);
			
		
			model.doSave(bean);
			System.out.println("Ciao");
			}
			
	
	}
	else {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
	}
	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/amministrazione.jsp");
		dispatcher.forward(request, response);
	
	
	}
}
