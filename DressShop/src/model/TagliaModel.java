package model;

import java.sql.SQLException;
import java.util.Collection;

public interface TagliaModel {

	public Collection<TagliaBean> doRetrieveByProdotto(int id_prodotto) throws SQLException;
	
	public void doSave(TagliaBean taglia) throws SQLException;
	
	public void doUpdate(TagliaBean taglia) throws SQLException;
	
	public boolean doDelete(TagliaBean taglia) throws SQLException;

}
