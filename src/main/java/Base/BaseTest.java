 package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Utils.ExtentReportManager;
import Utils.Log;


public class BaseTest {
	
	protected WebDriver driver;
	public static ExtentReports extent;
	
	public static ExtentTest test;
	
	@BeforeSuite
	public void setupReport() {
		
		extent = new ExtentReportManager().getInstance();
		
	}
	
	@AfterSuite
	public void tearDownReport() {
		extent.flush();
		
	}
	
	@BeforeMethod
	public void setUp(){
		
		Log.info("Starting Webdriver.....");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		Log.info("Navigating Webpage.....");
		driver.get("https://admin-demo.nopcommerce.com/login?returnUrl=%2Fadmin%2F");
		
		
	}
	@AfterMethod
	
	public void down(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			
			String screenshotPath = ExtentReportManager.captureScreenshot(driver, "LoginFailure");
			test.fail("Test Failed.. Check Screenshot", 
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		
		Log.info("Closing Webpage.....");
		driver.quit();
	}

}
