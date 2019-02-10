package model.prodotto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.DriverManagerConnectionPool;

public class ProdottoInOrdineModelDM implements ProdottoModel<ProdottoBean>{

	private static final String TABLE_1 ="PRODOTTO";
	private static final String TABLE_2 ="PRODOTTO_IN_ORDINE";

	@Override
	public ProdottoBean doRetrieveByKey(int id_prodotto_ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		ProdottoBean bean = new ProdottoInOrdineBean();
		
		String queryString ="Select " + TABLE_1 + ".id_prodotto, codice_prodotto, descrizione, marca, modello, categoria, foto, promozione, " 
		+ TABLE_2 + ".prezzo_compl, " + TABLE_2 + ".iva, taglia, quantita, reso FROM " + TABLE_1 + "join" + TABLE_2 + " WHERE " + TABLE_1 + ".id_prodotto_ordine = ?";
		
		try{
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(queryString);
			statement.setInt(1, id_prodotto_ordine);
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
	public Collection<ProdottoBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		Collection<ProdottoBean> listaBean = new ArrayList<ProdottoBean>();
		
		String queryString ="Select " + TABLE_1 + ".id_prodotto, codice_prodotto, descrizione, marca, modello, categoria, foto, promozione, " 
		+ TABLE_2 + ".prezzo, " + TABLE_2 + ".iva, taglia, quantita, reso FROM " + TABLE_1 + "join" + TABLE_2;

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
	public int doSave(ProdottoBean prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement statement_2 = null;
		PreparedStatement statement_1 = null;
		int id;
		String insertString_2=" INSERT INTO " + TABLE_2 + "(id_prodotto, prezzo_compl, iva, taglia, quantita, reso) VALUES(?, ?, ?, ?, ?, ?)";
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement_2 = (PreparedStatement) connection.prepareStatement(insertString_2);

			statement_2.setInt(1, ((ProdottoInOrdineBean)prodotto).getId_prodotto());
			statement_2.setFloat(2, ((ProdottoInOrdineBean)prodotto).getPrezzo_compl());
			statement_2.setFloat(3, ((ProdottoInOrdineBean)prodotto).getIva());
			statement_2.setString(4, ((ProdottoInOrdineBean)prodotto).getTaglia());
			statement_2.setInt(5, ((ProdottoInOrdineBean)prodotto).getQuantita());
			statement_2.setBoolean(6, ((ProdottoInOrdineBean)prodotto).isReso());
			statement_2.executeUpdate();
			connection.commit();
			
		} finally{
			if(statement_2 != null) statement_2.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
		String insertString_1="SELECT last_insert_id() as last_id from " + TABLE_2 + ";";
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
//da rivedere
	@Override
	public void doUpdate(ProdottoBean prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;

		String insertString_2="UPDATE " + TABLE_2 + " SET prezzo_compl = ?, iva = ?, taglia = ?, quantita = ? reso = ? WHERE id_prodotto_ordine = ?";
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(insertString_2);

			statement.setFloat(1, ((ProdottoInOrdineBean)prodotto).getPrezzo_compl());
			statement.setInt(2, ((ProdottoInOrdineBean)prodotto).getIva());
			statement.setString(3, ((ProdottoInOrdineBean)prodotto).getTaglia());
			statement.setInt(4, ((ProdottoInOrdineBean)prodotto).getQuantita());
			statement.setBoolean(5, ((ProdottoInOrdineBean)prodotto).isReso());
			statement.setInt(6, ((ProdottoInOrdineBean)prodotto).getId_prodotto_ordine());
			statement.executeUpdate();
			
			connection.commit();
			
		} finally{
			if(statement != null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}

	@Override
	public boolean doDelete(int id_prodotto_ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		int result = 0;
		
		String deleteString ="DELETE FROM " + TABLE_2 + " WHERE id_prodotto_ordine = ?";
		
		try {
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(deleteString);
			statement.setInt(1, id_prodotto_ordine);
			
			result = statement.executeUpdate();
			
			connection.commit();
		} finally{
			if(statement!=null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
		
		return result != 0;
	}
	
	public Collection<ProdottoBean> doRetrieveByOrder(int id_ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		Collection<ProdottoBean> listaBean = new ArrayList<ProdottoBean>();

		String queryString ="Select " + TABLE_1 + ".id_prodotto, codice_prodotto, descrizione, marca, modello, "
			+ "categoria, foto, promozione, id_prodotto_ordine, " + TABLE_2 + ".prezzo_compl, " + TABLE_2 + ".iva, taglia, "
			+ "quantita, reso FROM " + TABLE_1 + " join " + TABLE_2 + " join ORDINAZIONE WHERE ordine = ? and ordine = id_prodotto_ordine "
			+ "and " + TABLE_1 + ".id_prodotto = " + TABLE_2 + ".id_prodotto";
		
		try{
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(queryString);
			statement.setInt(1, id_ordine);
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

	private static ProdottoBean getBean(ResultSet rs) throws SQLException{
		ProdottoBean bean = new ProdottoInOrdineBean();
		
		bean.setId_prodotto(rs.getInt("PRODOTTO.id_prodotto"));
		bean.setCodice_prodotto(rs.getString("promozione"));
		bean.setDescrizione(rs.getString("descrizione"));
		bean.setMarca(rs.getString("marca"));
		bean.setModello(rs.getString("modello"));
		bean.setFoto(rs.getString("foto"));
		bean.setCategoria(rs.getString("categoria"));
		bean.setPromozione(rs.getInt("promozione"));
		((ProdottoInOrdineBean)bean).setId_prodotto_ordine(rs.getInt("id_prodotto_ordine"));
		((ProdottoInOrdineBean)bean).setPrezzo_compl(rs.getFloat("PRODOTTO_IN_ORDINE.prezzo_compl"));
		((ProdottoInOrdineBean)bean).setIva(rs.getInt("PRODOTTO_IN_ORDINE.iva"));
		((ProdottoInOrdineBean)bean).setQuantita(rs.getInt("quantita"));
		((ProdottoInOrdineBean)bean).setTaglia(rs.getString("taglia"));
		((ProdottoInOrdineBean)bean).setReso(rs.getBoolean("reso"));
		
		return bean;
	}

	@Override
	public Collection<ProdottoBean> doRetrieveAllNotInVendita() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ProdottoBean> doRetrieveAllPrezzoZero() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doUpdatePrezzo(int id, float prezzo) throws SQLException {
		// TODO Auto-generated method stub
		//
	}

	
}
