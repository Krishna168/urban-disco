package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage1 {

	public WebDriver driver;

	By email = By.cssSelector("[id='user_email']");
	By password = By.cssSelector("[type='password']");
	By logIn = By.cssSelector("[value='Log In']");

	public LoginPage1(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLogIn() {
		return driver.findElement(logIn);
	}

}
