package controller.utente;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.DriverManagerConnectionPool;





/** 
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String password =request.getParameter("password");
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		
		
		try {
		
			String user = "alfonso"; // metti il tuo user
			String pass = "alf"; // metti la tua pass
			
			connection = DriverManagerConnectionPool.getConnection();
			String insertSQL = "UPDATE utenti(Nome,Cognome,Email,Password,Nickname)  VALUES (?,?,?,?,?);";
			preparedStatement = connection.prepareStatement(insertSQL);
		
			
		    
		   
			
			System.out.println(preparedStatement);
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, cognome);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
		//	preparedStatement.setString(5, username);

			//Execute the insert
			preparedStatement.executeUpdate();
			

			//Dispatch into success page
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("amministrazione.jsp");
			requestDispatcher.forward(request, response);
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {

		try {
			if(preparedStatement != null ) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // rilascio risorse
			}
		}
		finally {
			try {
				DriverManagerConnectionPool.releaseConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // evita di far reinstanziare ogni volta una connection
			// la connection viene "conservata" nella collection Pool
		}
	
	}
		

	}
}


