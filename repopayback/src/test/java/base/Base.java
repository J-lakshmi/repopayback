package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public Properties prop;
	WebDriver driver;
	
	public WebDriver initializeBrowser() throws IOException {
		
		prop = new Properties();
		File file =new File("src\\main\\java\\resources\\data.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		 
		 String browser= prop.getProperty("browser");
		 
		 if(browser.equals("chrome")) {
			 WebDriverManager.chromedriver().setup();
				ChromeOptions options=new ChromeOptions();
				
				options.addArguments("--disable-notifications");
				
			    driver = new ChromeDriver(options);
		 }
		 else if (browser.equals("edge")) {
			 WebDriverManager.edgedriver().setup();
				EdgeOptions options=new EdgeOptions();
				
				options.addArguments("--disable-notifications");
				
			    driver = new EdgeDriver(options);
			 
		 }
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 return driver;
	}
	
	public String takeScreenshot(String testName,WebDriver driver) throws IOException {
		
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotFilePath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		FileUtils.copyFile(srcScreenshot, new File("screenshotFile"));
		return screenshotFilePath;
	}

}
