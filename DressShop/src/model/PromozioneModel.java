package model;

import java.sql.SQLException;
import java.util.Collection;

public interface PromozioneModel {

public PromozioneBean doRetrieveByKey(int id_promozione) throws SQLException;
	
	public Collection<PromozioneBean> doRetrieveAll() throws SQLException;
	
	public void doSave(PromozioneBean promozione) throws SQLException;
	
	public void doUpdate(PromozioneBean promozione) throws SQLException;
	
	public boolean doDelete(int id_promozione) throws SQLException;
}
