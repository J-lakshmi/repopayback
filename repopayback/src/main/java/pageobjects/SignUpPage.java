package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
WebDriver driver;
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className="form-control")
	private WebElement firstnameField;
	
	@FindBy(css="input[placeholder='Last Name']")
	private WebElement lastnameField;
	
	@FindBy(css="input[placeholder='Mobile Number']")
	private WebElement phoneNumberField;
	
	@FindBy(css="input[placeholder='Email ID']")
	private WebElement emailField;
	
	@FindBy(className="reactCalenderBtn")
	private WebElement dobField;
	
	@FindBy(css="div[aria-label='Choose Friday, March 24th, 2000']")
	private WebElement calender;
	
	@FindBy(id="tnc")
	private WebElement privacyPolicyField;
	
	@FindBy(css=".text-white.rounded.border-0.px-2.py-2.px-lg-5.py-lg-2.main-bg.d-block.text-center.text-uppercase.fw-600.cursor-pointer")
	private WebElement generateOTPOption;
	
	@FindBy(className="Toastify__toast-body")
	private WebElement warningMessage;

	
	public void enterFirstName(String firstnameText) {
		firstnameField.sendKeys(firstnameText);
	}
	
	public void enterLastName(String lastnameText) {
		lastnameField.sendKeys(lastnameText);
	}

	public void enterPhoneNumber(String phonenumberText) {
		phoneNumberField.sendKeys(phonenumberText);
		
	}
	
	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	public void enterdob() {
		dobField.click();
	}
	
	public void clickOnCalender() {
	    calender.click();
	}
	
	public void clickOnPrivacyPolicy() {
		privacyPolicyField.click();
	}
	
	public void clickOnGenerateOTP() {
		generateOTPOption.click();
	}
	
	public boolean varifyWarningMessage() {
		return warningMessage.isDisplayed();
	}
	    

	
	

}
