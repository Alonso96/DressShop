package model;

import java.sql.SQLException;
import java.util.Collection;

public interface IndirizzoModel {

	public IndirizzoBean doRetrieveByKey(int id_indirizzo) throws SQLException;
	
	public Collection<IndirizzoBean> doRetrieveAll() throws SQLException;
	
	public void doSave(IndirizzoBean indirizzo) throws SQLException;
	
	public void doUpdate(IndirizzoBean indirizzo) throws SQLException;
	
	public boolean doDelete(int id_indirizzo) throws SQLException;
	
	public IndirizzoBean doRetrieveByUtente(int utente) throws SQLException;

}