package model;

import java.sql.SQLException;
import java.util.Collection;

public interface OrdineModel<OrdineModel> {

	public OrdineBean doRetrieveByKey(int id_ordine) throws SQLException;
	
	public Collection<OrdineBean> doRetrieveAll() throws SQLException;
	
	public void doSave(OrdineBean ordine) throws SQLException;
	
	public void doUpdate(OrdineBean ordine) throws SQLException;
	
	public boolean doDelete(int id_ordine) throws SQLException;
	
	public OrdineBean doRetrieveByUtente(int utente) throws SQLException;

}
