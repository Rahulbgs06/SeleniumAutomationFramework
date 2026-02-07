package Tests;

import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;
import Utils.Log;

public class LoginTest extends BaseTest{

	
	
	@Test
	public void testlogin() {
		
		Log.info("Starting Loging Test .....");
		LoginPage loginpage= new LoginPage(driver);
		
		Log.info("credentials .....");
		
		loginpage.enterUsername("admin@yourstore.com");
		
		loginpage.enterPassword("admin");
		
		Log.info("Logging In .....");
		loginpage.clickLogin();
		
		System.out.println("Title :"+driver.getTitle());
		
		
}
}
