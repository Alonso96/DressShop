package controller.indirizzo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.carta.CartaDiCreditoBean;
import model.carta.CartaDiCreditoModelDM;
import model.indirizzo.IndirizzoBean;
import model.indirizzo.IndirizzoModelDM;

/**
 * Servlet implementation class VerificaIndirizzo
 */
@WebServlet("/VerificaIndirizzo")
public class VerificaIndirizzo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificaIndirizzo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ciao");
		String flag =null;
		PrintWriter out = response.getWriter();
		flag = request.getParameter("indirizzo");
		System.out.println(flag);
		if (flag != null) {
			int id_indirizzo = Integer.parseInt(flag);
			if(request.getSession().getAttribute("id") == null){
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			} else {
				IndirizzoBean indirizzo = new IndirizzoBean();
				try{
					IndirizzoModelDM model = new IndirizzoModelDM();
					indirizzo = model.doRetrieveByKey(id_indirizzo);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int id = (int) request.getSession().getAttribute("id");
				Collection<CartaDiCreditoBean> carte = new ArrayList<CartaDiCreditoBean>();
				System.out.println(id);
				try {
					CartaDiCreditoModelDM model = new CartaDiCreditoModelDM();
					carte = model.doRetrieveByUtente(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getSession().setAttribute("indirizzo", indirizzo);
				
				request.getSession().setAttribute("carte", carte);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/carrello_carta.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Seleziona un indirizzo');");
			out.println("location='carrello_indirizzo.jsp';");
			out.println("</script>");
		}   
	}
}

