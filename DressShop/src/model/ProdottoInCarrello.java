package model;

public class ProdottoInCarrello extends ProdottoInCatalogoBean{

	private static final long serialVersionUID = 1L;
	
	private int quantitaCar;
	
	public ProdottoInCarrello(ProdottoInCatalogoBean prod){
		this.setId_prodotto(prod.getId_prodotto());
		this.setCodice_prodotto(prod.getCodice_prodotto());
		this.setDescrizione(prod.getDescrizione());
		this.setMarca(prod.getMarca());
		this.setModello(prod.getModello());
		this.setTaglia(prod.getTaglia());
		this.setColore(prod.getColore());
		this.setFoto(prod.getFoto());
		this.setCategoria(prod.getCategoria());
		this.setPromozione(prod.getPromozione());
		this.setPrezzo(prod.getPrezzo());
		this.setIva(prod.getIva());
		quantitaCar = 1;
	}
	
	public ProdottoInCarrello(){
		
	}

	public int getQuantitaCar() {
		return quantitaCar;
	}

	public void setQuantitaCar(int quantitaCar) {
		this.quantitaCar = quantitaCar;
	}
	
}
