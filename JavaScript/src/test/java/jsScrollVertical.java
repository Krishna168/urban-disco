import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jsScrollVertical {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().version("84.0.4147.30").setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://jquery.com/");
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0,1200)");
		Thread.sleep(3000);
		js.executeScript("scroll(0,-800)");
		
		
		
		
		
	}

}
