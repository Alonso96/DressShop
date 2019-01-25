package model;
import java.sql.Date;

public class CartaDiCredito {
	public CartaDiCredito()
	{
		;
	}
	public CartaDiCredito(int numero_carta, Date data_scadenza, int cvv, String nome_proprietario, String cognome_proprietario)
	{
		this.numero_carta=numero_carta;
		this.data_scadenza=data_scadenza;
		this.cvv=cvv;
		this.nome_proprietario=nome_proprietario;
		this.cognome_proprietario=cognome_proprietario;
	}
	
	public int getNumeroCarta()
	{
		return numero_carta;
	}
	
	public Date getDataScadenza()
	{
		return data_scadenza;
	}
	
	public int getCvv()
	{
		return cvv;
	}
	
	public String getNome_proprietario()
	{
		return nome_proprietario;
	}
	public String getCognome_proprietario()
	{
		return cognome_proprietario;
	}
	
	public void setNumeroCarta(int numero_carta)
	{
		this.numero_carta=numero_carta;
	}
	
	public void setDataScadenza(Date data_scadenza)
	{
		this.data_scadenza=data_scadenza;
	}
	
	public void setCvv(int cvv)
	{
		this.cvv=cvv;
	}
	
	public void setNome_proprietario(String nome_proprietario)
	{
		this.nome_proprietario=nome_proprietario;
	}
	public void setCognome_proprietario(String cognome_proprietario)
	{
		this.cognome_proprietario=cognome_proprietario;
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
		CartaDiCredito a=(CartaDiCredito) otherObject;
		if(this.numero_carta==a.numero_carta)
			return true;
		else
			return false;
	}
	
	private int numero_carta;
	private Date data_scadenza;
	private int cvv;
	private String nome_proprietario;
	private String cognome_proprietario;
	private int cliente;
}