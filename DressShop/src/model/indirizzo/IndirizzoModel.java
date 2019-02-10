package model.indirizzo;

import java.sql.SQLException;
import java.util.Collection;

public interface IndirizzoModel<IndirizzoBean> {

	public IndirizzoBean doRetrieveByKey(int id_indirizzo) throws SQLException;
	
	public Collection<IndirizzoBean> doRetrieveAll() throws SQLException;
	
	public void doSave(IndirizzoBean indirizzo) throws SQLException;
	
	public void doUpdate(IndirizzoBean indirizzo) throws SQLException;
	
	public boolean doDelete(int id_indirizzo) throws SQLException;
	
	public Collection<IndirizzoBean> doRetrieveByUtente(int utente) throws SQLException;

}
