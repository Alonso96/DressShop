package controller.prodotto;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.prodotto.ProdottoBean;
import model.prodotto.ProdottoModelDM;


@WebServlet("/CatalogoControl")
public class CatalogoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CatalogoControl() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                     
		String action = request.getParameter("action");
		try {
			if(action != null) {
				if(action.equalsIgnoreCase("catalogo")) {
					ProdottoModelDM model = new ProdottoModelDM();
					String categoria =request.getParameter("categoria");
					ProdottoBean listaProdotti = (ProdottoBean)model.doRetrieveByCategory(categoria);
					
					request.setAttribute("listaProdotti", listaProdotti);
					
				/*	DA METTERE JSP GIUSTA PER IL CATALOGO 	
				 * 	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/storicoProdotti.jsp");
					dispatcher.forward(request, response); 
					*/
				}
			}
		}
		catch(Exception e) {
			
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
