package ppack;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.PayBackPage;
import util.DataUtil;
import util.MyXLSReader;

public class LoginTest extends Base {
	 public WebDriver driver ;
	 MyXLSReader excelReader;
  

  @BeforeMethod
  public  void setUp () throws IOException {
  
	    driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
		
  }
  
  @AfterMethod
	public void tearDown() {
		driver.quit();
  }
 
 
      @Test(dataProvider="dataSupplier")
      public void LoginWithValidCredential(HashMap<String,String> hMap) throws Throwable  {
    	  HomePage homePage = new HomePage(driver);
		  homePage.clickOnLoginOption();
		  LoginPage loginPage = homePage.clickOnLoginOption();
		  loginPage.enterPhoneNumber(hMap.get("validph/cardnum"));
		  loginPage.enterPin(prop.getProperty("validpin"));
		  Thread.sleep(6000);
		  PayBackPage payBackPage=loginPage.submitButton();
		  Thread.sleep(2000);
          
          Assert.assertTrue(payBackPage.varifyPayBackTextBox());
     }
      
      
	 @Test(priority=2)
	 public void loginWithInvalidCredential() throws Throwable {
		    HomePage homePage = new HomePage(driver);
		    homePage.clickOnLoginOption();
		    LoginPage loginPage = homePage.clickOnLoginOption();
			  loginPage.enterPhoneNumber(prop.getProperty("invalidph/cardnum"));
			  loginPage.enterPin(prop.getProperty("invalidpin"));
			  Thread.sleep(3000);
			  PayBackPage payBackPage=loginPage.submitButton();
			  Thread.sleep(2000);
			  Assert.assertFalse(loginPage.varifyWarningMessage());
	        
	 }
	 @DataProvider
		public Object[][] dataSupplier() {
			
			Object[][] obj = null;
			
			try {
				
				excelReader = new MyXLSReader("src\\test\\resources\\PayBackExcelSheet.xlsx");
				obj = DataUtil.getTestData(excelReader, "LoginTest", "Data");
			
			}catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
			return obj;
			
		}
	 

}
