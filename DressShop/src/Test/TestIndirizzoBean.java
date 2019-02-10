package Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.indirizzo.IndirizzoBean;

public class TestIndirizzoBean extends TestCase {
	IndirizzoBean indirizzo;
	@Before
	public void setUp() throws Exception {
		indirizzo=new IndirizzoBean();
	}

	@After
	public void tearDown() throws Exception {
		indirizzo=null;
	}

	@Test
	public void testSetId_indirizzo() {
		int id_indirizzo=1;
		indirizzo.setId_indirizzo(id_indirizzo);
		assertEquals(1, indirizzo.getId_indirizzo());
	}
	@Test
	public void testSetId_indirizzoInvalido() {
		double id_indirizzoInv=1.5;
		indirizzo.setId_indirizzo((int)id_indirizzoInv);
		assertFalse(1.5== indirizzo.getId_indirizzo());
	}
	
	@Test
	public void testSetNome(){
		String nome="nome";
		indirizzo.setNome(nome);
		assertEquals("nome", indirizzo.getNome());
	}
	@Test
	public void testSetNomeInvalido(){
		String nome="�";
		indirizzo.setNome(nome);
		assertEquals("�", indirizzo.getNome());
	}
	@Test
	public void testSetCognome(){
		String cognome="cognome";
		indirizzo.setCognome(cognome);
		assertEquals("cognome", indirizzo.getCognome());
	}
	@Test
	public void testSetCap(){
		String cap="345";
		indirizzo.setCap(cap);;
		assertEquals("345", indirizzo.getCap());
	}
	@Test
	public void testSetProvincia(){
		String provincia="provincia";
		indirizzo.setProvincia(provincia);
		assertEquals("provincia", indirizzo.getProvincia());
	}
	@Test
	public void testSetCitta(){
		String citta="citta";
		indirizzo.setCitta(citta);
		assertEquals("citta", indirizzo.getCitta());
	}
	@Test
	public void testSetVia(){
		String via="via";
		indirizzo.setVia(via);
		assertEquals("via", indirizzo.getVia());
	}
	@Test
	public void testSetCellulare(){
		String cellulare="33324";
		indirizzo.setCellulare(cellulare);
		assertEquals("33324", indirizzo.getCellulare());
	}
	@Test
	public void testSetUtente(){
		int utente=1;
		indirizzo.setUtente(utente);
		assertEquals(1, indirizzo.getUtente());
	}
}
