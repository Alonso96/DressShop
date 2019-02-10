package model.ordine;

import java.sql.SQLException;

public interface OrdinazioneModel {

	public void doSave(OrdinazioneBean ordinazione) throws SQLException;
	
	public boolean doDelete(OrdinazioneBean ordinazione) throws SQLException;

}
