package controller.carta;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.carta.CartaDiCreditoBean;
import model.carta.CartaDiCreditoModel;
import model.carta.CartaDiCreditoModelDM;
import model.utente.UtenteBean;

@WebServlet("/AggiungiCarta")
public class AggiungiCarta extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CartaDiCreditoModel<CartaDiCreditoBean> model = new CartaDiCreditoModelDM();
    public AggiungiCarta() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");   //j
        PrintWriter out = response.getWriter();  
		HttpSession session=request.getSession();
		synchronized(session)
	    {
	    	String utente =(String) session.getAttribute("email");
	    	if(utente==null)
	    	{
	    		request.getRequestDispatcher("Login.jsp").forward(request, response);
	    	}
	    	else
	    	{
	    		CartaDiCreditoBean carta=new CartaDiCreditoBean();
	    		carta.setUtente((int) session.getAttribute("id"));
	    		carta.setNumero_carta(request.getParameter("numero_carta"));
	    		carta.setCvv(request.getParameter("cvv"));
	    		carta.setCognome_proprietario(request.getParameter("cognome"));
	    	    int anno=Integer.parseInt(request.getParameter("anno"));
	    		int mese=Integer.parseInt(request.getParameter("mese"));
	    		int giorno=Integer.parseInt(request.getParameter("giorno"));
	    		@SuppressWarnings("deprecation")
				Date data=new Date(anno-1900,mese-1,giorno);
	    		carta.setData_scadenza(data);
	    		carta.setNome_proprietario((request.getParameter("nome")));
	    		try {
	    			if(CartaDiCreditoModelDM.checkCarta(carta.getNumero_carta())) {
	    				 
	    				   
	    					RequestDispatcher requestDispatcher = request.getRequestDispatcher("aggiungiCarta.jsp");
	    					requestDispatcher.forward(request, response);
	    			}
	    			else {
					model.doSave(carta);
					request.setAttribute("carta", carta);
					out.print("<p style=\"color:green\">Carta aggiunta con successo</p><br>");  
					RequestDispatcher rd3=request.getRequestDispatcher("/mostra_carte.jsp");  
				    rd3.forward(request,response);
	    			}
				} catch (SQLException e) {
					request.getRequestDispatcher("mostra_carte.jsp").forward(request, response);
					e.printStackTrace();
				}
	    	}
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
