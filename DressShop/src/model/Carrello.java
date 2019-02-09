package model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//gestire modifica quantita

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
				((model.ProdottoInCarrello)p).setQuantita(((model.ProdottoInCarrello)p).getQuantita() + 1);
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
			if(((model.ProdottoInCarrello)p).getId_prodotto() == id_prodotto) {
				((model.ProdottoInCarrello)p).setQuantita(((model.ProdottoInCarrello)p).getQuantita() - 1);
				if(((model.ProdottoInCarrello)p).getQuantita() <= 0)
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
			totale += ((model.ProdottoInCarrello)p).getPrezzo_compl();
		}
		return totale;
	}
	
	public void acquista(String carta_credito, int utente, int indirizzo) throws SQLException {
		ProdottoModel<ProdottoBean> prodottoOrdineModel = new ProdottoInOrdineModelDM();
		ProdottoModel<ProdottoBean> prodottoModel = new ProdottoModelDM();
		OrdineModel<OrdineBean> ordineModel = new OrdineModelDM();
		OrdinazioneModel ordinazioneModel= new OrdinazioneModelDM();
		TagliaModelDM tModel = new TagliaModelDM();

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
			prodBean.setId_prodotto(((model.ProdottoInCarrello)prod).getId_prodotto());
			prodBean.setPrezzo_compl(((model.ProdottoInCarrello)prod).getPrezzo_compl());
			prodBean.setIva(((model.ProdottoInCarrello)prod).getIva());
			prodBean.setQuantita(((model.ProdottoInCarrello)prod).getQuantita());
			prodBean.setTaglia(((model.ProdottoInCarrello)prod).getTaglia());
			prodBean.setReso(false);
			id = prodottoOrdineModel.doSave(prodBean);
			OrdinazioneBean ordinazioneBean = new OrdinazioneBean(idOrdine, id);
			ordinazioneModel.doSave(ordinazioneBean);
			
			TagliaBean tBean = new TagliaBean();
			tBean = tModel.doRetrieveByProdottoTaglia(((model.ProdottoInCarrello)prod).getId_prodotto(), ((model.ProdottoInCarrello)prod).getTaglia());
			tBean.setQuantita(tBean.getQuantita() - ((model.ProdottoInCarrello)prod).getQuantita());
			tModel.doUpdate(tBean);
		}

		list = new ArrayList<ProdottoInCarrello>();
	}	
}
