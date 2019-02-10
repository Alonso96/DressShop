package model.ordine;

public class OrdinazioneBean {

	//chiave primaria (ordine, prodotto)
	private int ordine;
	private int prodotto;	//ProdottoInOrdine
	
	public OrdinazioneBean(){
		
	}
	
	public OrdinazioneBean(int ordine, int prodotto){
		this.ordine = ordine;
		this.prodotto = prodotto;
	}
	
	public int getOrdine() {
		return ordine;
	}
	public void setOrdine(int ordine) {
		this.ordine = ordine;
	}
	public int getProdotto() {
		return prodotto;
	}
	public void setProdotto(int prodotto) {
		this.prodotto = prodotto;
	}
}
