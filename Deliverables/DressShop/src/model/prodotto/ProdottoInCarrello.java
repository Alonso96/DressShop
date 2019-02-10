package model.prodotto;

public class ProdottoInCarrello extends ProdottoBean{

	private static final long serialVersionUID = 1L;
	
	private int quantita;
	private String taglia;
	
	public ProdottoInCarrello(ProdottoBean prod){
		this.setId_prodotto(prod.getId_prodotto());
		this.setCodice_prodotto(prod.getCodice_prodotto());
		this.setDescrizione(prod.getDescrizione());
		this.setMarca(prod.getMarca());
		this.setModello(prod.getModello());
		this.setFoto(prod.getFoto());
		this.setCategoria(prod.getCategoria());
		this.setPromozione(prod.getPromozione());
		this.setPrezzo_compl(prod.getPrezzo_compl());
		this.setIva(prod.getIva());
		this.setIn_vendita(prod.isIn_vendita());
	}
	
	public ProdottoInCarrello(){

	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getTaglia() {
		return taglia;
	}

	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}
	
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		ProdottoInCarrello other = (ProdottoInCarrello) obj;
		if(other.getId_prodotto() != this.getId_prodotto())
			return false;
		if(!other.getTaglia().equalsIgnoreCase(this.getTaglia()))
			return false;
		
		return true;
	}
}
