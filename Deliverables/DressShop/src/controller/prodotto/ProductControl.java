package controller.prodotto;
import model.*;
import model.carrello.Carrello;
import model.prodotto.ProdottoBean;
import model.prodotto.ProdottoInOrdineBean;
import model.prodotto.ProdottoModel;
import model.prodotto.ProdottoModelDM;
import model.taglia.TagliaBean;
import model.taglia.TagliaModel;
import model.taglia.TagliaModelDM;

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

	static ProdottoModel<ProdottoBean> model = new ProdottoModelDM();
	static TagliaModel<TagliaBean> model1 = new TagliaModelDM();
	public ProductControl() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Carrello<ProdottoBean> cart = (Carrello<ProdottoBean>)request.getSession().getAttribute("cart");
		
		
		if(cart == null) {
			cart = new Carrello<ProdottoBean>();
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
					request.getRequestDispatcher("visualizzaProdotto.jsp").forward(request, response);
				} else if(action.equalsIgnoreCase("delete")) {
					int id = Integer.parseInt(request.getParameter("id"));
					model.doDelete(id);
				} else if(action.equalsIgnoreCase("insert")) {
					
					int id = Integer.parseInt(request.getParameter("Id"));
					String codice= request.getParameter("codice");
					String descrizione= request.getParameter("description");
					String marca = request.getParameter("marca");
					String modello = request.getParameter("modello");
					String foto = request.getParameter("foto");
					String categoria = request.getParameter("categoria");
					int promozione = Integer.parseInt(request.getParameter("promozione"));
					int ivaV = Integer.parseInt(request.getParameter("ivaVendita"));     //iva vendita;
					float prezzoV =Float.parseFloat(request.getParameter("prezzoVendita")); //prezzovendita
					int codC= Integer.parseInt(request.getParameter("codiceC")); //codice categoria
					int quantita= Integer.parseInt(request.getParameter("quantity"));
					boolean reso = Boolean.parseBoolean(request.getParameter("reso"));
					ProdottoBean bean = new ProdottoBean();
					bean.setId_prodotto(id);
					bean.setCodice_prodotto(codice);
					bean.setDescrizione(descrizione);
					bean.setMarca(marca);
					bean.setModello(modello);
					bean.setFoto(foto);
					bean.setCategoria(categoria);
					bean.setPromozione(promozione);
					((ProdottoBean)bean).setPrezzo_compl(prezzoV);
					((ProdottoBean)bean).setIva(ivaV);
					((ProdottoInOrdineBean)bean).setQuantita(quantita);
					((ProdottoInOrdineBean)bean).setReso(reso);
					
					
					
					model.doSave(bean);
				} else if(action.equalsIgnoreCase("addCart")) {
					int id = Integer.parseInt(request.getParameter("id"));
					cart.addProd(model.doRetrieveByKey(id));
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/carrello.jsp");
					dispatcher.forward(request, response); // passo la chiamata alla jsp;
					
				} else if(action.equalsIgnoreCase("delCart")) {
					int id = Integer.parseInt(request.getParameter("id"));
					System.out.println("rimuovo elemento con id "+ id);
//					cart.rimElemento(model.doRetrieveByKey(id));
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
			request.setAttribute("products", model.doRetrieveAll()); // prima c'era sort DA RIVEDERE
		} catch(SQLException e) {
			System.out.println("Error: "+ e.getMessage());
			request.setAttribute("error", e.getMessage());
		}
		
	   /* RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/carrello.jsp");
		dispatcher.forward(request, response); // passo la chiamata alla jsp;
		*/
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           
          
		
		/*	if(action != null) {
			/*	if(action.equalsIgnoreCase("detail")) {
					int id = Integer.parseInt(request.getParameter("id"));
					request.removeAttribute("product");
					request.setAttribute("product", model.doRetrieveByKey(id));
					request.getRequestDispatcher("visualizzaProdotto.jsp").forward(request, response);
					
				
				//
					*/
				//	int id = Integer.parseInt(request.getParameter("Id"));
					String codice= request.getParameter("codice");
					String descrizione= request.getParameter("descrizione");
					String marca = request.getParameter("marca");
					String modello = request.getParameter("modello");
					String foto = request.getParameter("foto");
					String categoria = request.getParameter("categoria");
					String taglia = request.getParameter("taglia");
					String tipo = request.getParameter("tipo");
					
				//	int promozione = Integer.parseInt(request.getParameter("promozione"));
					int ivaV = 0; //Integer.parseInt(request.getParameter("ivaVendita"));     //iva vendita;
					float prezzoV =  0; //Float.parseFloat(request.getParameter("prezzoVendita")); //prezzovendita
					//int codC= Integer.parseInt(request.getParameter("codiceC")); //codice categoria
					int quantita= Integer.parseInt(request.getParameter("quantita"));
				//	boolean reso = Boolean.parseBoolean(request.getParameter("reso"));
					ProdottoBean bean = new ProdottoBean();
					TagliaBean tagliab = new TagliaBean();
					tagliab.setQuantita(quantita);
					tagliab.setTaglia(taglia);
					categoria=categoria+"."+tipo;
					System.out.println("Categoria nuova e': "+categoria);
			//		bean.setId_prodotto(id);
					bean.setCodice_prodotto(codice);
					bean.setDescrizione(descrizione);
					bean.setMarca(marca);
					bean.setModello(modello);
					bean.setFoto(foto);
					bean.setCategoria(categoria);
				//	bean.setPromozione(promozione);
					bean.setIn_vendita(true);
					((ProdottoBean)bean).setPrezzo_compl(prezzoV);
					((ProdottoBean)bean).setIva(ivaV);
					
			//		((ProdottoInOrdineBean)bean).setReso(reso);
					
					
					
					try {
						model.doSave(bean);
						model1.doSave(tagliab);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/magazzinierePage.jsp");
					dispatcher.forward(request, response); // passo la chiamata alla jsp;
            }
		
		
		
		
	
	
	
}
