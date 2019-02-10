package Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;

import com.mysql.cj.jdbc.Driver;

import java.util.regex.Pattern;
import org.junit.Test;
public class integrationTest {


	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\lucag\\Desktop\\JUNIT_HOME\\chromedriver.exe");
         WebDriver driver = new ChromeDriver();
         
     	
		String baseUrl="http://localhost:8080/DressShop/login.jsp ";
		//		String expectedTitle="LOGIN";
		//		String actualTitle = "";
				
				driver.get(baseUrl);
				WebElement email=driver.findElement(By.name("email"));
		         WebElement pass=driver.findElement(By.name("password"));
		         WebElement submitButton=driver.findElement(By.name("invio"));
		         email.sendKeys("uno@due");
		         pass.sendKeys("root");
		         submitButton.click();
		         String actualTitle = driver.getTitle();
			
				/*if (actualTitle.contentEquals("LOGIN")){
		            System.out.println("Test Passed!");
		        } else {
		            System.out.println("Test Failed");
		        }*/
				// driver.close ();
		         baseUrl="http://localhost:8080/DressShop/registrazione.jsp ";
			//	WebElement link=driver.findElement(By.cssSelector("a[href=registrazione.jsp]"));
		         driver.get(baseUrl);
		         
		         WebElement nome=driver.findElement(By.name("nome"));
		         
		         WebElement cognome=driver.findElement(By.name("cognome"));
		         
		         WebElement data=driver.findElement(By.name("data_nascita"));
		         
		          email=driver.findElement(By.name("email"));
		         
		         WebElement password=driver.findElement(By.name("password"));
		          
		         WebElement registrati=driver.findElement(By.name("regButtom"));
		         nome.sendKeys("!4&");
		         cognome.sendKeys("950");
		         data.sendKeys("12/14/918");
		         email.sendKeys("uno");

		         password.sendKeys("pass");

		         registrati.click();
		         
		         nome.clear();
		         cognome.clear();
		         data.clear();
		         email.clear();
		         password.clear();
		         
		         registrati.click();
		         
		         nome.sendKeys("nome");
		         cognome.sendKeys("cognome");
		         data.sendKeys("12/11/18");
		         email.sendKeys("cinque@otto.it");
		         
		         registrati.click();
		         
		         password.sendKeys("password");
		         
		         registrati.click();

		         //driver.close();
		     	/* email=driver.findElement(By.name("email"));
		          pass=driver.findElement(By.name("password"));
		         email.sendKeys("uno@due.it");
		         pass.sendKeys("root");
		         submitButton=driver.findElement(By.name("invio"));
		         submitButton.click();*/
		         WebElement areaUtente=driver.findElement(By.name("areaUtente"));
		         areaUtente.click();
		         submitButton=driver.findElement(By.name("addcarta"));
		         submitButton.click();
		         submitButton=driver.findElement(By.name("addcarta2"));
		         submitButton.click();
		         
		         nome=driver.findElement(By.name("nome"));
		         
		         cognome=driver.findElement(By.name("cognome"));
		         
		         WebElement numeroCarta=driver.findElement(By.name("numero_carta"));
		         
		         WebElement cvv=driver.findElement(By.name("cvv"));
		         
		         WebElement anno=driver.findElement(By.name("anno"));
		         WebElement mese=driver.findElement(By.name("mese"));
		         WebElement giorno=driver.findElement(By.name("giorno"));
		         nome.sendKeys("!4&");
		         cognome.sendKeys("950");
		         numeroCarta.sendKeys("12/14/999");
		         anno.sendKeys("2017");
		         mese.sendKeys("145");
		         giorno.sendKeys("1,5");
		         submitButton=driver.findElement(By.name("invia"));
		         submitButton.click();
		         
		         nome.clear();
		         cognome.clear();
		         numeroCarta.clear();
		         anno.clear();
		         mese.clear();
		         giorno.clear();
		         
		         nome.sendKeys("cliente");
		         cognome.sendKeys("negozio");
		         cvv.sendKeys("123");
		         anno.sendKeys("2020");
		         mese.sendKeys("12");
		         giorno.sendKeys("11");
		         submitButton=driver.findElement(By.name("invia"));
		         submitButton.click();
		         
		         numeroCarta.sendKeys("1221459991234567");
		         
		         baseUrl="http://localhost:12590/DressShop/CategoriaControl?categoria=giacca.uomo";
		         driver.get(baseUrl);

		         baseUrl="http://localhost:12590/DressShop/ProductControl?action=detail&id=70";
		         driver.get(baseUrl);

		         submitButton=driver.findElement(By.name("invia"));
		         submitButton.click();
		         
		         baseUrl="http://localhost:12590/DressShop/CartControl?invia=rimuovi&id=70";
		         driver.get(baseUrl);
		         baseUrl="http://localhost:12590/DressShop/LogoutControl";
		         driver.get(baseUrl);
		         baseUrl="http://localhost:8080/DressShop/login.jsp ";
		         driver.get(baseUrl);
		         
		         email=driver.findElement(By.name("email"));
		          pass=driver.findElement(By.name("password"));
		         email.sendKeys("tre@due.it");
		         pass.sendKeys("root");
		         submitButton=driver.findElement(By.name("invio"));
		         submitButton.click();
		         submitButton=driver.findElement(By.name("ins"));
		         submitButton.click();
		         WebElement codice=driver.findElement(By.name("codice"));
		         WebElement marca=driver.findElement(By.name("marca"));
		         WebElement modello=driver.findElement(By.name("modello"));
		         WebElement descrizione=driver.findElement(By.name("descrizione"));
		         WebElement quantita=driver.findElement(By.name("quantita"));
		         
		         codice.sendKeys("cod1243");
		         marca.sendKeys("luis");
		         modello.sendKeys("motx");
		         descrizione.sendKeys("Descrizione prodotto");
		         quantita.sendKeys("9");
		         submitButton=driver.findElement(By.name("insProd"));
		         submitButton.click();
	}
	 

}
