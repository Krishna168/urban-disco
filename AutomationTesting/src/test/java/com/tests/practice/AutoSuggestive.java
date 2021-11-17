package com.tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestive {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().version("81.0.4044.138").setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.ksrtc.in/");
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ARROW_DOWN);
		
		//Using getAttribute method to extract the value present.
		System.out.println(driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getAttribute("value"));
		

		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText();


		//JavaScript Executor: To find the hidden Elements in DOM whereas Selenium can't able to find the hidden elements in DOM. Hence switching to Javascript to execute.
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String script = "return document.getElementById(\"fromPlaceName\").value;";
		String text = (String) js.executeScript(script);
		System.out.println(text);
		int i=0;

		//To Select the Bangalore International Airport
		while(!text.contains("AIRPORT"))
		{
			i++;
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ARROW_DOWN);
			text = (String) js.executeScript(script);
			System.out.println(text);
			if(i>10)
			{
				break;
			}

		}
		if(i>10)
		{
			System.out.println("Element not found");
		}
		else
		{
			System.out.println("Element is found");}

	}

}
