package model;

import java.io.Serializable;

public class ProdottoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id_prodotto;
	private String codice_prodotto;
	private String descrizione;
	private String marca;
	private String modello;
	private String taglia;
	private String colore;
	private String foto; //url
	private String categoria;
	private int promozione;
	
	public ProdottoBean() {
		
	}

	public int getId_prodotto() {
		return id_prodotto;
	}


	public void setId_prodotto(int id_prodotto) {
		this.id_prodotto = id_prodotto;
	}


	public String getCodice_prodotto() {
		return codice_prodotto;
	}


	public void setCodice_prodotto(String codice_prodotto) {
		this.codice_prodotto = codice_prodotto;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModello() {
		return modello;
	}


	public void setModello(String modello) {
		this.modello = modello;
	}


	public String getTaglia() {
		return taglia;
	}


	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}


	public String getColore() {
		return colore;
	}


	public void setColore(String colore) {
		this.colore = colore;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public int getPromozione() {
		return promozione;
	}


	public void setPromozione(int promozione) {
		this.promozione = promozione;
	}

	@Override
	public String toString() {
		return "ProdottoBean [id_prodotto=" + id_prodotto + ", codice_prodotto=" + codice_prodotto + ", descrizione=" 
				+ descrizione + ", marca=" + marca + ", modello=" + modello + ", taglia=" + taglia + ", colore="
				+ colore + ", categoria" + categoria + ", promozione" + promozione + "]";
	}

	@Override
	public boolean equals (Object obj){
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		ProdottoBean other = (ProdottoBean) obj;
		if (id_prodotto != other.id_prodotto)
			return false;
		return true;
	}

}