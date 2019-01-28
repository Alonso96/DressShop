package model;

public class ProdottoInCatalogoBean extends ProdottoBean{

	private float prezzo;
	private float iva;
	private float quantita;
	
	
	public ProdottoInCatalogoBean() {
		super();
		prezzo=0;
		iva=0;
		quantita=0;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	public float getIva() {
		return iva;
	}
	public void setIva(float iva) {
		this.iva = iva;
	}
	public float getQuantita() {
		return quantita;
	}
	public void setQuantita(float quantita) {
		this.quantita = quantita;
	}
}
