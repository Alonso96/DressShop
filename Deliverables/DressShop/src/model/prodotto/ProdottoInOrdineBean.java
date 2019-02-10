package model.prodotto;

public class ProdottoInOrdineBean extends ProdottoBean{

	private static final long serialVersionUID = 1L;

	private int id_prodotto_ordine;
	private float prezzo_compl;
	private int iva;
	private String taglia;
	private int quantita;
	private boolean reso;
	
	public ProdottoInOrdineBean() {
		super();
		prezzo_compl=0;
		iva=0;
		quantita=0;
	}

	public int getId_prodotto_ordine() {
		return id_prodotto_ordine;
	}

	public void setId_prodotto_ordine(int id_prodotto_ordine) {
		this.id_prodotto_ordine = id_prodotto_ordine;
	}

	@Override
	public float getPrezzo_compl() {
		return prezzo_compl;
	}

	@Override
	public void setPrezzo_compl(float prezzo_compl) {
		this.prezzo_compl = prezzo_compl;
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
