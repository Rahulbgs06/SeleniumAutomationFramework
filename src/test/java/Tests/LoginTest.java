package Tests;

import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;

public class LoginTest extends BaseTest{

	@Test
	public void testlogin() {
		LoginPage loginpage= new LoginPage(driver);
		
		loginpage.enterUsername("admin@yourstore.com");
		
		loginpage.enterPassword("admin");
		
		loginpage.clickLogin();
		
		System.out.println("Title :"+driver.getTitle());
		
		
}
}
