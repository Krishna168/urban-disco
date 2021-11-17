import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jsType2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().version("84.0.4147.30").setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://login.yahoo.com/");
		Thread.sleep(4000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('login-username').value=arguments[0]","abc@yahoo.com");
		js.executeScript("document.getElementById('persistent').click()");
		
		
		
		
		
	}

}
