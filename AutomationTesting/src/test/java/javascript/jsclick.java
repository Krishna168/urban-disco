package javascript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jsclick {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().version("84.0.4147.30").setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("http://demo.guru99.com/V4/");
		WebElement button = driver.findElement(By.name("btnLogin"));

		// Login to Guru99
		driver.findElement(By.name("uid")).sendKeys("mngr34926");
		driver.findElement(By.name("password")).sendKeys("amUpenu");

		// Perform Click on LOGIN button using JavascriptExecutor
		js.executeScript("arguments[0].click();", button);

		// To generate Alert window using JavascriptExecutor. Display the alert message
		js.executeScript("alert('Welcome to Guru99');");

	}
}


