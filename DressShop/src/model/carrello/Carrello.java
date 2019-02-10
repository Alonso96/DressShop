package model.carrello;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//gestire modifica quantit�

import model.ordine.OrdinazioneBean;
import model.ordine.OrdinazioneModel;
import model.ordine.OrdinazioneModelDM;
import model.ordine.OrdineBean;
import model.ordine.OrdineModel;
import model.ordine.OrdineModelDM;
import model.prodotto.ProdottoBean;
import model.prodotto.ProdottoInOrdineBean;
import model.prodotto.ProdottoInOrdineModelDM;
import model.prodotto.ProdottoModel;

@SuppressWarnings("hiding")
public class Carrello<ProdottoInCarrello> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<ProdottoInCarrello> list;
	
	public Carrello() {
		list = new ArrayList<ProdottoInCarrello>(); //costruttore
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public void addProd(ProdottoInCarrello prodotto) {
		//controllo se esiste ed eventualmente incremento quantita
		boolean incrementato = false;
		for(ProdottoInCarrello p : list){
			if(p.equals(prodotto)){
				((model.prodotto.ProdottoInCarrello)p).setQuantita(((model.prodotto.ProdottoInCarrello)p).getQuantita() + 1);
				incrementato = true;
				break;
			}
		}
		//in caso contrario aggiungo
		if(!incrementato)
			list.add(prodotto);
	}
	
	public void rimElemento(int id_prodotto) {
		for(ProdottoInCarrello p : list) {
			if(((model.prodotto.ProdottoInCarrello)p).getId_prodotto() == id_prodotto) {
				((model.prodotto.ProdottoInCarrello)p).setQuantita(((model.prodotto.ProdottoInCarrello)p).getQuantita() - 1);
				if(((model.prodotto.ProdottoInCarrello)p).getQuantita() <= 0)
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
			totale += ((model.prodotto.ProdottoInCarrello)p).getPrezzo_compl();
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
			int id;
			ProdottoInOrdineBean prodBean = new ProdottoInOrdineBean();
			prodBean.setId_prodotto(((model.prodotto.ProdottoInCarrello)prod).getId_prodotto());
			prodBean.setPrezzo_compl(((model.prodotto.ProdottoInCarrello)prod).getPrezzo_compl());
			prodBean.setIva(((model.prodotto.ProdottoInCarrello)prod).getIva());
			prodBean.setQuantita(((model.prodotto.ProdottoInCarrello)prod).getQuantita());
			prodBean.setTaglia(((model.prodotto.ProdottoInCarrello)prod).getTaglia().toUpperCase());
			prodBean.setReso(false);
			id = prodottoModel.doSave(prodBean);
			OrdinazioneBean ordinazioneBean = new OrdinazioneBean(idOrdine, id);
			ordinazioneModel.doSave(ordinazioneBean);
		}

		list = new ArrayList<ProdottoInCarrello>();
	}	
}
