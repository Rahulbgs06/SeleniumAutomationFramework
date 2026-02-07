 package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utils.Log;


public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		
		Log.info("Starting Webdriver.....");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		Log.info("Navigating Webpage.....");
		driver.get("https://admin-demo.nopcommerce.com/login?returnUrl=%2Fadmin%2F");
		
		
	}
	@AfterMethod
	
	public void down() {
		Log.info("Closing Webpage.....");
		driver.quit();
	}

}
