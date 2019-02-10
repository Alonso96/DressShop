package controller.gestoremarketing;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.prodotto.ProdottoBean;
import model.prodotto.ProdottoModel;
import model.prodotto.ProdottoModelDM;

/**
 * Servlet implementation class InsPrezzoControl
 */
@WebServlet("/InsPrezzoControl")
public class InsPrezzoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProdottoModel<ProdottoBean> model = new ProdottoModelDM();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsPrezzoControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method studd
		 String action = request.getParameter("insP");
         System.out.println(action);
       
         	int id_prodotto = Integer.parseInt(request.getParameter("id_prodotto"));
         	System.out.println("id prodotto è: " + id_prodotto);
         	float prezzo = Float.parseFloat(request.getParameter("prezzo"));
         	try {
					model.doUpdatePrezzo(id_prodotto, prezzo);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
         	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/prodottiSenzaPrezzo.jsp");
			dispatcher.forward(request, response); // passo la chiamata alla jsp;
         
	}

}
