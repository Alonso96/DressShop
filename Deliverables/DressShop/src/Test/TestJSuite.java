package Test;
import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


import junit.framework.TestSuite;
	@RunWith(Suite.class)
@SuiteClasses({
	TestProdottoBean.class,
	TestUtenteBean.class,
	TestOrdineBean.class,
	TestProdottoInOrdine.class,
	TestIndirizzoBean.class,
	TestPromozioneBean.class,
	TestTagliaBean.class
})
public class TestJSuite {

	/*@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}*/

/*@Test
	
public static Test suite() {
		TestSuite suite= new TestSuite(); 
		//suite.addTest(new TestProdottoBean());
		suite.addTest(new TestUtenteBean());
		suite.addTest(new TestProdottoBean());
	
		return (Test) suite;
	*/

}
