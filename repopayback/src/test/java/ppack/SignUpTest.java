package ppack;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.SignUpPage;
import util.DataUtil;
import util.MyXLSReader;

public class SignUpTest extends Base {
	public WebDriver driver;
	MyXLSReader excelReader;
	
	
	
	@BeforeMethod
	public void setup() throws IOException  {
		   driver = initializeBrowser();
		   driver.get(prop.getProperty("url1"));
		}
	
	 @AfterMethod
		public void tearDown() {
			driver.quit();
	    }
	 
	
	
	
	
	    @Test(dataProvider="dataSupplier")
	    public void signUpWithValidCredential(HashMap<String,String> hMap) throws Throwable {
              
		     SignUpPage signUpPage= new SignUpPage(driver);
			
			 WebElement dropdownField = driver.findElement(By.xpath("//select[@name='salutation']"));
			 Select select = new Select (dropdownField);
			 select.selectByVisibleText("Mr");
			 Thread.sleep(2000);
	
			 signUpPage.enterFirstName(hMap.get("firstname"));
			 signUpPage.enterLastName(hMap.get("lastname"));
			 signUpPage.enterPhoneNumber(hMap.get("phonenumber"));
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
			  signUpPage.clickOnPrivacyPolicy();
			  signUpPage.clickOnGenerateOTP();
			  Thread.sleep(2000);
			  
			  Assert.assertTrue(driver.findElement(By.xpath("//button[normalize-space()='Submit']")).isDisplayed());
			
		
	  }
	 
	 
	 @Test(priority=2)
     public void signUpWithoutSelectingSalutation() throws Throwable {
		 SignUpPage signUpPage= new SignUpPage(driver);
		
		 WebElement dropdownField = driver.findElement(By.xpath("//select[@name='salutation']"));
		 Select select = new Select (dropdownField);
		 select.selectByVisibleText("Mr");
		 Thread.sleep(2000);
		 signUpPage.enterFirstName(prop.getProperty("fname"));
		 Thread.sleep(2000);
		 signUpPage.enterLastName(prop.getProperty("lname"));
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
		  signUpPage.clickOnPrivacyPolicy();
		  signUpPage.clickOnGenerateOTP();
 		  
		  Assert.assertFalse(signUpPage.varifyWarningMessage());

     }
	 
	 @DataProvider
		public Object[][] dataSupplier() {
			
			Object[][] obj = null;
			
			try {
				
				excelReader = new MyXLSReader("src\\test\\resources\\PayBackExcelSheet.xlsx");
				obj = DataUtil.getTestData(excelReader, "SignUpTest", "Data");
			
			}catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
			return obj;
			
		}

	 
	
	 

}
