package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPinPage {
WebDriver driver;
	
	public ForgotPinPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="generatePinBtn")
	private WebElement generatePinOption;
	
	@FindBy(id="modal-header")
	private WebElement generatePinSuccessfullmessage;
	
	public void clickOnGeneratePin() {
		generatePinOption.click();
	
	}
	public boolean succsessMessage() {
	return generatePinSuccessfullmessage.isDisplayed();
		
	}

}
