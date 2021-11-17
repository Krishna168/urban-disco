import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConsoleLogsCapture {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().browserVersion("95.0.4638.54").setup();
		ChromeDriver driver = new ChromeDriver();
		//Listeneres - OnTest Failure method
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.partialLinkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logs = logEntries.getAll();
		
		for(LogEntry e: logs)
		{
			System.out.println(e.getMessage());
		}

	}

}
