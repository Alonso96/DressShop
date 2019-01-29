package model;

import java.sql.SQLException;
import java.util.Collection;

public class ProdottoInOrdineModelDM implements ProdottoModel<ProdottoBean>{

	@Override
	public ProdottoBean doRetrieveByKey(int id_prodotto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ProdottoBean> doRetrieveAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doSave(ProdottoBean prodotto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doUpdate(ProdottoBean prodotto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean doDelete(int id_prodotto) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Collection<ProdottoBean> doRetrieveByOrder(int id_ordine){
		
		return null;
	}

}
