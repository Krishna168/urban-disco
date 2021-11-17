package com.tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LearnCSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "G:\\KrishnaEclipseWorkspace\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("abcd");
		driver.findElement(By.cssSelector("[name='pw']")).sendKeys("123");
		driver.findElement(By.cssSelector("input[id='Login']")).click();
		Assert.assertEquals("Please check your username and password. If you still can't log in, contact your Salesforce administrator.", 
				"Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
		System.out.println("Error Message verification is passed");
		driver.close();

	}

}
