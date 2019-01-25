package model;

public class ProdottoInOrdine extends ProdottoBean{

	protected float prezzo;
	protected float iva;
	protected float quantità;
	
	public ProdottoInOrdine() {
		super();
		prezzo=0;
		iva=0;
		quantità=0;
		
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

	public float getQuantità() {
		return quantità;
	}

	public void setQuantità(float quantità) {
		this.quantità = quantità;
	}
}
