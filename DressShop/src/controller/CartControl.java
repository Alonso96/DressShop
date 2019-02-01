package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Carrello;
import model.ProdottoBean;
import model.ProdottoInCarrello;
import model.ProdottoInCatalogoBean;
import model.ProdottoModel;
import model.ProdottoInCatalogoModelDM;

/**a
 * Servlet implementation class CartControl
 */
@WebServlet("/CartControl")
public class CartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProdottoModel<ProdottoBean> model = new ProdottoInCatalogoModelDM();
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
		Carrello<ProdottoInCarrello> cart = (Carrello<ProdottoInCarrello>)request.getSession().getAttribute("cart");
		
		
		if(cart == null) {
			cart = new Carrello<ProdottoInCarrello>();
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
				/*} else if(action.equalsIgnoreCase("delete")) {
					cart.rimElemento(model.doRetrieveByKey(id));
				} else if(action.equalsIgnoreCase("insert")) {
					
					int id = Integer.parseInt(request.getParameter("Id"));
					String codice= request.getParameter("codice");
					String descrizione= request.getParameter("description");
					String marca = request.getParameter("marca");
					float ivaV = Float.parseFloat(request.getParameter("ivaVendita"));     //iva vendita;
					float prezzoV =Float.parseFloat(request.getParameter("prezzoVendita")); //prezzovendita
					String modello = request.getParameter("modello");
					int codC= Integer.parseInt(request.getParameter("codiceC")); //codice categoria
					int quantita= Integer.parseInt(request.getParameter("quantita"));
					String taglia = request.getParameter("taglia"); 
					String colore = request.getParameter("colore");
					String foto = request.getParameter("foto"); //url
					int promozione = Integer.parseInt(request.getParameter("promozione")); //id promozione
					
					
					ProdottoBean bean = new ProdottoBean();
					bean.setId_prodotto(id); 
					bean.setCodice_prodotto(codice);
					bean.setDescrizione(descrizione);
					bean.setMarca(marca);
					bean.setModello(modello);
					bean.setTaglia(taglia);
					bean.setColore(colore);
					bean.setFoto(foto);
				//	bean.setCategoria(categoria); dovrebbe essere un int ma è segnato stringa DA RIVEDERE!!
					bean.setPromozione(promozione);
					((ProdottoInCatalogoBean)bean).setPrezzo(prezzoV);
					((ProdottoInCatalogoBean)bean).setIva(ivaV);
					((ProdottoInCatalogoBean)bean).setQuantita(quantita);
					
					model.doSave(bean);
					*/
				} else if(action.equalsIgnoreCase("aggiungiP")) {
					int id = Integer.parseInt(request.getParameter("id"));
					ProdottoInCarrello prod = new ProdottoInCarrello((ProdottoInCatalogoBean)model.doRetrieveByKey(id));
					cart.addProd(prod);
					
					
				} else if(action.equalsIgnoreCase("rimuoviP")) {
					int id = Integer.parseInt(request.getParameter("id"));
					System.out.println("rimuovo elemento con id "+ id);
					ProdottoInCarrello prod = new ProdottoInCarrello((ProdottoInCatalogoBean)model.doRetrieveByKey(id));
					cart.rimElemento(prod);
				}
				else if( action.equalsIgnoreCase("acquista")) {
					cart.acquista();
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
			request.setAttribute("products", model.doRetrieveAll());  //dentro c'era "sort    
		} catch(SQLException e) {
			System.out.println("Error: "+ e.getMessage());
			request.setAttribute("error", e.getMessage());
		}
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Carrello.jsp");
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
