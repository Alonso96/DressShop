package model;

import java.sql.Date;

public class PromozioneBean {

	int id_promozione;
	Date data_inizio;
	Date data_fine;
	int sconto;
	
	public PromozioneBean(){
		
	}

	public int getId_promozione() {
		return id_promozione;
	}
	
	public void setId_promozione(int id_promozione){
		this.id_promozione = id_promozione;
	}

	public Date getData_inizio() {
		return data_inizio;
	}

	public void setData_inizio(Date data_inizio) {
		this.data_inizio = data_inizio;
	}

	public Date getData_fine() {
		return data_fine;
	}

	public void setData_fine(Date data_fine) {
		this.data_fine = data_fine;
	}

	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PromozioneBean other = (PromozioneBean) obj;
		if (other.id_promozione != id_promozione)
				return false;
		
		return true;
	}
}
