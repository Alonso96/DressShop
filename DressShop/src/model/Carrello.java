package model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//gestire modifica quantità

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
	
	public float getTotale(){
		float totale = 0;
		for(ProdottoInCarrello p : list){
			totale += ((model.ProdottoInCarrello)p).getPrezzo();
			totale += ((model.ProdottoInCarrello)p).getIva();
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
		
		for(ProdottoInCarrello prod : list){
			ProdottoInOrdineBean prodBean = new ProdottoInOrdineBean();
			prodBean.setId_prodotto(((model.ProdottoInCarrello)prod).getId_prodotto());
			prodBean.setPrezzo(((model.ProdottoInCarrello)prod).getPrezzo());
			prodBean.setIva(((model.ProdottoInCarrello)prod).getIva());
			prodBean.setQuantita(((model.ProdottoInCarrello)prod).getQuantitaCar());
			prodBean.setReso(false);
			prodottoModel.doSave(prodBean);
			OrdinazioneBean ordinazioneBean = new OrdinazioneBean(idOrdine, ((model.ProdottoInCarrello)prod).getId_prodotto());
			ordinazioneModel.doSave(ordinazioneBean);
		}

		list = new ArrayList<ProdottoInCarrello>();
	}	
}
