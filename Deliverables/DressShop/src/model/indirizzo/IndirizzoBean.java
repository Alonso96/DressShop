package model.indirizzo;

public class IndirizzoBean {
	
	private int id_indirizzo;
	private String nome;
	private String cognome;
	private String cap;
	private String provincia;
	private String citta;
	private String via;
	private String cellulare;
	private int utente;

		
	public IndirizzoBean(){
		
	}

	
	public int getId_indirizzo() {
		return id_indirizzo;
	}

	public void setId_indirizzo(int id_indirizzo) {
		this.id_indirizzo = id_indirizzo;
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

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public int getUtente() {
		return utente;
	}

	public void setUtente(int utente) {
		this.utente = utente;
	}

	public boolean equals(Object otherObject)
	{
		if(otherObject == null)
			return false;
		if(this.getClass() != otherObject.getClass())
			return false;
		IndirizzoBean a = (IndirizzoBean) otherObject;
		if(this.id_indirizzo != a.id_indirizzo)
			return false;
		return true;
	}
}
