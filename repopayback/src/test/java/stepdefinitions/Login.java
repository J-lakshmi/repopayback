package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
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
import io.cucumber.java.en.When;
import pageobjects.ForgotPinPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.PayBackPage;

public class Login extends Base {
	 public WebDriver driver ;
	 LoginPage loginPage;
	 PayBackPage payBackPage;
	 ForgotPinPage forgotpinPage;
	  

	  @Before
	  public  void setUp () throws IOException {
	  
		    driver = initializeBrowser();
			driver.get(prop.getProperty("url"));
			
	  }
	  
	  @After
		public void tearDown() {
			driver.quit();
	  }
	
	
	
	@Given("^User can click on login option in the home page$")
    public void user_can_click_on_login_option_in_the_home_page()  {
		HomePage homePage = new HomePage(driver);
		  homePage.clickOnLoginOption();
		   loginPage = homePage.clickOnLoginOption();
        
    }

    @When("^User give valid credential to the phone number and pin field$")
    public void user_give_valid_credential_to_the_phone_number_and_pin_field() { 
    	  loginPage.enterPhoneNumber(prop.getProperty("validph/cardnum"));
		  loginPage.enterPin(prop.getProperty("validpin"));
        
    }
    
    @And("^User clicks on captcha and login button$")
    public void user_clicks_on_captcha_and_login_button()  {
    	 payBackPage=loginPage.submitButton();
        
    }


    @Then("^varify user successfully login$")
    public void varify_user_successfully_login() {
    	Assert.assertTrue(payBackPage.varifyPayBackTextBox());
      
    }
  

    @When("^User give invalid credential to the phone number and pin field$")
    public void user_give_invalid_credential_to_the_phone_number_and_pin_field() {
    	  loginPage.enterPhoneNumber(prop.getProperty("invalidph/cardnum"));
		  loginPage.enterPin(prop.getProperty("invalidpin"));
        
    }
    

    @Then("^varify userlogin is unsuccessfull$")
    public void varify_userlogin_is_unsuccessfull()  {
    	Assert.assertFalse(loginPage.varifyWarningMessage());
        
    }
    

    @And("^User click on ForgotPin button$")
    public void user_click_on_forgotpin_button()  {
	 loginPage.clickOnForgotPin();
	     forgotpinPage = loginPage.clickOnForgotPin();
    
  }


     @Then("^varify user get an OTP through mobilenumber$")
     public void varify_user_get_an_otp_through_mobilenumber()  {
	  Assert.assertFalse(driver.findElement(By.id("modal-header")).isDisplayed());
   
  }
     @Then("^varify user get a warning message$")
     public void varify_user_get_a_warning_message()  {
    	 Assert.assertTrue(loginPage.varifyingWarningMessage());
     }
    


    

   

  


   

}
