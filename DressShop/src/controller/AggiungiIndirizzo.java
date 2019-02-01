package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.IndirizzoBean;
import model.IndirizzoModel;
import model.IndirizzoModelDM;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String citta = request.getParameter("citta");
		String via = request.getParameter("via");
		String cap = request.getParameter("cap");
		String provincia =request.getParameter("provincia");
		String nCel = request.getParameter("ncell");
		IndirizzoBean indirizzo = new IndirizzoBean();
		indirizzo.setNome(nome);
		indirizzo.setCognome(cognome);
		indirizzo.setCitta(citta);
		indirizzo.setVia(via);
		indirizzo.setCap(cap);
		indirizzo.setProvincia(provincia);
		indirizzo.setCellulare(nCel);
		
		try {
			model.doSave(indirizzo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
			

			//Dispatch into success page
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("aggiungi_indirizzo.jsp");
			requestDispatcher.forward(request, response);
		
		

	}
	
	}


