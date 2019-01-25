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

public class ProductModelDM implements ProductModel<ProductBean> {

	private static final String TABLE_NAME = "prodotti";
	private static final String TABLE_NAME2 = "carrello";
	
	@Override
	public Collection<ProductBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatament = null;
		
		Collection<ProductBean> products = new LinkedList<ProductBean>();
		
		String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME;
		
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
				ProductBean bean = new ProductBean();  // metto i risultati nei campi del product bean
				
				bean.setId(rs.getInt("Id"));
				bean.setCodice(rs.getString("Codice"));
				bean.setDescription(rs.getString("Prodotto"));
				bean.setMarca(rs.getString("Marca"));
				bean.setPrezzoV(rs.getInt("Prezzo_vendita"));
				bean.setIvaV(rs.getInt("IvaVendita"));
				bean.setCodC(rs.getInt("CodCategoria"));
				bean.setQuantity(rs.getInt("quantita"));
				bean.setUrlPercorso(rs.getString("urlImmagine"));
				
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
	public ProductBean doRetrieveByKey(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatament = null;
		
		ProductBean bean = new ProductBean();
		
		String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME + " WHERE Id = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatament = connection.prepareStatement(selectSQL);
			
			preparedStatament.setInt(1, code);
			
			System.out.println("doRetrieveByKey:" + preparedStatament.toString());
			
			ResultSet rs = preparedStatament.executeQuery();
			
			while(rs.next()) {		
				bean.setId(rs.getInt("Id"));
				bean.setCodice(rs.getString("Codice"));
				bean.setDescription(rs.getString("Prodotto"));
				bean.setMarca(rs.getString("Marca"));
				bean.setPrezzoV(rs.getInt("Prezzo_vendita"));
				bean.setIvaV(rs.getInt("IvaVendita"));
				bean.setCodC(rs.getInt("CodCategoria"));
				bean.setQuantity(rs.getInt("quantita"));
				bean.setUrlPercorso(rs.getString("urlImmagine"));

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
	public void doSave(ProductBean product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ProductModelDM.TABLE_NAME
				+ " (Codice,Prodotto,Marca,IvaVendita,Prezzo_Vendita,CodCategoria,quantita) VALUES (?, ?, ?, ?, ?, ?, ?);";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, product.getCodice());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setString(3, product.getMarca());
			preparedStatement.setFloat(4, product.getIvaV());
			preparedStatement.setFloat(5, product.getPrezzoV());
			preparedStatement.setInt(6, product.getCodC());
			preparedStatement.setInt(7, product.getQuantity());

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
	public void doUpdate(ProductBean product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE " + ProductModelDM.TABLE_NAME
				+ " SET Codice = ?, Prodotto = ?, Marca = ?, IvaVendita = ?, Prezzo_Vendita=?, CodCategoria=?, quantita=?"
				+ " WHERE Id = ? ;";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, product.getCodice());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setString(3, product.getMarca());
			preparedStatement.setFloat(4, product.getIvaV());
			preparedStatement.setFloat(5, product.getPrezzoV());
			preparedStatement.setInt(6, product.getCodC());
			preparedStatement.setInt(7, product.getQuantity());
			
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

		String deleteSQL = "DELETE FROM " + ProductModelDM.TABLE_NAME + " WHERE Id= ?";

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
	
	public void doShop(ProductBean bean, UserBean user) throws SQLException{ // funzione che conferma l'acquisto del carrello
		
		
		
	}

	public void doShop(ProductBean bean, String string) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "Insert into " + ProductModelDM.TABLE_NAME2
				+ " (Nickname,IdProdotto) VALUES (?,?);";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
				
		
			preparedStatement.setString(1, string);
			preparedStatement.setInt(2, bean.getId() );
			
			
			
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
	public void doUpdateQuantita(ProductBean product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE " + ProductModelDM.TABLE_NAME
				+ " SET quantita=?"
				+ " WHERE Id = ? ;";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, product.getQuantity()-1);
			preparedStatement.setInt(2, product.getId());
			
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

	public Collection<ProductBean> getStorico(String user) throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<ProductBean> products = new LinkedList<ProductBean>();
		String insertSQL = "select prodotti.prodotto, prodotti.urlImmagine from prodotti,carrello where carrello.Nickname= ? and carrello.IdProdotto=prodotti.Id;";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
				
		
			preparedStatement.setString(1,user);
	
	ResultSet rs = preparedStatement.executeQuery();
	
			
			while(rs.next()) {		
				ProductBean bean = new ProductBean();
				bean.setDescription(rs.getString("Prodotto"));
				bean.setUrlPercorso(rs.getString("urlImmagine"));
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
	
	public ProductBean doRetrieveForCategory(int codCategory) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatament = null;
		
		ProductBean bean = new ProductBean();
		
		String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME + " WHERE CodCategoria = ?" +"ORDER BY "+ codCategory;
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatament = connection.prepareStatement(selectSQL);
			
			preparedStatament.setInt(1, codCategory);
			
			System.out.println("doRetrieveForCategory:" + preparedStatament.toString());
			
			ResultSet rs = preparedStatament.executeQuery();
			
			while(rs.next()) {		
				bean.setId(rs.getInt("Id"));
				bean.setCodice(rs.getString("Codice"));
				bean.setDescription(rs.getString("Prodotto"));
				bean.setMarca(rs.getString("Marca"));
				bean.setPrezzoV(rs.getInt("Prezzo_vendita"));
				bean.setIvaV(rs.getInt("IvaVendita"));
				bean.setCodC(rs.getInt("CodCategoria"));
				bean.setQuantity(rs.getInt("quantita"));
				bean.setUrlPercorso(rs.getString("urlImmagine"));

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
}
