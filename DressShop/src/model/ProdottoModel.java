package model;

import java.sql.SQLException;
import java.util.Collection;

public interface ProdottoModel<ProdottoBean> {
	
	public ProdottoBean doRetrieveByKey(int code) throws SQLException;
	
	public Collection<ProdottoBean> doRetrieveAll(String order) throws SQLException;
	
	public void doSave(ProdottoBean product) throws SQLException;
	
	public void doUpdate(ProdottoBean product) throws SQLException;
	
	public boolean doDelete(int code) throws SQLException;

	public void doUpdateQuantita(ProdottoBean bean) throws SQLException;

	public void doShop(ProdottoBean bean, String attribute) throws SQLException;
	
	public ProdottoBean doRetrieveForCategory(int codCategory) throws SQLException;

	public Object getStorico(String attribute) throws SQLException;
	public Object getStoricoData(String attribute) throws SQLException;
}
