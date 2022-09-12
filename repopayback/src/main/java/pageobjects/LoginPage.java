package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="pb-card-number")
	private WebElement phoneNumberField;
	 
	@FindBy(name="pin_number")
	private WebElement pinField;
	
	
	@FindBy(xpath="//button[@class='btn pb-login-submit red-button']")
	private WebElement submitButton;
	
	@FindBy(className="help-block")
	private WebElement warningMessageForInvalidCrdential;
	
	@FindBy(id="pb-forgot-pin1")
	private WebElement forGotPin;
	
	@FindBy(id="generatePinBtn")
	private WebElement generatePin;
	
	@FindBy(xpath="//small[normalize-space()='Please provide your card/mobile number.']")
	private WebElement warningMessageForPhonenumber;
	
	
	public void enterPhoneNumber(String phonenumberText) {
		phoneNumberField.sendKeys(phonenumberText);
		
	}
	
	public void enterPin(String pinText) {
		pinField.sendKeys(pinText);
		
	}
	
	public PayBackPage submitButton() {
		submitButton.submit();
		return new PayBackPage(driver);
	}
	public boolean varifyWarningMessage() {
		return warningMessageForInvalidCrdential.isDisplayed();	 
		
	}
    public ForgotPinPage clickOnForgotPin() {
    	forGotPin.click();
    	return new ForgotPinPage(driver);
    }
    public boolean varifyingWarningMessage() {
    	return warningMessageForPhonenumber.isDisplayed();
    }
    
    
}
