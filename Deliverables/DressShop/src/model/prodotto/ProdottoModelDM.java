package model.prodotto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.DriverManagerConnectionPool;

public class ProdottoModelDM implements ProdottoModel<ProdottoBean>{

	private static final String TABLE_1 ="PRODOTTO";
	
	@Override
	public ProdottoBean doRetrieveByKey(int id_prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		ProdottoBean bean = new ProdottoBean();
		
		String queryString ="Select * FROM " + TABLE_1 + " WHERE id_prodotto = ?";
		
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
		
		String queryString ="Select * FROM " + TABLE_1;
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

	public Collection<ProdottoBean> doRetrieveAllIn_vendita() throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		Collection<ProdottoBean> listaBean = new ArrayList<ProdottoBean>();
		
		String queryString ="Select * FROM " + TABLE_1 + "WHERE in_vendita = true";
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
	public Collection<ProdottoBean> doRetrieveAllNotInVendita() throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		Collection<ProdottoBean> listaBean = new ArrayList<ProdottoBean>();
		
		String queryString ="Select * FROM " + TABLE_1 + "WHERE in_vendita = false";
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
	public Collection<ProdottoBean> doRetrieveAllPrezzoZero() throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		Collection<ProdottoBean> listaBean = new ArrayList<ProdottoBean>();
		
		String queryString ="select * from "+TABLE_1+" where prezzo_compl=0";
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
	public int doSave(ProdottoBean prodotto) throws SQLException {	//fare inserimento per ogni taglia
		Connection connection = null;
		PreparedStatement statement = null;
		PreparedStatement statement_1 = null;
		int id;
		String insertString_1=" INSERT INTO " + TABLE_1 + " (codice_prodotto, descrizione, marca, modello, "
				+ "prezzo_compl, iva, in_vendita, categoria,foto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(insertString_1);

			statement.setString(1, prodotto.getCodice_prodotto());
			statement.setString(2, prodotto.getDescrizione());
			statement.setString(3, prodotto.getMarca());
			statement.setString(4, prodotto.getModello());
			statement.setFloat(5, 0); //metto 0 perchè magazziniere non può impostare
			statement.setInt(6, 0); //idem
			statement.setBoolean(7, false); //metto sempre false perchè non in vendita all'inizio
			statement.setString(8, prodotto.getCategoria());
			statement.setString(9, prodotto.getFoto());
			//statement.setInt(10, prodotto.getPromozione());
			id = statement.executeUpdate();
			System.out.println("prodotto" + id);
			connection.commit();
			
		} finally{
			if(statement != null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
		String insertString="SELECT last_insert_id() as last_id";
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement_1 = (PreparedStatement) connection.prepareStatement(insertString);
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
	public void doUpdate(ProdottoBean prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		String insertString_1=" UPDATE " + TABLE_1 + " SET codice_prodotto = ?, decrizione = ?, marca = ?, modello = ?, "
				+ "prezzo_compl = ?, iva = ?, in_vendita = ?, categoria = ?, foto = ?, promozione = ? WHERE id_prodotto = ?;";
		
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(insertString_1);

			statement.setString(1, prodotto.getCodice_prodotto());
			statement.setString(2, prodotto.getDescrizione());
			statement.setString(3, prodotto.getMarca());
			statement.setString(4, prodotto.getModello());
			statement.setFloat(5, prodotto.getPrezzo_compl());
			statement.setInt(6, prodotto.getIva());
			statement.setBoolean(7, prodotto.isIn_vendita());
			statement.setString(8, prodotto.getCategoria());
			statement.setString(9, prodotto.getFoto());
			statement.setInt(10, prodotto.getPromozione());
			statement.setInt(11, prodotto.getId_prodotto());
			statement.executeUpdate();
			
			connection.commit();
			
		} finally{
			if(statement != null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}

	@Override
	public boolean doDelete(int id_prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		int result = 0;
		
		String deleteString ="UPDATE " + TABLE_1 + " SET prezzo_compl = 0, iva = 0, in_vendita = false WHERE id_prodotto = ?";
		
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

	public Collection<ProdottoBean> doRetrieveByCategory(String categoria) throws SQLException {	//restituisce i prodotti in vendita
		Connection connection = null;
		PreparedStatement statement=null;
		Collection<ProdottoBean> listaBean = new ArrayList<ProdottoBean>();
		
		String queryString ="Select * FROM " + TABLE_1 + " WHERE categoria = ? and in_vendita = true";
		
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
	
	@Override
	public void doUpdatePrezzo(int id, float prezzo) throws SQLException { //salvo solo il prezzo del prodotto
		Connection connection = null;
		PreparedStatement statement=null;

		String insertString="UPDATE " + TABLE_1 + " SET prezzo_compl= ?, iva=?, in_vendita=? where id_prodotto= ? ;";
		
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(insertString);

			statement.setFloat(1, prezzo);
			statement.setInt(2, 10);
			statement.setBoolean(3,true);
			statement.setInt(4,id);
			statement.executeUpdate();
			
			connection.commit();
		} finally{
			if(statement!= null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}

	private static ProdottoBean getBean(ResultSet rs) throws SQLException{
		ProdottoBean bean = new ProdottoBean();
		
		bean.setId_prodotto(rs.getInt("id_prodotto"));
		bean.setCodice_prodotto(rs.getString("codice_prodotto"));
		bean.setDescrizione(rs.getString("descrizione"));
		bean.setMarca(rs.getString("marca"));
		bean.setModello(rs.getString("modello"));
		bean.setPrezzo_compl(rs.getFloat("prezzo_compl"));
		bean.setIva(rs.getInt("iva"));
		bean.setIn_vendita(rs.getBoolean("in_vendita"));
		bean.setFoto(rs.getString("foto"));
		bean.setCategoria(rs.getString("categoria"));
		bean.setPromozione(rs.getInt("promozione"));
		
		return bean;
	}
}
