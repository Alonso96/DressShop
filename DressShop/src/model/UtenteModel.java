package model;
//
import java.sql.SQLException;
import java.util.Collection;

public interface UtenteModel<UtenteBean> {

	public UtenteBean doRetrieveByKey(int id_utente) throws SQLException;
	
	public Collection<UtenteBean> doRetrieveAll() throws SQLException;
	
	public void doSave(UtenteBean utente) throws SQLException;
	
	public void doUpdate(UtenteBean utente) throws SQLException;
	
	public boolean doDelete(int id_utente) throws SQLException;
	
	public UtenteBean doRetrieveByEmail(String email) throws SQLException;
}
