package com.tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebookxpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Krishna\\\\eclipse-workspace\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		
		//Xpath to locate elements
		/*driver.findElement(By.xpath("//input[@name='email']")).sendKeys("krishna1235");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abcd12345");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.close();*/
		
		//csss to locate elements
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("krish");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("pass123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		System.out.println("successful");
		driver.close();
		
		
	}

}
