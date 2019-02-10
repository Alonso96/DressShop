package model.prodotto;

import java.sql.SQLException;
import java.util.Collection;

public interface ProdottoModel<ProdottoBean> {
	
	public ProdottoBean doRetrieveByKey(int id_prodotto) throws SQLException;
	
	public Collection<ProdottoBean> doRetrieveAll() throws SQLException;
	
	public int doSave(ProdottoBean prodotto) throws SQLException;
	
	public void doUpdate(ProdottoBean prodotto) throws SQLException;
	
	public boolean doDelete(int id_prodotto) throws SQLException;

	Collection<ProdottoBean> doRetrieveAllNotInVendita() throws SQLException;

	Collection<ProdottoBean> doRetrieveAllPrezzoZero() throws SQLException;



	void doUpdatePrezzo(int id, float prezzo) throws SQLException;
	
}
