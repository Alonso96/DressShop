package controller.utente;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.utente.UtenteBean;
import model.utente.UtenteModel;
import model.utente.UtenteModelDM;

/**
 * Servlet implementation class RegistrationControl
 */
@WebServlet("/RegistrationControl")
public class RegistrationControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	 UtenteModel<UtenteBean> model = new UtenteModelDM();
	
    public RegistrationControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// empty	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// prendo il parametro action della form , che equivale al nome della servlet dd(?)
		response.setContentType("text/html");
		System.out.println("Mi ha chiamato il bottone registrazione");
		System.out.println(request.getParameter("nome"));
		HttpSession session = request.getSession(false);

		try {
				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				String sData= request.getParameter("data_nascita");
				System.out.println(sData);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date data_nascita = new Date(formatter.parse(sData).getTime());

				String password = request.getParameter("password");
				String eMail = request.getParameter("email");					
			
				UtenteBean newUser = new UtenteBean();
				newUser.setNome(nome);
				newUser.setCognome(cognome);
				newUser.setEmail(eMail);
				newUser.setPassword(password);
				newUser.setData_nascita(data_nascita);
				newUser.setTipo(1);
						
				if(UtenteModelDM.checkUser(eMail)) {
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registrationFailed.jsp");
					dispatcher.forward(request, response);
				} else {	
					model.doSave(newUser);
					 session.setAttribute("email", eMail);
					 session.setAttribute("tipo", 1);
					 session.setAttribute("id", model.getIdUtente());
				  //   session.setAttribute("id", newUser.getId_utente()); //assegno l'id
					
					System.out.println("Ciao");
				}
				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registrationSuccess.jsp");
		dispatcher.forward(request, response);
				
				
	}
}
