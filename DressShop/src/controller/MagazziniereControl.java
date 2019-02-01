package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrdineBean;
import model.OrdineModel;
import model.OrdineModelDM;
import model.UtenteBean;
import model.UtenteModel;
import model.UtenteModelDM;

/**
 * Servlet implementation class MagazziniereControl
 */
@WebServlet("/MagazziniereControl")
public class MagazziniereControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static UtenteModel<UtenteBean> model = new UtenteModelDM();
	static OrdineModel<OrdineBean> model2 = new OrdineModelDM();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MagazziniereControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
