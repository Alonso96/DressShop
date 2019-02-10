package model.promozione;
//commit
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.DriverManagerConnectionPool;

public class PromozioneModelDM implements PromozioneModel<PromozioneBean>{

	private static final String TABLE = "PROMOZIONE";

	@Override
	public PromozioneBean doRetrieveByKey(int id_promozione) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		PromozioneBean bean = new PromozioneBean();
		
		String queryString ="Select * FROM " + TABLE + " WHERE id_promozione = ?";
		
		try{
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(queryString);
			statement.setInt(1, id_promozione);
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
	public Collection<PromozioneBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		Collection<PromozioneBean> listaBean = new ArrayList<PromozioneBean>();
		
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
	public void doSave(PromozioneBean promozione) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;

		String insertString=" INSERT INTO " + TABLE + " (data_inizio, data_fine, sconto) VALUES(?, ?, ?)";
		
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(insertString);

			statement.setDate(1, promozione.getData_inizio());
			statement.setDate(2, promozione.getData_fine());
			statement.setInt(3, promozione.getSconto());
			statement.executeUpdate();
			
			connection.commit();
		} finally{
			if(statement!= null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}

	@Override
	public void doUpdate(PromozioneBean promozione) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;

		String insertSQL = "UPDATE " + TABLE + " SET data_inizio = ?, data_fine = ?, sconto = ?"
				+ " WHERE id_promozione = ?;";
		
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(insertSQL);

			statement.setDate(1, promozione.getData_inizio());
			statement.setDate(2, promozione.getData_fine());
			statement.setInt(3, promozione.getSconto());
			statement.setInt(4, promozione.getId_promozione());
			statement.executeUpdate();
			
			connection.commit();
		} finally{
			if(statement!= null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}

	@Override
	public boolean doDelete(int id_promozione) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		int result = 0;
		
		String deleteString ="DELETE FROM " + TABLE + " WHERE id_promozione = ?";
		
		try {
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(deleteString);
			statement.setInt(1, id_promozione);
			
			result = statement.executeUpdate();
			
			connection.commit();
		} finally{
			if(statement!=null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
		
		return result != 0;
	}

	private static PromozioneBean getBean(ResultSet rs) throws SQLException{
		PromozioneBean bean = new PromozioneBean();
		
		bean.setId_promozione(rs.getInt("id_promozione"));
		bean.setData_inizio(rs.getDate("data_inizio"));
		bean.setData_fine(rs.getDate("data_fine"));
		bean.setSconto(rs.getInt("sconto"));
		
		return bean;
	}
}
