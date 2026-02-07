package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.Log;

public class LoginPage {
	
	private WebDriver driver;
	
	By usernameBox = By.id("Email");
	By passwordBox = By .id("Password");
	By loginbutton = By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button");
	
	
	 public LoginPage(WebDriver driver)
	 {
		 this.driver = driver;
	 }
	 
	
    public void enterUsername(String user) {
    	
    	driver.findElement(usernameBox).clear();
        driver.findElement(usernameBox).sendKeys(user);
    }

    public void enterPassword(String pass) {
    	driver.findElement(passwordBox).clear();
        driver.findElement(passwordBox).sendKeys(pass);
    }

    public void clickLogin() {
    	
        driver.findElement(loginbutton).click();
    }
	
	
}
