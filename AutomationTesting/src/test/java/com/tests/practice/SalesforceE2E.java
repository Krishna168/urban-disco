package com.tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesforceE2E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Krishna\\\\eclipse-workspace\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rediff.com");
		driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("abc");
		driver.findElement(By.cssSelector("input#password")).sendKeys("pass123");
		//driver.findElement(By.cssSelector("input[title='Sign in']")).click();
		driver.findElement(By.xpath("//input[contains(@name,'proc')]")).click();
		System.out.println("Successful");
		driver.close();
	}

}
