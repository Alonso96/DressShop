package model.carta;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public interface CartaDiCreditoModel<CartaDiCreditoBean> {
	
	public CartaDiCreditoBean doRetrieveByKey(String numero_carta) throws SQLException;
	
	public Collection<CartaDiCreditoBean> doRetrieveAll() throws SQLException;
	
	public void doSave(CartaDiCreditoBean carta) throws SQLException;
	
	public void doUpdate(CartaDiCreditoBean carta) throws SQLException;
	
	public boolean doDelete(String numero_carta) throws SQLException;
	
	public ArrayList<model.carta.CartaDiCreditoBean> doRetrieveByUtente(int utente) throws SQLException;

}
