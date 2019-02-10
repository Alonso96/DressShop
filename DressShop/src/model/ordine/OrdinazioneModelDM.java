package model.ordine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DriverManagerConnectionPool;

public class OrdinazioneModelDM implements OrdinazioneModel{

	private static final String TABLE = "ORDINAZIONE";

	@Override
	public void doSave(OrdinazioneBean ordinazione) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;

		String insertString=" INSERT INTO " + TABLE + " (ordine, prodotto) VALUES(?, ?)";
		
		try{ 
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(insertString);

			statement.setInt(1, ordinazione.getOrdine());
			statement.setInt(2, ordinazione.getProdotto());
			statement.executeUpdate();
			
			connection.commit();
		} finally{
			if(statement!= null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
	}

	@Override
	public boolean doDelete(OrdinazioneBean ordinazione) throws SQLException {
		Connection connection = null;
		PreparedStatement statement=null;
		int result = 0;
		
		String deleteString ="DELETE FROM " + TABLE + " WHERE ordine = ? and prodotto = ?";
		
		try {
			connection = (Connection) DriverManagerConnectionPool.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(deleteString);
			statement.setInt(1, ordinazione.getOrdine());
			statement.setInt(2, ordinazione.getProdotto());
			
			result = statement.executeUpdate();
			
			connection.commit();
		} finally{
			if(statement!=null) statement.close();
			DriverManagerConnectionPool.releaseConnection(connection);
		}
		
		return result != 0;
	}

}
