package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;
import Utils.ExtentReportManager;
import Utils.Log;

public class LoginTest extends BaseTest {

	@Test
	public void testlogin() {

		Log.info("Starting Loging Test .....");

		test = test = extent.createTest("Login test");
		test.info("start Login test");
		test.info("navigating to url");
		LoginPage loginpage = new LoginPage(driver);

		Log.info("credentials .....");
		test.info("adding credentials");

		loginpage.enterUsername("admin@yourstore.com");

		loginpage.enterPassword("admin");

		Log.info("Logging In .....");
		test.info("click on login button");
		loginpage.clickLogin();

		System.out.println("Title :" + driver.getTitle());

		test.info("verfying Page title");
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store. Login");
		test.pass("Login Successfull");

	}
	
	@Test
	public void testloginInvalid() {

		Log.info("Starting Loging Test .....");

		test = test = extent.createTest("Login test Invalid");
		test.info("start Login test");
		test.info("navigating to url");
		LoginPage loginpage = new LoginPage(driver);

		Log.info("credentials .....");
		test.info("adding credentials");

		loginpage.enterUsername("admin@yourstore.com");

		loginpage.enterPassword("admin");

		Log.info("Logging In .....");
		test.info("click on login button");
		loginpage.clickLogin();

		System.out.println("Title :" + driver.getTitle());

		test.info("verfying Page title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		test.pass("Login Successfull");

	}
}
