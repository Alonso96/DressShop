package Test;
import static org.junit.Assert.*;

import org.junit.Test;



import junit.framework.TestCase;
import model.prodotto.ProdottoBean;

public class TestProdottoBean extends TestCase {
ProdottoBean prodotto;
	@Test
	public void testIdProdotto() {
		prodotto=new ProdottoBean();
		int id_prodotto=5;
		prodotto.setId_prodotto(id_prodotto);
		 
		assertEquals(5, prodotto.getId_prodotto());
	}
	@Test
	public void testSetCodiceProdotto() {
		prodotto=new ProdottoBean();
		String codice_prodotto="cod";
		prodotto.setCodice_prodotto(codice_prodotto);
		 
		assertEquals("cod", prodotto.getCodice_prodotto());
	}
	@Test
	public void testSetDescrizione() {
		prodotto=new ProdottoBean();
		String descrizione="descrizione";
		prodotto.setDescrizione(descrizione);
		 
		assertEquals("descrizione", prodotto.getDescrizione());
	}
	@Test
	public void testSetMarca() {
		prodotto=new ProdottoBean();
		String marca="marca";
		prodotto.setMarca(marca);
		 
		assertEquals("marca", prodotto.getMarca());
	}
	@Test
	public void testSetModello() {
		prodotto=new ProdottoBean();
		String modello="modello";
		prodotto.setModello(modello);;
		 
		assertEquals("modello", prodotto.getModello());
	}
	@Test
	public void testSetPrezzo() {
		prodotto=new ProdottoBean();
		float prezzo=1;
		prodotto.setPrezzo_compl(prezzo);
		 
		assertEquals((int)prezzo,(int)prodotto.getPrezzo_compl());
	}
	@Test
	public void testSetInvendita() {
		prodotto=new ProdottoBean();
		boolean in_vendita=false;
		prodotto.setIn_vendita(false);
		 
		assertFalse(prodotto.isIn_vendita());
	}
	@Test
	public void testSetIva() {
		prodotto=new ProdottoBean();
		int iva=1;
		prodotto.setIva(iva);
		 
		assertEquals(1,prodotto.getIva());
	}
	@Test
	public void testSetFoto() {
		prodotto=new ProdottoBean();
		String foto="url";
		prodotto.setFoto(foto);
		 
		assertEquals("url",prodotto.getFoto());
	}
	@Test
	public void testSetCategoria() {
		prodotto=new ProdottoBean();
		String categoria="accessori";
		prodotto.setCategoria(categoria);
		 
		assertEquals("accessori",prodotto.getCategoria());
	}
	@Test
	public void testSetPromozione() {
		prodotto=new ProdottoBean();
		int promozione=2;
		prodotto.setPromozione(promozione);
		 
		assertEquals(2,prodotto.getPromozione());
	}
}
