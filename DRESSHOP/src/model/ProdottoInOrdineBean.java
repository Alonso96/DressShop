package model;

public class ProdottoInOrdineBean extends ProdottoBean{

	private static final long serialVersionUID = 1L;

	private float prezzo;
	private float iva;
	private int quantita;
	private boolean reso;
	
	public ProdottoInOrdineBean() {
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

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	public boolean isReso() {
		return reso;
	}

	public void setReso(boolean reso) {
		this.reso = reso;
	}
}
