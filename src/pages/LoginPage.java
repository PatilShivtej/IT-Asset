package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

   
    By usernameField = By.xpath("//input[@id='username']");
    By passwordField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[@id='btnContinue']");

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

   public void enterPassword(String password) {
      driver.findElement(passwordField).sendKeys(password);
   }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

	public void enterPassword1(String string) {
	
		
	}
}