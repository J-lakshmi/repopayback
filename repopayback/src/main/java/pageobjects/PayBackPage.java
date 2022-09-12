package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBackPage {
	WebDriver driver;
	public PayBackPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=" //img[@alt='PAYBACK']")
	private WebElement payBackTextBox;
	
	public boolean varifyPayBackTextBox() {
		return payBackTextBox.isDisplayed();
		
	}

}
