package controller.indirizzo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.indirizzo.IndirizzoBean;
import model.indirizzo.IndirizzoModel;
import model.indirizzo.IndirizzoModelDM;
import model.utente.UtenteModelDM;

/**
 * Servlet implementation class AggiungiIndirizzo a
 */
@WebServlet("/AggiungiIndirizzo")
public class AggiungiIndirizzo extends HttpServlet {
	IndirizzoModel<IndirizzoBean> model = new IndirizzoModelDM();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiIndirizzo() {
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
		response.setContentType("text/html");  //aa
        PrintWriter out = response.getWriter();  
		HttpSession session=request.getSession();
		synchronized(session)
	    {
	    	String utente =(String) session.getAttribute("email");
	    	System.out.println(utente);
	    	if(utente==null)
	    	{
	    		request.getRequestDispatcher("Login.jsp").forward(request, response);
	    	}
	    	else
	    	{
	    		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String citta = request.getParameter("citta");
		String via = request.getParameter("via");
		String cap = request.getParameter("cap");
		String provincia =request.getParameter("provincia");
		String nCel = request.getParameter("cellulare");
		int id = ((int)session.getAttribute("id"));
		IndirizzoBean indirizzo = new IndirizzoBean();
		indirizzo.setNome(nome);
		indirizzo.setCognome(cognome);
		indirizzo.setCitta(citta);
		indirizzo.setVia(via);
		indirizzo.setCap(cap);
		indirizzo.setProvincia(provincia);
		indirizzo.setCellulare(nCel);
	    indirizzo.setUtente(id);	
		try {
			if(IndirizzoModelDM.checkIndirizzo(via,citta)) {
				/*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mostra_indirizzo.jsp");
				dispatcher.forward(request, response);
				*/
			} else {	
				model.doSave(indirizzo);
				/* session.setAttribute("email", eMail);
				 session.setAttribute("tipo", 1);
				 session.setAttribute("id", model.getIdUtente());
			  //   session.setAttribute("id", newUser.getId_utente()); //assegno l'id
				*/
				System.out.println("Ciao");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    	}
		
		
			

			//Dispatch into success page
	    	 out.print("<p style=\"color:green\">Indirizzo Aggiunto con successo</p><br>");  
			   
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("mostra_indirizzi.jsp");
			requestDispatcher.forward(request, response);
		
		

	}
	
	}
}


