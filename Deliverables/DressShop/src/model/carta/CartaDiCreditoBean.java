package model.carta;
import java.sql.Date;

public class CartaDiCreditoBean {
//
	private String numero_carta;
	private Date data_scadenza;
	private String cvv;
	private String nome_proprietario;
	private String cognome_proprietario;
	private int utente;

	public CartaDiCreditoBean(){
		
	}
		
	
	public String getNumero_carta() {
		return numero_carta;
	}


	public void setNumero_carta(String numero_carta) {
		this.numero_carta = numero_carta;
	}


	public Date getData_scadenza() {
		return data_scadenza;
	}


	public void setData_scadenza(Date data_scadenza) {
		this.data_scadenza = data_scadenza;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public String getNome_proprietario() {
		return nome_proprietario;
	}


	public void setNome_proprietario(String nome_proprietario) {
		this.nome_proprietario = nome_proprietario;
	}


	public String getCognome_proprietario() {
		return cognome_proprietario;
	}


	public void setCognome_proprietario(String cognome_proprietario) {
		this.cognome_proprietario = cognome_proprietario;
	}


	public int getUtente() {
		return utente;
	}


	public void setUtente(int utente) {
		this.utente = utente;
	}


	public boolean equals(Object obj){
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		CartaDiCreditoBean other = (CartaDiCreditoBean) obj;
		if(this.numero_carta != other.numero_carta)
			return false;
		
		return true;
	}
}