package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ProdottoInCatalogoModelDM implements ProdottoModel<ProdottoBean>{

	private static final String TABLE_1 ="PRODOTTO";
	private static final String TABLE_2 ="PRODOTTO_IN_CATALOGO";

	@Override
	public ProdottoBean doRetrieveByKey(int id_prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		ProdottoBean bean = new ProdottoInCatalogoBean();
		
		String queryString ="Select " + TABLE_1 + ".id_prodotto, codice_prodotto, descrizione, marca, modello, taglia, colore, categoria"
				+ "foto, promozione, prezzo, iva, quantita FROM " + TABLE_1 + "join" + TABLE_2 + " WHERE " + TABLE_1 + ".id_prodotto = ?";
		
		try{
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(queryString);
			statement.setInt(1, id_prodotto);
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
		
		String queryString ="Select " + TABLE_1 + ".id_prodotto, codice_prodotto, descrizione, marca, modello, taglia, colore, categoria"
				+ "foto, promozione, prezzo, iva, quantita FROM " + TABLE_1 + "join" + TABLE_2;
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
	public void doSave(ProdottoBean prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement statement_1 = null;
		PreparedStatement statement_2 = null;
		
		String insertString_1=" INSERT INTO " + TABLE_1 + " (codice_prodotto, decrizione, marca, modello, "
				+ "taglia, colore, categoria, foto, promozione) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement_1 = (PreparedStatement) connection.prepareStatement(insertString_1);

			statement_1.setString(1, prodotto.getCodice_prodotto());
			statement_1.setString(2, prodotto.getDescrizione());
			statement_1.setString(3, prodotto.getMarca());
			statement_1.setString(4, prodotto.getModello());
			statement_1.setString(5, prodotto.getTaglia());
			statement_1.setString(6, prodotto.getColore());
			statement_1.setString(7, prodotto.getCategoria());
			statement_1.setString(8, prodotto.getFoto());
			statement_1.setInt(9, prodotto.getPromozione());
			statement_1.executeUpdate();
			
			connection.commit();
			
		} finally{
			if(statement_1 != null) statement_1.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}

		String insertString_2=" INSERT INTO " + TABLE_2 + "(id_prodotto, prezzo, iva, quantita) VALUES(last_insert_id(), ?, ?, ?)";
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement_2 = (PreparedStatement) connection.prepareStatement(insertString_2);

			statement_2.setFloat(1, ((ProdottoInCatalogoBean)prodotto).getPrezzo());
			statement_2.setFloat(2, ((ProdottoInCatalogoBean)prodotto).getIva());
			statement_2.setInt(3, ((ProdottoInCatalogoBean)prodotto).getQuantita());
			statement_2.executeUpdate();
			
			connection.commit();
			
		} finally{
			if(statement_2 != null) statement_2.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}

	@Override
	public void doUpdate(ProdottoBean prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement statement_1 = null;
		PreparedStatement statement_2 = null;
		
		String insertString_1=" UPDATE " + TABLE_1 + " SET codice_prodotto = ?, decrizione = ?, marca = ?, modello = ?, "
				+ "taglia = ?, colore = ?, categoria = ?, foto = ?, promozione = ? WHERE id_prodotto = ?;";
		
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement_1 = (PreparedStatement) connection.prepareStatement(insertString_1);

			statement_1.setString(1, prodotto.getCodice_prodotto());
			statement_1.setString(2, prodotto.getDescrizione());
			statement_1.setString(3, prodotto.getMarca());
			statement_1.setString(4, prodotto.getModello());
			statement_1.setString(5, prodotto.getTaglia());
			statement_1.setString(6, prodotto.getColore());
			statement_1.setString(7, prodotto.getCategoria());
			statement_1.setString(8, prodotto.getFoto());
			statement_1.setInt(9, prodotto.getPromozione());
			statement_1.setInt(10, prodotto.getId_prodotto());
			statement_1.executeUpdate();
			
			connection.commit();
			
		} finally{
			if(statement_1 != null) statement_1.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}

		String insertString_2="UPDATE " + TABLE_2 + " SET prezzo = ?, iva = ?, quantita = ? WHERE id_prodotto = ?";
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement_2 = (PreparedStatement) connection.prepareStatement(insertString_2);

			statement_2.setFloat(1, ((ProdottoInCatalogoBean)prodotto).getPrezzo());
			statement_2.setFloat(2, ((ProdottoInCatalogoBean)prodotto).getIva());
			statement_2.setInt(3, ((ProdottoInCatalogoBean)prodotto).getQuantita());
			statement_2.setInt(4, ((ProdottoInCatalogoBean)prodotto).getId_prodotto());
			statement_2.executeUpdate();
			
			connection.commit();
			
		} finally{
			if(statement_2 != null) statement_2.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}

	@Override
	public boolean doDelete(int id_prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		int result = 0;
		
		String deleteString ="DELETE FROM " + TABLE_2 + " WHERE id_prodotto = ?";
		
		try {
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(deleteString);
			statement.setInt(1, id_prodotto);
			
			result = statement.executeUpdate();
			
			connection.commit();
		} finally{
			if(statement!=null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
		
		return result != 0;
	}

	public Collection<ProdottoBean> doRetrieveByCategory(String categoria) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		Collection<ProdottoBean> listaBean = new ArrayList<ProdottoBean>();
		
		String queryString ="Select " + TABLE_1 + ".id_prodotto, codice_prodotto, descrizione, marca, modello, taglia, colore, categoria"
				+ "foto, promozione, prezzo, iva, quantita FROM " + TABLE_1 + "join" + TABLE_2 + " WHERE categoria = ?";
		
		try{
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(queryString);
			statement.setString(1, categoria);
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

	public Collection<ProdottoBean> doRetrieveByMarca(String marca) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		Collection<ProdottoBean> listaBean = new ArrayList<ProdottoBean>();
		
		String queryString ="Select " + TABLE_1 + ".id_prodotto, codice_prodotto, descrizione, marca, modello, taglia, colore, categoria"
				+ "foto, promozione, prezzo, iva, quantita FROM " + TABLE_1 + "join" + TABLE_2 + " WHERE marca = ?";
		
		try{
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(queryString);
			statement.setString(1, marca);
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

	public Collection<ProdottoBean> doRetrieveByModello(String modello) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		Collection<ProdottoBean> listaBean = new ArrayList<ProdottoBean>();
		
		String queryString ="Select " + TABLE_1 + ".id_prodotto, codice_prodotto, descrizione, marca, modello, taglia, colore, categoria"
				+ "foto, promozione, prezzo, iva, quantita FROM " + TABLE_1 + "join" + TABLE_2 + " WHERE modello = ?";
		
		try{
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(queryString);
			statement.setString(1, modello);
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
		ProdottoBean bean = new ProdottoInCatalogoBean();
		
		bean.setId_prodotto(rs.getInt("PRODOTTO.id_prodotto"));
		bean.setCodice_prodotto(rs.getString("codice_promozione"));
		bean.setDescrizione(rs.getString("descrizione"));
		bean.setMarca(rs.getString("marca"));
		bean.setModello(rs.getString("modello"));
		bean.setTaglia(rs.getString("taglia"));
		bean.setColore(rs.getString("colore"));
		bean.setFoto(rs.getString("foto"));
		bean.setCategoria(rs.getString("categoria"));
		bean.setPromozione(rs.getInt("promozione"));
		((ProdottoInCatalogoBean)bean).setPrezzo(rs.getFloat("prezzo"));
		((ProdottoInCatalogoBean)bean).setIva(rs.getFloat("iva"));
		((ProdottoInCatalogoBean)bean).setQuantita(rs.getInt("quantita"));
		
		return bean;
	}
}
