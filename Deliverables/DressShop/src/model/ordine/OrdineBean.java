package model.ordine;
import java.sql.Date;
public class OrdineBean {
	
	private int id_ordine;
	private Date data;
	private boolean pagato;
	private String carta_credito;	//riferimento
	private int indirizzo;			//riferimento
	private int utente;			//riferimento
	private float totale;
	
	
	public float getTotale() {
		return totale;
	}

	public void setTotale(float totale) {
		this.totale = totale;
	}

	private String tipo_spedizione;
	private float costo_spedizione;
	
	
	public OrdineBean(){
	
	}
	
	public int getId_ordine() {
		return id_ordine;
	}
	public void setId_ordine(int id_ordine) {
		this.id_ordine = id_ordine;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public boolean isPagato() {
		return pagato;
	}
	public void setPagato(boolean pagato) {
		this.pagato = pagato;
	}
	public String getCarta_credito() {
		return carta_credito;
	}
	public void setCarta_credito(String carta_credito) {
		this.carta_credito = carta_credito;
	}
	public int getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(int indirizzo) {
		this.indirizzo = indirizzo;
	}
	public int getUtente() {
		return utente;
	}
	public void setUtente(int utente) {
		this.utente = utente;
	}
	public String getTipo_spedizione() {
		return tipo_spedizione;
	}
	public void setTipo_spedizione(String tipo_spedizione) {
		this.tipo_spedizione = tipo_spedizione;
	}
	public float getCosto_spedizione() {
		return costo_spedizione;
	}
	public void setCosto_spedizione(float costo_spedizione) {
		this.costo_spedizione = costo_spedizione;
	}
	
	public boolean equals(Object otherObject)
	{
		if(otherObject==null)
			return false;
		if(this.getClass()!=otherObject.getClass())
			return false;
		OrdineBean a=(OrdineBean) otherObject;
		if(this.id_ordine==a.id_ordine)
			return true;
		else
			return false;
	}
	
}

