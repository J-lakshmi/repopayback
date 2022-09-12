package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.HomePage;

public class SignUpButton extends Base {
	public WebDriver driver;
	 HomePage homePage;
	
	@Before
	public void setup() throws IOException  {
		   driver = initializeBrowser();
		   driver.get(prop.getProperty("url"));
		}
	
	 @After
		public void tearDown() {
			driver.quit();
	    }
	  

	  @Given("^New user open homePage of PayBack Application$")
	    public void new_user_open_homepage_of_payback_application()  {
		 homePage = new HomePage(driver);
	       
	    }

	    @Then("^Varify user is able to find the SignUp option$")
	    public void varify_user_is_able_to_find_the_signup_option()  {
	    	Assert.assertTrue(homePage.varifySignUpOption());
	       
	    }


}
