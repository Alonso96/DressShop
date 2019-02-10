package model.utente;
import java.io.Serializable;
import java.util.Date;

public class UtenteBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int id_utente;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private int tipo ;	//1=cliente, 2=magazziniere, 3=gestore marketing, 4=proprietario
	private Date data_nascita;
	
	public UtenteBean() {
		
	}

		
	public int getId_utente() {
		return id_utente;
	}



	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getTipo() {
		return tipo;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
	}



	public Date getData_nascita() {
		return data_nascita;
	}



	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtenteBean other = (UtenteBean) obj;
		if (other.id_utente != id_utente)
				return false;
		return true;
	}
}