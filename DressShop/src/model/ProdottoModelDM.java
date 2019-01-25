package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.websocket.Session;

public class ProdottoModelDM implements ProdottoModel<ProdottoBean> {

	private static final String TABLE_NAME = "PRODOTTO";
	//private static final String TABLE_NAME2 = "carrello";
	
	@Override
	public Collection<ProdottoBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatament = null;
		
		Collection<ProdottoBean> products = new LinkedList<ProdottoBean>();
		
		String selectSQL = "SELECT * FROM " + ProdottoModelDM.TABLE_NAME;
		
		if(order != null && !order.equals("")) { // se all'inizio la lista è vuota la creo altrimenti la ordino
			selectSQL += " ORDER BY " + order;
		}
		
		try {
			connection = DriverManagerConnectionPool.getConnection(); // crea la connessione
			preparedStatament = connection.prepareStatement(selectSQL); //  preparo la query
			
			System.out.println("doRetrieveAll:" + preparedStatament.toString()); 
			
			ResultSet rs = preparedStatament.executeQuery(); //eseguo la query
			
			while(rs.next()) {   /* 
			
			*id = -1;
		codice="";
		description= "";
		marca = "";
		prezzoV = 0;
		ivaV=0;
		codC=0;
		quantity = 0;
			*
			*
			*/
				ProdottoBean bean = new ProdottoBean();  // metto i risultati nei campi del product bean
				
				bean.setId_prodotto(rs.getInt("id_prodotto"));
				bean.setCodice_prodotto(rs.getString("codice_prodotto"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setMarca(rs.getString("marca"));
				bean.setModello(rs.getString("modello"));
				bean.setTaglia(rs.getString("taglia"));
				bean.setColore(rs.getString("colore"));
				bean.setTipo(rs.getString("tipo"));
				bean.setFoto(rs.getString("foto"));
				bean.setCategoria(rs.getInt("categoria"));
				bean.setPromozione(rs.getInt("promozione"));
				
				products.add(bean); //aggiungo i prodotti nella collezione
			}
		} finally {
			try {
				if(preparedStatament != null)
					preparedStatament.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}

		return products;
	}	

	@Override
	public ProdottoBean doRetrieveByKey(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatament = null;
		
		ProdottoBean bean = new ProdottoBean();
		
		String selectSQL = "SELECT * FROM " + ProdottoModelDM.TABLE_NAME + " WHERE Id = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatament = connection.prepareStatement(selectSQL);
			
			preparedStatament.setInt(1, code);
			
			System.out.println("doRetrieveByKey:" + preparedStatament.toString());
			
			ResultSet rs = preparedStatament.executeQuery();
			
			while(rs.next()) {		
				bean.setId_prodotto(rs.getInt("id_prodotto"));
				bean.setCodice_prodotto(rs.getString("codice_prodotto"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setMarca(rs.getString("marca"));
				bean.setModello(rs.getString("modello"));
				bean.setTaglia(rs.getString("taglia"));
				bean.setColore(rs.getString("colore"));
				bean.setTipo(rs.getString("tipo"));
				bean.setFoto(rs.getString("foto"));
				bean.setCategoria(rs.getInt("categoria"));
				bean.setPromozione(rs.getInt("promozione"));
				

			}
		} finally {
			try {
				if(preparedStatament != null)
					preparedStatament.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}	
		
		return bean;
	}

	@Override
	public void doSave(ProdottoBean product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ProdottoModelDM.TABLE_NAME
				+ " (codice_prodotto,descrizione,marca,modello,taglia,colore,tipo,foto,categoria,promozione) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, product.getCodice_prodotto());
			preparedStatement.setString(2, product.getDescrizione());
			preparedStatement.setString(3, product.getMarca());
			preparedStatement.setString(4, product.getMarca());
			preparedStatement.setString(5, product.getModello());
			preparedStatement.setString(6, product.getTaglia());
			preparedStatement.setString(7, product.getTipo());
			preparedStatement.setString(8, product.getFoto());
			preparedStatement.setInt(9, product.getCategoria());
			preparedStatement.setInt(10, product.getPromozione());

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

	@Override
	public void doUpdate(ProdottoBean product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE " + ProdottoModelDM.TABLE_NAME
				+ " SET Codice = ?, Prodotto = ?, Marca = ?, IvaVendita = ?, Prezzo_Vendita=?, CodCategoria=?, quantita=?"
				+ " WHERE Id = ? ;";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, product.getCodice_prodotto());
			preparedStatement.setString(2, product.getDescrizione());
			preparedStatement.setString(3, product.getMarca());
			preparedStatement.setString(4, product.getMarca());
			preparedStatement.setString(5, product.getModello());
			preparedStatement.setString(6, product.getTaglia());
			preparedStatement.setString(7, product.getTipo());
			preparedStatement.setString(8, product.getFoto());
			preparedStatement.setInt(9, product.getCategoria());
			preparedStatement.setInt(10, product.getPromozione());

			
			System.out.println("doUpdate: "+ preparedStatement.toString());
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

	@Override
	public boolean doDelete(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ProdottoModelDM.TABLE_NAME + " WHERE Id= ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);

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
	
	public void doShop(ProdottoBean bean, UserBean user) throws SQLException{ // funzione che conferma l'acquisto del carrello
		
		
		
	}

	/*public void doShop(ProdottoBean bean, String string) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "Insert into " + ProdottoModelDM.TABLE_NAME2
				+ " (email,IdProdotto) VALUES (?,?);";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
				
		
			preparedStatement.setString(1, string);
			preparedStatement.setInt(2, bean.getId_prodotto());
			
			
			
			System.out.println("doShop...: "+ preparedStatement.toString());
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
	*/
	public void doUpdateQuantita(ProdottoInCatalogo product) throws SQLException { //prodotto in catalogo
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE " + ProdottoModelDM.TABLE_NAME
				+ " SET quantita=?"
				+ " WHERE Id = ? ;";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setFloat(1, product.getQuantita());
			preparedStatement.setInt(2, product.getId_prodotto());
			
			System.out.println("doUpdate: "+ preparedStatement.toString());
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

	public Collection<ProdottoBean> getStorico(String user) throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<ProdottoBean> products = new LinkedList<ProdottoBean>();
		String insertSQL = "select prodotti.prodotto, prodotti.urlImmagine from prodotti,carrello where carrello.Nickname= ? and carrello.IdProdotto=prodotti.Id;";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
				
		
			preparedStatement.setString(1,user);
	
	ResultSet rs = preparedStatement.executeQuery();


	
			while(rs.next()) {		
				ProdottoBean bean = new ProdottoBean();
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setFoto(rs.getString("foto"));
				products.add(bean);
			}
			
			System.out.println("getStorico...: "+ preparedStatement.toString());
		

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return products;
	}
	
	
public Collection<String> getStoricoData(String user) throws SQLException{
	ArrayList<String> date = new ArrayList<String>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	
		String insertSQL = "select  carrello.Data from prodotti,carrello where carrello.Nickname= ? and carrello.IdProdotto=prodotti.Id;";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
				
		
			preparedStatement.setString(1,user);
	
	ResultSet rs = preparedStatement.executeQuery();
	
			
			while(rs.next()) {		
				
				date.add(rs.getString("Data"));
				
			}
			
			System.out.println("getStorico...: "+ preparedStatement.toString());
		

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return date;
	}
	
	public ProdottoBean doRetrieveForCategory(int codCategory) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatament = null;
		
		ProdottoBean bean = new ProdottoBean();
		
		String selectSQL = "SELECT * FROM " + ProdottoModelDM.TABLE_NAME + " WHERE CodCategoria = ?" +"ORDER BY "+ codCategory;
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatament = connection.prepareStatement(selectSQL);
			
			preparedStatament.setInt(1, codCategory);
			
			System.out.println("doRetrieveForCategory:" + preparedStatament.toString());
			
			ResultSet rs = preparedStatament.executeQuery();
			
			while(rs.next()) {		
				bean.setId_prodotto(rs.getInt("id_prodotto"));
				bean.setCodice_prodotto(rs.getString("codice_prodotto"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setMarca(rs.getString("marca"));
				bean.setModello(rs.getString("modello"));
				bean.setTaglia(rs.getString("taglia"));
				bean.setColore(rs.getString("colore"));
				bean.setTipo(rs.getString("tipo"));
				bean.setFoto(rs.getString("foto"));
				bean.setCategoria(rs.getInt("categoria"));
				bean.setPromozione(rs.getInt("promozione"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatament != null)
					preparedStatament.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}	
		
		return bean;
	}

	@Override
	public void doUpdateQuantita(ProdottoBean bean) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
}
