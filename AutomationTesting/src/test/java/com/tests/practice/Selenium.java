package com.tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import library.Utility;

public class Selenium {

	public static void main (String args[]) throws Exception{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Krishna\\eclipse-workspace\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Krishna\\eclipse-workspace\\drivers\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\Krishna\\eclipse-workspace\\drivers\\IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		
		driver.manage().window().maximize();
		driver.get("https:\\www.facebook.com");
		Utility.captureScreenshot(driver, "FacebookLaunched");
		
		String tagName = driver.findElement(By.name("email")).getTagName();
		System.out.println(tagName);
		String titleName = driver.getTitle();
		System.out.println(titleName);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		WebElement userName = driver.findElement(By.name("email"));
		userName.sendKeys("abc");
		Utility.captureScreenshot(driver, "UsernameEntered");
		



		Thread.sleep(5000);
		driver.quit();	
	}
}



