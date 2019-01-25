package model;

import java.sql.SQLException;
import java.util.Collection;

public interface ProductModel<T> {
	
	public T doRetrieveByKey(int code) throws SQLException;
	
	public Collection<T> doRetrieveAll(String order) throws SQLException;
	
	public void doSave(T product) throws SQLException;
	
	public void doUpdate(T product) throws SQLException;
	
	public boolean doDelete(int code) throws SQLException;

	public void doUpdateQuantita(ProductBean bean) throws SQLException;

	public void doShop(ProductBean bean, String attribute) throws SQLException;
	
	public ProductBean doRetrieveForCategory(int codCategory) throws SQLException;

	public Object getStorico(String attribute) throws SQLException;
	public Object getStoricoData(String attribute) throws SQLException;
}
