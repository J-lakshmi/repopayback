package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
import pageobjects.SignUpPage;

public class SignUp extends Base {
	public WebDriver driver;
	SignUpPage signUpPage;
	

	@Before
	public void setup() throws IOException  {
		   driver = initializeBrowser();
		   driver.get(prop.getProperty("url1"));
		}
	
	 @After
		public void tearDown() {
			driver.quit();
	    }
	 
	
	
	
	 @Given("^NewUser navigate to SignUp Page$")
	    public void newuser_navigate_to_signup_page() throws Throwable {
		 signUpPage= new SignUpPage(driver);
	        
	    }

	    @When("^NewUser  select salutation and enter valid credential to the FirstName, LastName, MobileNumber,EmailID,DOB fields$")
	    public void newuser_select_salutation_and_enter_valid_credential_to_the_firstname_lastname_mobilenumberemailid_fields() throws Throwable {
	    	WebElement dropdownField = driver.findElement(By.xpath("//select[@name='salutation']"));
			 Select select = new Select (dropdownField);
			 select.selectByVisibleText("Mr");
			 Thread.sleep(2000);
	
			 signUpPage.enterFirstName(prop.getProperty("firstname"));
			 signUpPage.enterLastName(prop.getProperty("lastname"));
			 signUpPage.enterPhoneNumber(prop.getProperty("phonenumber"));
			 Thread.sleep(3000);
			 signUpPage.enterEmail(prop.getProperty("validemail"));
			 signUpPage.enterdob();
			  WebElement dropdownDateField =driver.findElement(By.className("react-datepicker__year-select"));
			  Select select1= new Select(dropdownDateField);
			  select1.selectByVisibleText("2000");
			  
			  WebElement dropdownMonthField =driver.findElement(By.className("react-datepicker__month-select"));
			  Select select2= new Select(dropdownMonthField);
			  select2.selectByVisibleText("March");
			  signUpPage.clickOnCalender();
	       
	    }
	    
	    @And("^clicks on privacy policy and generate OTP$")
	    public void clicks_on_privacy_policy_and_generate_otp()  throws Throwable {
	    	signUpPage.clickOnPrivacyPolicy();
			  signUpPage.clickOnGenerateOTP();
			  Thread.sleep(2000);
	        
	    }

	    @Then("^varify user get an OTP and successfully SignUP$")
	    public void varify_user_get_an_otp_and_successfully_signup()  {
	    	 Assert.assertTrue(driver.findElement(By.xpath("//button[normalize-space()='Submit']")).isDisplayed());
	    	
	    }
	    
	    @Given("^NewUser is able to navigate to SignUp Page$")
	    public void newuser_is_able_to_navigate_to_signup_page()  {
	    	 signUpPage= new SignUpPage(driver);
	       
	    }

	    @When("^NewUser  select salutation and enter invalidvalid credential to the FirstName, LastName, MobileNumber,EmailID,DOB fields$")
	    public void newuser_select_salutation_and_enter_invalidvalid_credential_to_the_firstname_lastname_mobilenumberemailiddob_fields() throws Throwable  {
	    	 WebElement dropdownField = driver.findElement(By.xpath("//select[@name='salutation']"));
			 Select select = new Select (dropdownField);
			 select.selectByVisibleText("Mr");
			 Thread.sleep(2000);
			 signUpPage.enterFirstName(prop.getProperty("firstname"));
			 Thread.sleep(2000);
			 signUpPage.enterLastName(prop.getProperty("lastname"));
			 Thread.sleep(2000);
			 signUpPage.enterPhoneNumber(prop.getProperty("phnumber"));
			 Thread.sleep(2000);
			 signUpPage.enterEmail(prop.getProperty("invalidemail"));
			 signUpPage.enterdob();
	    	
	 		  WebElement dropdownDateField =driver.findElement(By.className("react-datepicker__year-select"));
	 		  Select select1= new Select(dropdownDateField);
	 		  select1.selectByVisibleText("2000");
	 		  
	 		  WebElement dropdownMonthField =driver.findElement(By.className("react-datepicker__month-select"));
	 		  Select select2= new Select(dropdownMonthField);
	 		  select2.selectByVisibleText("March");
	 		  signUpPage.clickOnCalender();
	    }
	    
	    @And("^NewUser clicks on privacy policy and generate OTP$")
	    public void newuser_clicks_on_privacy_policy_and_generate_otp()  {
	    	signUpPage.clickOnPrivacyPolicy();
			 signUpPage.clickOnGenerateOTP();
	        
	    }


	    @Then("^varify user is not able to successfully SignUP and get a warning message$")
	    public void varify_user_is_not_able_to_successfully_signup_and_get_a_warning_message()  {
	    	 
			  Assert.assertFalse(signUpPage.varifyWarningMessage());
	       
	    }

	   


	  


}
