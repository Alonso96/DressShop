package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("hiding")
public class Carrello<ProdottoInCarrello> implements Serializable{
	
	List<ProdottoInCarrello> list;
	
	public Carrello() {
		list = new ArrayList<ProdottoInCarrello>(); //costruttore
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
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
		ProdottoModel<ProdottoBean> model = new ProdottoInOrdineModelDM();

		for(ProdottoInCarrello prod : list){
			ProdottoBean bean = new ProdottoInOrdineBean();
			bean.setId_prodotto(((model.ProdottoInCarrello)prod).getId_prodotto());
			
			
		}
		
		
		
		list = new ArrayList<ProdottoInCarrello>();
	}

	
	
	
}
