package model.ordine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.DriverManagerConnectionPool;

public class OrdineModelDM implements OrdineModel{

	private static final String TABLE ="ORDINE";

	@Override
	public OrdineBean doRetrieveByKey(int id_ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		OrdineBean bean = new OrdineBean();
		
		String queryString ="Select * FROM " + TABLE + " WHERE id_ordine = ?";
		
		try{
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(queryString);
			statement.setInt(1, id_ordine);
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
	public Collection<OrdineBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		Collection<OrdineBean> listaBean = new ArrayList<OrdineBean>();
		
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
	public int doSave(OrdineBean ordine) throws SQLException {	//restituisce l'id auto_increment della tupla inserita
		Connection connection = null;
		PreparedStatement statement=null;
		PreparedStatement statement_1=null;
		int id;
		String insertString=" INSERT INTO " + TABLE + " (data, pagato, carta_credito, "
				+ "indirizzo, utente, totale, tipo_spedizione, costo_spedizione) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(insertString, statement.RETURN_GENERATED_KEYS);

			statement.setDate(1, ordine.getData());
			statement.setBoolean(2, ordine.isPagato());
			statement.setString(3, ordine.getCarta_credito());
			statement.setInt(4, ordine.getIndirizzo());
			statement.setInt(5, ordine.getUtente());
			statement.setFloat(6, ordine.getTotale());
			statement.setString(7, ordine.getTipo_spedizione());
			statement.setFloat(8, ordine.getCosto_spedizione());
			id = statement.executeUpdate();
			System.out.println("ordine" + id);
			connection.commit();
		} finally{
			if(statement!= null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
		String insertString_1="SELECT last_insert_id() as last_id from " + TABLE + ";";
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement_1 = (PreparedStatement) connection.prepareStatement(insertString_1);
			ResultSet rs = statement_1.executeQuery();
			rs.next();
			id = rs.getInt("last_id");
			
			connection.commit();
		} finally{
			if(statement_1 != null) statement_1.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}

		return id;
	}

	@Override
	public void doUpdate(OrdineBean ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;

		String insertString="UPDATE" + TABLE + " SET data = ?, pagato = ?, carta_credito = ?, "
				+ "indirizzo = ?, utente = ?, totale = ?, tipo_spedizione = ?, costo_spedizione = ? WHERE id_ordine = ?;";
		
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(insertString);

			statement.setDate(1, ordine.getData());
			statement.setBoolean(2, ordine.isPagato());
			statement.setString(3, ordine.getCarta_credito());
			statement.setInt(4, ordine.getIndirizzo());
			statement.setInt(5, ordine.getUtente());
			statement.setFloat(6, ordine.getTotale());
			statement.setString(7, ordine.getTipo_spedizione());
			statement.setFloat(8, ordine.getCosto_spedizione());
			statement.executeUpdate();
			
			connection.commit();
		} finally{
			if(statement!= null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}
	
	

	@Override
	public boolean doDelete(int id_ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		int result = 0;
		
		String deleteString ="DELETE FROM " + TABLE + " WHERE id_ordine = ?";
		
		try {
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(deleteString);
			statement.setInt(1, id_ordine);
			
			result = statement.executeUpdate();
			
			connection.commit();
		} finally{
			if(statement!=null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
		
		return result != 0;
	}

	@Override
	public Collection<OrdineBean> doRetrieveByUtente(int utente) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		Collection<OrdineBean> listaBean = new ArrayList<OrdineBean>();
		
		String queryString ="Select * FROM " + TABLE + " WHERE utente = ? order by data desc";
		
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

	private static OrdineBean getBean(ResultSet rs) throws SQLException{
		OrdineBean bean = new OrdineBean();
		
		bean.setId_ordine(rs.getInt("id_ordine"));
		bean.setData(rs.getDate("data"));
		bean.setPagato(rs.getBoolean("pagato"));
		bean.setCarta_credito(rs.getString("carta_credito"));
		bean.setIndirizzo(rs.getInt("indirizzo"));
		bean.setUtente(rs.getInt("utente"));
		bean.setTotale(rs.getFloat("totale"));
		bean.setTipo_spedizione(rs.getString("tipo_spedizione"));
		bean.setCosto_spedizione(rs.getFloat("costo_spedizione"));
		
		return bean;
	}
}