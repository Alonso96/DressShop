package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class CategoriaModelDM implements CategoriaModel<CategoriaBean>{

	private static final String TABLE = "CATEGORIA";
	
	public CategoriaBean doRetrieveByKey(int id_categoria) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		CategoriaBean bean = new CategoriaBean();
		
		String queryString ="Select * FROM " + TABLE + " WHERE id_categoria = ?";
		
		try{
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(queryString);
			statement.setInt(1, id_categoria);
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

	public Collection<CategoriaBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		Collection<CategoriaBean> listaBean = new ArrayList<CategoriaBean>();
		
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

	public void doSave(CategoriaBean categoria) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;

		String insertString=" INSERT INTO " + TABLE + " (nome, descrizione) VALUES(?, ?)";
		
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(insertString);

			statement.setString(1, categoria.getNome());
			statement.setString(2, categoria.getDescrizione());
			statement.executeUpdate();
			
			connection.commit();
		} finally{
			if(statement!= null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}

	public void doUpdate(CategoriaBean categoria) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;

		String insertSQL = "UPDATE " + TABLE + " SET nome = ?, descrizione = ?"
				+ " WHERE id_categoria = ?;";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			statement = connection.prepareStatement(insertSQL);
			statement.setString(1, categoria.getNome());
			statement.setString(2, categoria.getDescrizione());
			statement.setInt(3, categoria.getId_categoria());
			statement.executeUpdate();

			connection.commit();
		} finally{
			if(statement!= null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}

	public boolean doDelete(int id_categoria) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		int result = 0;
		
		String deleteString ="DELETE FROM " + TABLE + " WHERE id_categoria = ?";
		
		try {
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(deleteString);
			statement.setInt(1, id_categoria);
			
			result = statement.executeUpdate();
			
			connection.commit();
		} finally{
			if(statement!=null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
		
		return result != 0;
	}

	public CategoriaBean doRetrieveByName(String nome) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		CategoriaBean bean = new CategoriaBean();
		
		String queryString ="Select * FROM " + TABLE + " WHERE nome = ?";
		
		try{
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(queryString);
			statement.setString(1, nome);
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

	private static CategoriaBean getBean(ResultSet rs) throws SQLException{
		CategoriaBean bean = new CategoriaBean();
		
		bean.setId_categoria(rs.getInt("id_categoria"));
		bean.setNome(rs.getString("nome"));
		bean.setDescrizione(rs.getString("descrizione"));
		
		return bean;
	}

}
