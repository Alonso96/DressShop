package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class TagliaModelDM implements TagliaModel{

	private static final String TABLE ="TAGLIA";

	@Override
	public Collection<TagliaBean> doRetrieveByProdotto(int id_prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		Collection<TagliaBean> listaBean = new ArrayList<TagliaBean>();
		
		String queryString ="Select * FROM " + TABLE + " WHERE id_prodotto = ?";
		
		try{
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(queryString);
			statement.setInt(1, id_prodotto);
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
	public void doSave(TagliaBean taglia) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		String insertString=" INSERT INTO " + TABLE + " (id_prodotto, taglia, quantita) VALUES(?, ?, ?)";
		
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(insertString);

			statement.setInt(1, taglia.getId_prodotto());
			statement.setString(2, taglia.getTaglia());
			statement.setInt(3, taglia.getQuantita());
			statement.executeUpdate();
			
			connection.commit();
			
		} finally{
			if(statement != null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}

	@Override
	public void doUpdate(TagliaBean taglia) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		String insertString=" UPDATE " + TABLE + " SET quantita = ? WHERE id_prodotto = ? and taglia = ?;";
		
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(insertString);

			statement.setInt(1, taglia.getQuantita());
			statement.setInt(2, taglia.getId_prodotto());
			statement.setString(3, taglia.getTaglia());
			statement.executeUpdate();
			
			connection.commit();
			
		} finally{
			if(statement != null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}

	@Override
	public boolean doDelete(TagliaBean taglia) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		int result = 0;
		
		String deleteString ="DELETE FROM " + TABLE + " WHERE id_prodotto = ? and taglia = ?";
		
		try {
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(deleteString);
			statement.setInt(1, taglia.getId_prodotto());
			statement.setString(2, taglia.getTaglia());
			
			result = statement.executeUpdate();
			
			connection.commit();
		} finally{
			if(statement!=null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
		
		return result != 0;
	}

	private static TagliaBean getBean(ResultSet rs) throws SQLException{
		TagliaBean bean = new TagliaBean();
		
		bean.setId_prodotto(rs.getInt("id_prodotto"));
		bean.setTaglia(rs.getString("taglia"));
		bean.setQuantita(rs.getInt("quantita"));
		
		return bean;
	}
}
