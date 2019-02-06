package model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//gestire modifica quantit�

@SuppressWarnings("hiding")
public class Carrello<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<T> list;
	
	public Carrello() {
		list = new ArrayList<T>(); //costruttore
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public void addProd(T prodotto) {
		list.add(prodotto);
	}
	
	public void rimElemento(T prodotto) {
		for(T p : list) {
			if(p.equals(prodotto)) {
				list.remove(p);
				break;
			}	
		}
	}
	
	public List<T> ottieniElem() {
		return list;
	}
	
	public float getTotale(){
		float totale = 0;
		for(T p : list){
			totale += ((model.ProdottoInCarrello)p).getPrezzo_compl();
		}
		return totale;
	}
	
	public void acquista(String carta_credito, int utente, int indirizzo) throws SQLException {
		ProdottoModel<ProdottoBean> prodottoModel = new ProdottoInOrdineModelDM();
		OrdineModel<OrdineBean> ordineModel = new OrdineModelDM();
		OrdinazioneModel ordinazioneModel= new OrdinazioneModelDM();
		OrdineBean ordBean = new OrdineBean();
		ordBean.setCarta_credito(carta_credito);
		ordBean.setUtente(utente);
		ordBean.setIndirizzo(indirizzo);
		ordBean.setPagato(true);
		ordBean.setTotale(this.getTotale());
		ordBean.setData(new java.sql.Date(new java.util.Date().getTime()));	//getTime di java.util.Date restituisce long al costruttore di java.sql.Date
		int idOrdine = ordineModel.doSave(ordBean);
		
		for(T prod : list){
			ProdottoInOrdineBean prodBean = new ProdottoInOrdineBean();
			prodBean.setId_prodotto(((model.ProdottoInCarrello)prod).getId_prodotto());
			prodBean.setPrezzo_compl(((model.ProdottoInCarrello)prod).getPrezzo_compl());
			prodBean.setIva(((model.ProdottoInCarrello)prod).getIva());
			prodBean.setQuantita(((model.ProdottoInCarrello)prod).getQuantita());
			prodBean.setTaglia(((model.ProdottoInCarrello)prod).getTaglia());
			prodBean.setReso(false);
			prodottoModel.doSave(prodBean);
			OrdinazioneBean ordinazioneBean = new OrdinazioneBean(idOrdine, ((model.ProdottoInCarrello)prod).getId_prodotto());
			ordinazioneModel.doSave(ordinazioneBean);
		}

		list = new ArrayList<T>();
	}	
}
