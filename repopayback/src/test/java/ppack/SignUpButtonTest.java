package ppack;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageobjects.HomePage;

public class SignUpButtonTest extends Base {
     public WebDriver driver;
	
	
	
	@BeforeMethod
	public void setup() throws IOException  {
		   driver = initializeBrowser();
		   driver.get(prop.getProperty("url"));
		}
	
	 @AfterMethod
		public void tearDown() {
			driver.quit();
	    }
	  
	
	@Test(priority=1)
	public void openPaybackApplication() throws Throwable {
		    HomePage homePage = new HomePage(driver);
		    Assert.assertTrue(homePage.varifySignUpOption());

    }
}
