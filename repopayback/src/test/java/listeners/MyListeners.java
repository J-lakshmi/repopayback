package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.Base;
import utilities.ExtentReporter;
import com.aventstack.extentreports.Status;

public class MyListeners extends Base implements ITestListener  {
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReport.createTest(result.getName()+" execution started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS,"Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.fail(result.getThrowable());
	 System.out.println("----Test Failed----Hence Take a Screenshot");
	 WebDriver driver = null;
		
		String testName = result.getName();
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		try {
			String screenshotPath=takeScreenshot(testName,driver);
			extentTest.addScreenCaptureFromPath(screenshotPath, testName);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}
		

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		
	}
	

}
