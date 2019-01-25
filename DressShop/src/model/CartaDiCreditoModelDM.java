package model;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartaDiCreditoModelDM {
	
	@SuppressWarnings({ "deprecation" })
	public synchronized static ArrayList<CartaDiCredito> RestiuisciCarte(String id_utente) throws SQLException 
	{
		ArrayList<CartaDiCredito> carte=new ArrayList<CartaDiCredito>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String SQL = "select carta.numero_carta, data_scadenza, cvv, nome_proprietario, cognome_proprietario;";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL);
			ResultSet rs=preparedStatement.executeQuery(SQL);
			while(rs.next())
			{
				CartaDiCredito carta=new CartaDiCredito();
				carta.setNumeroCarta(rs.getInt(1));
				carta.setCvv(rs.getInt(3));
				Date data=rs.getDate(2);
				int giorno=data.getDate();
				data.setDate(giorno+1);
				carta.setDataScadenza(data);
				carta.setNome_proprietario(rs.getString(4));
				carta.setCognome_proprietario(rs.getString(4));
				carte.add(carta);
			}
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return carte;
	}
	public synchronized static void rimuoviCarta(int carta, ClienteBean cliente) throws SQLException 
	{
		Connection connection = null;
		PreparedStatement stat = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		
		String SQL="delete from CARTA_CREDITO where numero_carta=" + carta + "AND CARTA_CREDITO.cliente =" + cliente.getIdUtente() + ";";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			stat=connection.prepareStatement(SQL);
			ResultSet rs=stat.executeQuery();
			preparedStatement2=connection.prepareStatement(SQL);
			preparedStatement2.executeUpdate();			
			int a=0;;
			if(rs.next())
			a=rs.getInt("count(*)");
			if(a==1)
			{
				preparedStatement=connection.prepareStatement(SQL);
				preparedStatement.executeUpdate();
			}
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
	
	public synchronized static void aggiungiCarta(CartaDiCredito carta,ClienteBean cliente) throws SQLException 
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		String insertSQL = "insert into carta values(?,?,?,?);";
		
		String SQL = "select * from carta where numero_carta=" + carta.getNumeroCarta() + ";";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement2 = connection.prepareStatement(SQL);
			ResultSet rs=preparedStatement2.executeQuery(SQL);
			if(!rs.next())
			{
				preparedStatement=connection.prepareStatement(insertSQL);
				preparedStatement.setInt(1, carta.getNumeroCarta());
				preparedStatement.setDate(2, carta.getDataScadenza());;
				preparedStatement.setInt(3, carta.getCvv());;
				preparedStatement.setString(4, carta.getNome_proprietario());
				preparedStatement.setString(5, carta.getCognome_proprietario());
				preparedStatement.executeUpdate();
			}
			
			preparedStatement.setString(1, cliente.getIdUtente());
			preparedStatement.setInt(2, carta.getNumeroCarta());
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
}