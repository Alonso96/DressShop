package model;

public class ProdottoInOrdineBean extends ProdottoBean{

	private static final long serialVersionUID = 1L;

	private float prezzo;
	private int iva;
	private String taglia;
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

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public String getTaglia() {
		return taglia;
	}

	public void setTaglia(String taglia) {
		this.taglia = taglia;
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
