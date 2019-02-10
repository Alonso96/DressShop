package model.indirizzo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.DriverManagerConnectionPool;

public class IndirizzoModelDM implements IndirizzoModel<IndirizzoBean>{

	private static final String TABLE ="INDIRIZZO";
//
	@Override
	public IndirizzoBean doRetrieveByKey(int id_indirizzo) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		IndirizzoBean bean = new IndirizzoBean();
		
		String queryString ="Select * FROM " + TABLE + " WHERE id_indirizzo = ?";
		
		try{
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(queryString);
			statement.setInt(1, id_indirizzo);
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
	public Collection<IndirizzoBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		Collection<IndirizzoBean> listaBean = new ArrayList<IndirizzoBean>();
		
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
	public void doSave(IndirizzoBean indirizzo) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;

		String insertString=" INSERT INTO " + TABLE + " (nome, cognome, cap, "
				+ "provincia, citta, via, cellulare, utente) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(insertString);

			statement.setString(1, indirizzo.getNome());
			statement.setString(2, indirizzo.getCognome());
			statement.setString(3, indirizzo.getCap());
			statement.setString(4, indirizzo.getProvincia());
			statement.setString(5, indirizzo.getCitta());
			statement.setString(6, indirizzo.getVia());
			statement.setString(7, indirizzo.getCellulare());
			statement.setInt(8, indirizzo.getUtente());
			statement.executeUpdate();
			
			connection.commit();
		} finally{
			if(statement!= null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}

	@Override
	public void doUpdate(IndirizzoBean indirizzo) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;

		String insertSQL = "UPDATE " + TABLE + " SET nome = ?, cognome = ?, cap = ?,"
				+ " provincia = ?, citta = ?, via = ?, cellulare = ?, utente = ? WHERE id_indirizzo = ?;";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			statement = connection.prepareStatement(insertSQL);
			
			statement.setString(1, indirizzo.getNome());
			statement.setString(2, indirizzo.getCognome());
			statement.setString(3, indirizzo.getCap());
			statement.setString(4, indirizzo.getProvincia());
			statement.setString(5, indirizzo.getCitta());
			statement.setString(6, indirizzo.getVia());
			statement.setString(7, indirizzo.getCellulare());
			statement.setInt(8, indirizzo.getUtente());
			statement.executeUpdate();

			connection.commit();
		} finally{
			if(statement!= null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}

	@Override
	public boolean doDelete(int id_indirizzo) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		int result = 0;
		
		String deleteString ="DELETE FROM " + TABLE + " WHERE id_indirizzo = ?";
		
		try {
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(deleteString);
			statement.setInt(1, id_indirizzo);
			
			result = statement.executeUpdate();
			
			connection.commit();
		} finally{
			if(statement!=null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
		
		return result != 0;
	}

	@Override
	public Collection<IndirizzoBean> doRetrieveByUtente(int utente) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		ArrayList<IndirizzoBean> listaBean = new ArrayList<IndirizzoBean>();
		
		String queryString ="Select * FROM " + TABLE + " WHERE utente = ?";
		
		try{
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(queryString);
			statement.setInt(1, utente);
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
	
	
	private static IndirizzoBean getBean(ResultSet rs) throws SQLException{
		IndirizzoBean bean = new IndirizzoBean();
		
		bean.setId_indirizzo(rs.getInt("id_indirizzo"));
		bean.setNome(rs.getString("nome"));
		bean.setCognome(rs.getString("cognome"));
		bean.setCap(rs.getString("cap"));
		bean.setProvincia(rs.getString("provincia"));
		bean.setCitta(rs.getString("citta"));
		bean.setVia(rs.getString("via"));
		bean.setCellulare(rs.getString("cellulare"));
		bean.setUtente(rs.getInt("utente"));
		
		return bean;
	}
}
