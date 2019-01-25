package model;

import java.sql.SQLException;
import java.util.Collection;

public interface CategoriaModel<CategoriaBean> {

	public CategoriaBean doRetrieveByKey(int id_categoria) throws SQLException;
	
	public Collection<CategoriaBean> doRetrieveAll() throws SQLException;
	
	public void doSave(CategoriaBean categoria) throws SQLException;
	
	public void doUpdate(CategoriaBean categoria) throws SQLException;
	
	public boolean doDelete(int id_categoria) throws SQLException;
	
	public CategoriaBean doRetrieveByName(String nome) throws SQLException;

}
