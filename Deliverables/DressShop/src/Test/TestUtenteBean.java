package Test;

import org.junit.Test;

import junit.framework.TestCase;
import model.ordine.OrdineBean;
import model.utente.UtenteBean;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
public class TestUtenteBean extends TestCase {
	UtenteBean utente;
	@Before
	public void setUp() throws Exception {
		utente=new UtenteBean();
	}

	@After
	public void tearDown() throws Exception {
		utente=null;
	}

	@Test
   public void testSetNome() {
	   //arrange
	   String nome="Nome utente";
 
	   //act
	   utente.setNome(nome);
	   //assert
	   assertEquals("Nome utente", utente.getNome());
   }
	@Test
	 public void testSetCognome() {
		   //arrange
		   String cognome="Cognome utente";
	  
		   //act
		   utente.setCognome(cognome);
		   //assert
		   assertEquals("Cognome utente", utente.getCognome());
	   }
	@Test
	public void testSetEmail() {
		   //arrange
		   String email="email@utente.it";
	  
		   //act
		   utente.setEmail(email);;
		   //assert
		   assertEquals("email@utente.it", utente.getEmail());
	   }
	@Test
	public void testSetPassword() {
		   //arrange
		   String password="password";
	 
		   //act
		   utente.setPassword(password);;
		   //assert
		   assertEquals("password", utente.getPassword());
	   }

	@Test
	public void testSetTipo() {
		   //arrange
		   int tipo=3;
	  
		   //act
		   utente.setTipo(tipo);;
		   //assert
		   assertEquals(3, utente.getTipo());
	   }

	@Test
	public void testSetIdutente() {
		   //arrange
		   int id_utente=3;
	  
		   //act
		   utente.setId_utente(id_utente);
		   //assert
		   assertEquals(3, utente.getId_utente());
	   }

	@Test
	public void testSetDataNascita() throws ParseException {
		   //arrange
		   Date data_nascita=new SimpleDateFormat("dd/MM/yyyy").parse("02/12/1998");
		   //act
		   utente.setData_nascita(data_nascita);
		   //assert
		   assertTrue(data_nascita.equals(utente.getData_nascita()));
	   }
	
}