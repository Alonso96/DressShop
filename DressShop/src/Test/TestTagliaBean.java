package Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.TagliaBean;

public class TestTagliaBean {
TagliaBean taglia;
	@Before
	public void setUp() throws Exception {
		taglia = new TagliaBean();
	}

	@After
	public void tearDown() throws Exception {
		taglia=null;
	}

	@Test
	public void testSetIdProdotto (){
		int id_prodotto=1;
		taglia.setId_prodotto(id_prodotto);
		assertEquals(1, taglia.getId_prodotto());
	}
	@Test
	public void testSetTaglia (){
		String ta="l";
		taglia.setTaglia(ta);
		assertEquals("l", taglia.getTaglia());
	}
	@Test
	public void testSetQuantita (){
		int quantita=1;
		taglia.setQuantita(quantita);
		assertEquals(1, taglia.getQuantita());
	}
}
