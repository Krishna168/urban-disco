package com.tests.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestiveAssignment {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//		System.setProperty("webdriver.chrome.driver","C:\\Users\\Krishna\\eclipse-workspace\\drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().version("84.0.4147.30").setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']")).sendKeys("aus");
		Thread.sleep(3000);
		//		driver.findElement(By.xpath("//input[@placeholder='Select Countries']")).sendKeys(Keys.ARROW_DOWN);
		//		driver.findElement(By.xpath("//input[@placeholder='Select Countries']")).sendKeys(Keys.ARROW_DOWN);
		//String country = driver.findElement(By.xpath("//input[@placeholder='Select Countries']")).getText();
		//System.out.println(country);


		/*Using javascript executor to get the text
		JavascriptExecutor js =(JavascriptExecutor)driver;	
		String country = "return document.getElementById(\"autocomplete\").value;";
		String text = (String) js.executeScript(country);
		System.out.println(text);*/

		//Using getAttribute Method to get the text
		//		System.out.println(driver.findElement(By.xpath("//input[@placeholder='Select Countries']")).getAttribute("value"));

		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase("Austria"))
			{
				option.click();
			}
		}


	}

}
