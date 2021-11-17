package com.tests.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Krishna\\eclipse-workspace\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://qaclickacademy.com/practice.php");

		//1. To count the number of links present in the webpage. Hint: starts with "//a" tag.
		System.out.println(driver.findElements(By.tagName("a")).size());

		//2. Counting the number of links present in the footer section by limiting the scope of the webdriver.

		WebElement  footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		//3. Counting the number of links present in the footer first column.
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());

		//4. Clicking on the each links and see if the pages are opening.

		for(int i = 1;i<columnDriver.findElements(By.tagName("a")).size();i++)
		{

			String cickOnLinkTabs = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(cickOnLinkTabs);
		}
		
		Set<String> abc=driver.getWindowHandles();
		Iterator<String> it = abc.iterator();
		while(it.hasNext()){
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			
		}
	}

}
