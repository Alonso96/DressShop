package model;

public class ProdottoInOrdine extends ProdottoBean{

	protected float prezzo;
	protected float iva;
	protected float quantita;
	
	public ProdottoInOrdine() {
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

	public void setQuantita(float quantità) {
		this.quantita = quantità;
	}
}
