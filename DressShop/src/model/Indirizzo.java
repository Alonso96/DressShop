package model;

public class Indirizzo {
	
	public Indirizzo()
	{
		;
	}

	public int getId_indirizzo() {
		return id_indirizzo;
	}
	public void setId_indirizzo(int id_indirizzo) {
		this.id_indirizzo = id_indirizzo;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public int getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	
	public boolean equals(Object otherObject)
	{
		if(otherObject==null)
			return false;
		if(this.getClass()!=otherObject.getClass())
			return false;
		Indirizzo a=(Indirizzo) otherObject;
		if(this.id_indirizzo==a.id_indirizzo)
			return true;
		else
			return false;
	}
	
	private int id_indirizzo;
	private String cap;
	private String provincia;
	private String citta;
	private String via;
	private int cliente;
	public static void main(String[] args) {
		prezzo=0;
			iva=0;
			quantità=0;
	}
}
