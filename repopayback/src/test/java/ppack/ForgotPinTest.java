package ppack;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageobjects.ForgotPinPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class ForgotPinTest extends Base {
	public WebDriver driver ;
	
	 @BeforeMethod
	  public  void setUp () throws IOException{
	  
		    driver = initializeBrowser();
			driver.get(prop.getProperty("url"));
			
	  }
	  
	  @AfterMethod
		public void tearDown() {
			driver.quit();

 }  
	  
	  @Test
	  public void usingValidPhoneNumber() throws Throwable {
		  HomePage homePage = new HomePage(driver);
		  homePage.clickOnLoginOption();
		  LoginPage loginPage = homePage.clickOnLoginOption();
		  loginPage.enterPhoneNumber(prop.getProperty("phone_number"));
		  Thread.sleep(2000);
		  loginPage.clickOnForgotPin();
		  ForgotPinPage forgotpinPage = loginPage.clickOnForgotPin();
		  Thread.sleep(2000);
		  
		  
		  Assert.assertFalse(driver.findElement(By.id("modal-header")).isDisplayed());
	  }
	  
	  @Test
	     public void withoutProvidingPhoneNumber() throws Throwable {
	    	 HomePage homePage = new HomePage(driver);
			  homePage.clickOnLoginOption();
			  LoginPage loginPage = homePage.clickOnLoginOption();
	   	     Thread.sleep(2000);
	   	     loginPage.clickOnForgotPin();
		     ForgotPinPage forgotpinPage = loginPage.clickOnForgotPin();
		     Thread.sleep(2000);
	    	 
	        Assert.assertTrue(loginPage.varifyingWarningMessage());
	 
	  }
}
