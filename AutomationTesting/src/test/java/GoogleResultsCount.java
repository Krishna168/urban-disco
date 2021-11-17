import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleResultsCount {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().version("84.0.4147.30").setup();
	       WebDriver driver=new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	       driver.get("https://www.google.co.in/");
	       
	       driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium",Keys.ENTER);
	       List<WebElement> list = driver.findElements(By.xpath("//div[@id='rso']/div[@class='g'] //div[@class='rc'] //a/h3[contains(text(),'Selenium')]"));
	       System.out.println(list.size());
	       for(WebElement e:list)
	       {
	    	   System.out.println(e.getText());
	       }
	}

}
