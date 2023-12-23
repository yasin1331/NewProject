package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.Loginpage;
import pageObjects.UrlPage;
import resources.Base;

public class LoginTestCase extends Base {
	public WebDriver driver;
	Logger log; 

	@Test(dataProvider = "multipulecredential")
	public void Login(String email, String password, String expectedresult) throws IOException, InterruptedException {
		UrlPage page = new UrlPage(driver);
		page.Myaccountdropdown().click();
		log.debug("clicked on my account");
		page.loginoption().click();
		log.debug("clicked on login button");


		Loginpage page1 = new Loginpage(driver);
		// page1.emailaddress().sendKeys(prop.getProperty("email")); by using properties
		// file
		page1.emailaddress().sendKeys(email); // by using data driven
		log.debug("email got enterd");
		// page1.password().sendKeys(prop.getProperty("password")); by using properties
		// file
		page1.password().sendKeys(password); // by using data driven
		log.debug("password got entered");
		page1.loginbutton().click();
		log.debug("clicked on login button");
		AccountPage apage = new AccountPage(driver);
		String Actualresult = null;
		try {
			if(apage.Modifyyourwishlistlink().isDisplayed()) {
				log.debug("user got login");
				Actualresult = "Successfull";
			}
			
		} catch (Exception e) {
			Actualresult = "failed";
			log.debug("use didn't login");
		}
		Assert.assertEquals(Actualresult, expectedresult);
		log.info("test got passed");
	}
	
	@BeforeMethod
	public void openapp() throws IOException {
		 log = LogManager.getLogger(LoginTestCase.class.getName());

		driver = intializeDriver();
		log.debug("Browser got Launched");
		driver.get(prop.getProperty("url"));
		log.debug("navigated to url");

		
	}

	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("browser got closed");
	}

	@DataProvider
	public Object[][] multipulecredential() {
		Object[][] data = {{"ytrewq@gmail.com","7013711744","Successfull"}};
				
		return data;
	}
}
