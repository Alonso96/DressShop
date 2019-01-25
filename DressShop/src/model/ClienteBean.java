package model;

import java.util.Date;

@SuppressWarnings("serial")
public class ClienteBean extends UserBean {

	Date data_nascita;
	String cellulare;
	
	public ClienteBean() {
		super();
		data_nascita=null;
		cellulare="";
	}

	public Date getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
}
