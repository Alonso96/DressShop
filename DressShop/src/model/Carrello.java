package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Carrello<ProdottoInCarrello> implements Serializable{
	
	List<ProdottoInCarrello> list;
	
	public Carrello() {
		list = new ArrayList<ProdottoInCarrello>(); //costruttore
	}
	
	public void addProd(ProdottoInCarrello prodotto) {
		list.add(prodotto);
	}
	
	public void rimElemento(ProdottoInCarrello prodotto) {
		for(ProdottoInCarrello p : list) {
			if(p.equals(prodotto)) {
				list.remove(p);
				break;
			}	
		}
	}
	
	public List<ProdottoInCarrello> ottieniElem() {
		return list;
	}
	
	public void acquista() {
		list = new ArrayList<ProdottoInCarrello>();
	}

	
	
	
}
