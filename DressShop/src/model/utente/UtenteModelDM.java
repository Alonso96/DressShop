package model.utente;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.DriverManagerConnectionPool;

public class UtenteModelDM implements UtenteModel<UtenteBean> {
	
	private static final String TABLE ="UTENTE";

	@Override
	public UtenteBean doRetrieveByKey(int id_utente) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		UtenteBean bean = new UtenteBean();
		
		String queryString ="Select * FROM " + TABLE + " WHERE id_utente = ?";
		
		try{
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(queryString);
			statement.setInt(1, id_utente);
			ResultSet result = statement.executeQuery();
			while(result.next()){
				bean = getBean(result);
			}
		} finally{
			if(statement!=null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
		return bean;
	}

	@Override
	public Collection<UtenteBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		Collection<UtenteBean> listaBean = new ArrayList<UtenteBean>();
		
		String queryString ="Select * FROM " + TABLE ;
		try{
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(queryString);
			ResultSet result = statement.executeQuery();
			while(result.next()){
				listaBean.add(getBean(result));
			}
			
		} finally{
			if(statement!=null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
		return listaBean;
	}

	@Override
	public void doSave(UtenteBean utente) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
		Connection connection = null;
		PreparedStatement statement=null;

		String insertString=" INSERT INTO " + TABLE + " (nome, cognome, email, "
				+ "password, tipo, data_nascita) VALUES(?, ?, ?, ?, ?, ?)";
		
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(insertString);

			statement.setString(1, utente.getNome());
			statement.setString(2, utente.getCognome());
			statement.setString(3, utente.getEmail());
			statement.setString(4, CalculateHash(utente.getPassword()));
			statement.setInt(5, utente.getTipo());
			statement.setDate(6, (Date) utente.getData_nascita());
			statement.executeUpdate();
			
			connection.commit();
		} finally{
			if(statement!= null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}

	@Override
	public void doUpdate(UtenteBean utente) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;

		String insertSQL = "UPDATE " + TABLE + " SET nome = ?, cognome = ?, email = ?,"
				+ " password = ?, tipo = ?, data_nascita = ? WHERE id_utente = ?;";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			statement = connection.prepareStatement(insertSQL);
			
			statement.setString(1, utente.getNome());
			statement.setString(2, utente.getCognome());
			statement.setString(3, utente.getEmail());
			statement.setString(4, utente.getPassword());
			statement.setInt(5, utente.getTipo());
			statement.setDate(6, (Date) utente.getData_nascita());
			statement.setInt(7, utente.getId_utente());
			statement.executeUpdate();

			connection.commit();
		} finally{
			if(statement!= null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}

	@Override
	public void doUpdatePassword(String password, int id_utente) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
		Connection connection = null;
		PreparedStatement statement = null;

		String insertSQL = "UPDATE " + TABLE + " SET password = ? WHERE id_utente = ?;";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			statement = connection.prepareStatement(insertSQL);
			
			statement.setString(1, CalculateHash(password));
			statement.setInt(2, id_utente);
			statement.executeUpdate();

			connection.commit();
		} finally{
			if(statement!= null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}

	@Override
	public boolean doDelete(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		int result = 0;
		
		String deleteString ="DELETE FROM " + TABLE + " WHERE id_utente = ?";
		
		try {
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(deleteString);
			statement.setInt(1, id);
			
			result = statement.executeUpdate();
			
			connection.commit();
		} finally{
			if(statement!=null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
		
		return result != 0;
	}

	@Override
	public UtenteBean doRetrieveByEmail(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		UtenteBean bean = new UtenteBean();
		
		String queryString ="Select * FROM " + TABLE + " WHERE email = ?";
		
		try{
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(queryString);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			while(result.next()){
				bean = getBean(result);
			}
		} finally{
			if(statement!=null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
		return bean;
	}
	
	
	public static boolean  validate(String email, String password) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException { //verifica se email e password coincidono per il login
		boolean status = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String selectSQL = "SELECT * FROM " + TABLE + " WHERE email = ? and password = ? ;";
				
		try {
			try {
				connection = DriverManagerConnectionPool.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // crea la connessione se non esiste
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setString(1, email);
			preparedStatement.setString(2, CalculateHash(password));

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
	
	public static boolean checkUser(String email ) throws SQLException { // verifica se utente esiste gi� 
		boolean flag =false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String checkSQL="Select email from "+TABLE+" where email= ?;" ;
		
		try {
			try {
				connection = DriverManagerConnectionPool.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // crea la connessione se non esiste
			preparedStatement = connection.prepareStatement(checkSQL);

			preparedStatement.setString(1,email);
		

			System.out.println("validate..." + preparedStatement.toString());

			ResultSet rs = preparedStatement.executeQuery(); // la query viene eseguita
			
			flag=rs.next();
			
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

		return flag;
	}
	
	
	public static int getTipo(String email, String password) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException{
		int flag = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		UtenteBean bean = new UtenteBean();
		String selectSQL = "SELECT tipo FROM " +TABLE + " WHERE email = ? and password =? ;";
				
		try {
			try {
				connection = DriverManagerConnectionPool.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // crea la connessione se non esiste
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setString(1, email);
			preparedStatement.setString(2, CalculateHash(password)) ;

			System.out.println("validate..." + preparedStatement.toString());

			ResultSet rs = preparedStatement.executeQuery(); // la query viene eseguita
			if(rs.next())
			flag = rs.getInt("tipo");
			
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

		return flag;
	}
	@Override
	public int getIdUtente() throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		int id_utente = 0;
		String sql ="Select last_insert_id() as id_ut from utente;";
		
		try {
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()){
				id_utente = result.getInt("id_ut");
			}
			return id_utente;
		}
		finally {
			if(statement != null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}
	
	
	private static UtenteBean getBean(ResultSet rs) throws SQLException{
		UtenteBean bean = new UtenteBean();
		
		bean.setId_utente(rs.getInt("id_utente"));
		bean.setNome(rs.getString("nome"));
		bean.setCognome(rs.getString("cognome"));
		bean.setEmail(rs.getString("email"));
		bean.setPassword(rs.getString("password"));
		bean.setTipo(rs.getInt("tipo"));
		bean.setData_nascita(rs.getDate("data_nascita"));
		
		return bean;
	}
	
	private static String CalculateHash(String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		  // getInstance() method is called with algorithm SHA-512 
        MessageDigest md = MessageDigest.getInstance("SHA-512"); 

        // digest() method is called 
        // to calculate message digest of the input string 
        // returned as array of byte 
        byte[] messageDigest = md.digest(pass.getBytes()); 

        // Convert byte array into signum representation 
        BigInteger no = new BigInteger(1, messageDigest); 

        // Convert message digest into hex value 
        String hashtext = no.toString(16); 

        // Add preceding 0s to make it 32 bit 
        while (hashtext.length() < 32) { 
            hashtext = "0" + hashtext; 
        } 

        // return the HashText 
        return hashtext; 
	}
	
}
