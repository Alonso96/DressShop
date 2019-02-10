package controller.proprietario;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ordine.OrdineBean;
import model.ordine.OrdineModel;
import model.ordine.OrdineModelDM;
import model.utente.UtenteBean;
import model.utente.UtenteModel;
import model.utente.UtenteModelDM;

/**
 * Servlet implementation class AdminControl
 */
@WebServlet("/AdminControl")
public class AdminControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static UtenteModel<UtenteBean> model = new UtenteModelDM();
	static OrdineModel<OrdineBean> model2 = new OrdineModelDM();
	
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
		
	
		String action = request.getParameter("action");
		
		try {
			if(action != null) {
				if(action.equalsIgnoreCase("detail")) {
					int id = Integer.valueOf(request.getParameter("id"));
					request.removeAttribute("utenti");
					request.setAttribute("utenti", model.doRetrieveByKey(id));
				} else if(action.equalsIgnoreCase("delete")) {
					int id = Integer.valueOf(request.getParameter("id"));
					model.doDelete(id);
				} 
				else if(action.equals("vis_stat")) {
					model2.doRetrieveAll();
				}
			}
		} catch(SQLException e) {
			System.out.println("Error: "+ e.getMessage());
			request.setAttribute("error", e.getMessage());
		}
		
	
		
		
		String sort = request.getParameter("sort");
		
		try {
			request.removeAttribute("products");
			request.setAttribute("products", model.doRetrieveAll());
		} catch(SQLException e) {
			System.out.println("Error: "+ e.getMessage());
			request.setAttribute("error", e.getMessage());
		}
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/amministrazione.jsp");
		dispatcher.forward(request, response); // passo la chiamata alla jsp
		
	}


	
}
