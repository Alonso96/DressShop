package Test;
import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.PromozioneBean;

public class TestPromozioneBean {
PromozioneBean promozione;
	@Before
	public void setUp() throws Exception {
		promozione=new PromozioneBean();
	}

	@After
	public void tearDown() throws Exception {
		promozione=null;
	}
	@Test
	public void testSetIdPromozione() {
		int id_promozione=1;
		promozione.setId_promozione(id_promozione);
		assertEquals(1, promozione.getId_promozione());
			
	}
	@Test
	public void testSetDataInizio() {
		
			java.sql.Date data=new java.sql.Date(1990, 12, 20);
		promozione.setData_inizio(data);
		assertTrue(data.equals(promozione.getData_inizio()));
		
	}
	@Test
	public void testSetDataFine() {
		
			java.sql.Date data=new java.sql.Date(1990, 12, 20);
		promozione.setData_fine(data);
		assertTrue(data.equals(promozione.getData_fine()));
		
	}
	@Test
	public void testSetSconto() {
		int sconto=1;
		promozione.setSconto(sconto);
		assertEquals(1, promozione.getSconto());
			
	}
}
