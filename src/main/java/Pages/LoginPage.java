package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Log;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(id="Email")
	WebElement usernameBox;
	
	@FindBy(id="Password")
	WebElement passwordBox;
	
	@FindBy(xpath="//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement loginbutton;
	
//	@FindBy(linkText = "Logout")
//	WebElement linkLogout;

	
	/* Without Page Factory*/
//	By usernameBox = By.id("Email");
//	By passwordBox = By .id("Password");
//	By loginbutton = By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button");
	
	
	 public LoginPage(WebDriver driver)
	 {
		 this.driver = driver;
		 PageFactory.initElements(driver, this); 
	 }
	 
	 
	
    public void enterUsername(String user) {
    	
    	usernameBox.clear();
    	usernameBox.sendKeys(user);
//    	driver.findElement(usernameBox).clear);
//        driver.findElement(usernameBox).sendKeys(user);
    }

    public void enterPassword(String pass) {
    	
    	passwordBox.clear();
    	passwordBox.sendKeys(pass);
//    	driver.findElement(passwordBox).clear();
//        driver.findElement(passwordBox).sendKeys(pass);
    }

    public void clickLogin() {
    	
    	loginbutton.click();
//        driver.findElement(loginbutton).click();
    }
    


//    public boolean isLogoutVisible() {
//        return linkLogout.isDisplayed();
//    }

	
	
}
