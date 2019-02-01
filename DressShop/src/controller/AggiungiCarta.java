package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CartaDiCreditoBean;
import model.CartaDiCreditoModel;
import model.CartaDiCreditoModelDM;
import model.UtenteBean;

@WebServlet("/AggiungiCarta")
public class AggiungiCarta extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CartaDiCreditoModel<CartaDiCreditoBean> model = new CartaDiCreditoModelDM();
    public AggiungiCarta() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		synchronized(session)
	    {
	    	UtenteBean utente=(UtenteBean) session.getAttribute("name");
	    	if(utente==null)
	    	{
	    		request.getRequestDispatcher("Login.jsp").forward(request, response);
	    	}
	    	else
	    	{
	    		CartaDiCreditoBean carta=new CartaDiCreditoBean();
	    		carta.setNumero_carta(request.getParameter("numero_carta"));
	    	    int anno=Integer.parseInt(request.getParameter("anno"));
	    		int mese=Integer.parseInt(request.getParameter("mese"));
	    		int giorno=Integer.parseInt(request.getParameter("giorno"));
	    		@SuppressWarnings("deprecation")
				Date data=new Date(anno-1900,mese-1,giorno);
	    		carta.setData_scadenza(data);
	    		carta.setNome_proprietario((request.getParameter("intestatario")));
	    		try {
					model.doSave(carta);
					request.setAttribute("carta", carta);
					request.getRequestDispatcher("MostraCarte").forward(request, response);
				} catch (SQLException e) {
					request.getRequestDispatcher("MostraCarte.jsp").forward(request, response);
					e.printStackTrace();
				}
	    	}
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
