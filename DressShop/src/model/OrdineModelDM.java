package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdineModelDM {


	@SuppressWarnings({ "unchecked", "rawtypes"})
public synchronized static ArrayList<Ordine> doRetrieveByKey(int id_ordine) throws SQLException 
{
	ArrayList<Ordine> ordini=new ArrayList();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	String SQL = "select id_ordine, data, pagato, carta_credito, indirizzo, cliente, tipo_spedizione, costo_spedizione from ORDINE where id_ordine ='" + id_ordine + "';";
	try {
		connection = DriverManagerConnectionPool.getConnection();
		preparedStatement = connection.prepareStatement(SQL);
		ResultSet rs=preparedStatement.executeQuery(SQL);
		while(rs.next())
		{
			Ordine ordine=new Ordine();
			ordine.setData(rs.getDate(1));
			ordine.setPagato(rs.getBoolean(2));
			ordine.setCarta_credito(rs.getString(3));
			ordine.setIndirizzo(rs.getString(4));
			ordine.setCliente(rs.getInt(5));
			ordine.setTipo_spedizione(rs.getString(6));
			ordine.setCosto_spedizione(rs.getFloat(7));
			ordini.addAll(ordini);
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
	return ordini;
}
	
	@SuppressWarnings({ "unchecked", "rawtypes"})
public synchronized static ArrayList<Ordine> doRetrieveByCliente(int cliente) throws SQLException 
{
	ArrayList<Ordine> ordini=new ArrayList();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	String SQL = "select id_ordine, data, pagato, carta_credito, indirizzo, cliente, tipo_spedizione, costo_spedizione from ORDINE where cliente ='" + cliente + "';";
	try {
		connection = DriverManagerConnectionPool.getConnection();
		preparedStatement = connection.prepareStatement(SQL);
		ResultSet rs=preparedStatement.executeQuery(SQL);
		while(rs.next())
		{
			Ordine ordine=new Ordine();
			ordine.setData(rs.getDate(1));
			ordine.setPagato(rs.getBoolean(2));
			ordine.setCarta_credito(rs.getString(3));
			ordine.setIndirizzo(rs.getString(4));
			ordine.setCliente(rs.getInt(5));
			ordine.setTipo_spedizione(rs.getString(6));
			ordine.setCosto_spedizione(rs.getFloat(7));
			ordini.addAll(ordini);
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
	return ordini;
}

}