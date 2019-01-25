package model;

@SuppressWarnings("serial")
public class ClienteBean extends UserBean {

	String data_nascita;
	String cellulare;
	
	public ClienteBean() {
		super();
		data_nascita="";
		cellulare="";
	}

	public String getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(String data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
}
