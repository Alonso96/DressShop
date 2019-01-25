package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class UserBeanDM implements UserModel<UserBean> {
	//OK
	private static final String  TABLE_NAME ="utenti";

	@Override 
	public Collection<UserBean> retrieveAllUsers() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<UserBean> list = new LinkedList<UserBean>();

		String selectSQL = "SELECT * FROM " + TABLE_NAME ;

		try {
			connection = DriverManagerConnectionPool.getConnection(); // crea la connessione se non esiste
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("doRetrieveAll" + preparedStatement.toString());

			ResultSet rs = preparedStatement.executeQuery(); // la query viene eseguita

			while(rs.next()) {
				UserBean bean = new UserBean(); // salvo gli attributi letti dal result set , farlo per ogni tupla
				bean.setNome("nome");
				bean.setCognome("cognome");
				bean.seteMail("eMail");
				bean.setPassword("password");
				bean.setTipo("tipo");
				bean.setIdUtente("idUtente");

				list.add(bean); // salvo nella collezione
			}

		} finally {

			try {
				if(preparedStatement != null ) {
					preparedStatement.close(); // rilascio risorse
				}
			}
			finally {
				DriverManagerConnectionPool.releaseConnection(connection); // evita di far reinstanziare ogni volta una connection
				// la connection viene "conservata" nella collection Pool
			}
		}

		return list;
	}

	@Override
	public void saveUsers(UserBean user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String eMail ;
		eMail= user.geteMail(); // procedura per vedere se esiste un e-mail
		String checkSQL="Select where E-Mail="+UserBeanDM.TABLE_NAME + eMail+ ";";
	
		System.out.println("Inserisco utente");
		String insertSQL = "INSERT INTO " + UserBeanDM.TABLE_NAME +
				"( Nome, Cognome, Nickname,Indirizzo,Admin, Email, Password, Cap,Città)" +
				"VALUES (?,?,?,?,?,?,?,?,? );";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getIdUtente());
			preparedStatement.setString(2, user.getNome());
			preparedStatement.setString(3, user.getCognome());
			preparedStatement.setString(4, user.geteMail());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setString(6, user.getTipo());
			
			// seguire la tabella nel db e fare il settaggio
			
			
			
			
			System.out.println("doSave: "+ preparedStatement.toString());
			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}

		}
	}
	public static String checkUser(String eMail ) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String checkSQL="Select E-Mail from "+UserBeanDM.TABLE_NAME+";" ;
		 String tipo=null;
		try {
			try {
				connection = DriverManagerConnectionPool.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // crea la connessione se non esiste
			preparedStatement = connection.prepareStatement(checkSQL);

			preparedStatement.setString(1,eMail);
		

			System.out.println("validate..." + preparedStatement.toString());
          
			ResultSet rs = preparedStatement.executeQuery(); // la query viene eseguita
			tipo=rs.getString("tipo");
			
		} finally {

			try {
				if(preparedStatement != null ) {
					preparedStatement.close(); // rilascio risorse
				}
			}
			finally {
				DriverManagerConnectionPool.releaseConnection(connection); // evita di far reinstanziare ogni volta una connection
				// la connection viene "conservata" nella collection Pool
			}
		}

		return tipo;
		
		
	}
	@Override
	public boolean deleteUsers(String eMail) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + UserBeanDM.TABLE_NAME + " WHERE E-Mail = "+eMail;

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, eMail);

			System.out.println("doDelete: "+ preparedStatement.toString());
			result = preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}
	

	@Override
	public UserBean retrieveByKey(String eMail) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		UserBean bean = new UserBean();
		String selectSQL = "SELECT * FROM " + UserBeanDM.TABLE_NAME + " WHERE E-Mail = " + eMail +";";
				
		try {
			try {
				connection = DriverManagerConnectionPool.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // crea la connessione se non esiste
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setString(0, eMail);

			System.out.println("doRetrieveByKey" + preparedStatement.toString());

			ResultSet rs = preparedStatement.executeQuery(); // la query viene eseguita

			while(rs.next()) {
				bean.setNome("nome");
				bean.setCognome("cognome");
				bean.seteMail("eMail");
				bean.setPassword("password");
				bean.setTipo("tipo");
				bean.setIdUtente("idUtente");
}
		} finally {

			try {
				if(preparedStatement != null ) {
					preparedStatement.close(); // rilascio risorse
				}
			}
			finally {
				DriverManagerConnectionPool.releaseConnection(connection); // evita di far reinstanziare ogni volta una connection
				// la connection viene "conservata" nella collection Pool
			}
		}

		return bean;
	}
	
	
	// VERIFICA SE utente e password coincidono
	
	public static boolean  validate(String eMail, String password) throws SQLException {
			boolean status = false;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			UserBean bean = new UserBean();
			String selectSQL = "SELECT * FROM " + UserBeanDM.TABLE_NAME + " WHERE E-Mail = ? and Password =? ;";
					
			try {
				try {
					connection = DriverManagerConnectionPool.getConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // crea la connessione se non esiste
				preparedStatement = connection.prepareStatement(selectSQL);

				preparedStatement.setString(1, eMail);
				preparedStatement.setString(2, password) ;

				System.out.println("validate..." + preparedStatement.toString());

				ResultSet rs = preparedStatement.executeQuery(); // la query viene eseguita

				status=rs.next();
				
			} finally {

				try {
					if(preparedStatement != null ) {
						preparedStatement.close(); // rilascio risorse
					}
				}
				finally {
					DriverManagerConnectionPool.releaseConnection(connection); // evita di far reinstanziare ogni volta una connection
					// la connection viene "conservata" nella collection Pool
				}
			}

			return status;
		}
	
	public static String getTipo(String eMail, String password) throws SQLException{
		String tipo ="null";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		UserBean bean = new UserBean();
		String selectSQL = "SELECT Tipo FROM " + UserBeanDM.TABLE_NAME + " WHERE E-Mail = ? and Password =? ;";
				
		try {
			try {
				connection = DriverManagerConnectionPool.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // crea la connessione se non esiste
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setString(1, eMail);
			preparedStatement.setString(2, password) ;

			System.out.println("validate..." + preparedStatement.toString());

			ResultSet rs = preparedStatement.executeQuery(); // la query viene eseguita
			if(rs.next())
			tipo=rs.getString("tipo");
			
		} finally {

			try {
				if(preparedStatement != null ) {
					preparedStatement.close(); // rilascio risorse
				}
			}
			finally {
				DriverManagerConnectionPool.releaseConnection(connection); // evita di far reinstanziare ogni volta una connection
				// la connection viene "conservata" nella collection Pool
			}
		}

		return tipo;
	}
	}

