import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkartSVG {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().version("84.0.4147.30").setup();
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
//		c.addArguments("--headless");
		WebDriver driver=new ChromeDriver(c);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("mobiles");
		if(driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).isDisplayed())
		{
			driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		}
		List<WebElement> ele = driver.findElements(By.xpath("(//*[name()='svg']//*[local-name()='g' and @fill-rule='evenodd'])[1]//*[local-name()='path']"));
		for(WebElement e:ele)
		{
			System.out.println(e.getAttribute("d"));
		}
		driver.findElement(By.xpath("(//*[name()='svg']//*[local-name()='g' and @fill-rule='evenodd'])[1]//*[local-name()='path']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'results for')]")).isDisplayed());
	
	}

}
