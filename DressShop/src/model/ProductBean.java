package model;

import java.io.Serializable;

public class ProductBean implements Serializable {
	int id;
	String codice;
	String description;
	String marca;
	float ivaV;     //iva vendita;
	float prezzoV; //prezzo vendita
	int codC; //codice categoria
	int quantity;
	String urlPercorso;
	
	public ProductBean() {
		id=-1;
		codice="";
		description= "";
		marca = "";
		prezzoV = 0;
		ivaV=0;
		codC=0;
		quantity = 0;
		urlPercorso="";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getIvaV() {
		return ivaV;
	}

	public void setIvaV(float ivaV) {
		this.ivaV = ivaV;
	}

	public float getPrezzoV() {
		return prezzoV;
	}

	public void setPrezzoV(float prezzoV) {
		this.prezzoV = prezzoV;
	}

	public int getCodC() {
		return codC;
	}

	public void setCodC(int codC) {
		this.codC = codC;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getUrlPercorso() {
		return urlPercorso;
	}

	public void setUrlPercorso(String urlPercorso) {
		this.urlPercorso = urlPercorso;
	}

	@Override
	public String toString() {
		return "ProductBean [id=" + id + ", codice=" + codice + ", description=" + description + ", marca=" + marca
				+ ", ivaV=" + ivaV + ", prezzoV=" + prezzoV + ", codC=" + codC + ", quantity=" + quantity + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductBean other = (ProductBean) obj;
		if (codC != other.codC)
			return false;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(ivaV) != Float.floatToIntBits(other.ivaV))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (Float.floatToIntBits(prezzoV) != Float.floatToIntBits(other.prezzoV))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

}








