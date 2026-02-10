package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;
import Utils.ExcelUtils;
import Utils.ExtentReportManager;
import Utils.Log;

public class LoginTest extends BaseTest {

	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() throws IOException {

		String filePath = System.getProperty("user.dir") + "/Testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount - 1][2];

		for (int i = 1; i < rowCount; i++) {

			data[i - 1][0] = ExcelUtils.getCellData(i, 0); // Username
			data[i - 1][1] = ExcelUtils.getCellData(i, 1); // Password
		}
		ExcelUtils.closeExcel();
		return data;
	}

	@Test(dataProvider = "LoginData")
	public void testlogin(String username, String password) {

		Log.info("Starting Loging Test .....");

		test = extent.createTest("Login test" + username);
		test.info("start Login test");
		test.info("navigating to url");
		/*
		 * Intializing driver and all page factory elements by creating object of that
		 * class
		 */
		LoginPage loginpage = new LoginPage(driver);

		Log.info("credentials .....");
		test.info("adding credentials");

//		loginpage.enterUsername("admin@yourstore.com");
//
//		loginpage.enterPassword("admin");

		loginpage.enterUsername(username);

		loginpage.enterPassword(password);

		Log.info("Logging In .....");
		test.info("click on login button");
		loginpage.clickLogin();

		System.out.println("Title :" + driver.getCurrentUrl());
		
		
		test.info("verfying Page title");
		
		Assert.assertTrue(driver.getCurrentUrl().contains("https://admin-demo.nopcommerce.com/admin/"));
//		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		test.pass("Login Successfull");

		
//		test.info("verifying login");
//		Assert.assertTrue(loginpage.isLogoutVisible());
//		test.pass("Login Successful");

	}

/*	@Test
	public void testloginInvalid() {

		Log.info("Starting Loging Test .....");

		test = extent.createTest("Login test Invalid");
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
*/
}
