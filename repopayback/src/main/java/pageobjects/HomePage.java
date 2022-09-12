package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath="//a[normalize-space()='Login']")
	private WebElement loginOption;
	
	@FindBy(css="p[class='sigup-txt'] a")
	private WebElement signUpOption;
	
	
	public LoginPage clickOnLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	public boolean varifySignUpOption() {
		return signUpOption.isDisplayed();
	}
}
