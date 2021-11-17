package Demo.Selenium4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

import java.io.File;
import java.util.*;

public class NewWindowOrTab {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Creating new Tab or Window
		//driver.switchTo().newWindow(WindowType.TAB); //Selenium just opened the new tab but the focus is still on the parent window only
		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parentWindowID = it.next();
		String childWindowID = it.next();		
		driver.switchTo().window(childWindowID);
		driver.get("https://rahulshettyacademy.com/");
		//String desiredName = driver.findElement(By.xpath("(//h2/a)[1]")).getText();
		String desiredName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(parentWindowID);		
	    WebElement name =driver.findElement(By.xpath("//input[@name='name' ]"));
		name.sendKeys(desiredName);
		//Take WebElement Screenshot using Selenium
		File src = name.getScreenshotAs(OutputType.FILE);
		File desc = new File("./Screenshots/nameTextBox.png");
		FileUtils.copyFile(src, desc);
		
		//Get the Height and Width of the WebElement.
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());		
		
		Thread.sleep(5000);
		driver.quit();		




	}

}
