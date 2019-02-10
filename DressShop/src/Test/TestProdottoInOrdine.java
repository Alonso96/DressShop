package Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.prodotto.ProdottoBean;
import model.prodotto.ProdottoInOrdineBean;

public class TestProdottoInOrdine extends TestCase{
ProdottoInOrdineBean prodotto;
	@Before
	public void setUp() throws Exception {
		prodotto=new ProdottoInOrdineBean();
	}

	@After
	public void tearDown() throws Exception {
		prodotto=null;
	}

	@Test
	public void testIdProdotto() {
		int id_prodotto_ordine=5;
		prodotto.setId_prodotto_ordine(id_prodotto_ordine);
		 
		assertEquals(5, prodotto.getId_prodotto_ordine());
	}
	@Test
	public void testSetPrezzo() {
		float prezzo=1;
		prodotto.setPrezzo_compl(prezzo);
		 
		assertEquals((int)prezzo,(int)prodotto.getPrezzo_compl());
	}
	@Test
	public void testSetIva() {
		int iva=1;
		prodotto.setIva(iva);
		 
		assertEquals(1,prodotto.getIva());
	}
	@Test
	public void testSetQuantita() {
		int quantita=1;
		prodotto.setQuantita(quantita);
		 
		assertEquals(1,prodotto.getQuantita());
	}
	@Test
	public void testSetReso() {
		boolean reso=false;
		prodotto.setReso(reso);
		 
		assertFalse(prodotto.isReso());
	}
}
