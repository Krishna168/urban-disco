import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jsDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().version("84.0.4147.30").setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.guru99.com/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("alert('Hello!!')");
		//js.executeScript("prompt('Enter your Email')");
		//js.executeScript("confirm('Are you sure ?')");
	}

}
