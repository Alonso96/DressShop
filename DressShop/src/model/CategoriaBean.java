package model;

import java.io.Serializable;

public class CategoriaBean implements Serializable{
	int id_categoria;
	String nome;
	String descrizione;
	
	public CategoriaBean(){
		
	}

	public int getId_categoria() {
		return id_categoria;
	}
	
	public void setId_categoria(int id_categoria){
		this.id_categoria = id_categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	@Override
	public boolean equals (Object obj){
		if(obj.getClass() != this.getClass())
			return false;
		CategoriaBean other = (CategoriaBean) obj;
		if(id_categoria != other.id_categoria)
			return false;
		return true;
	}
}
