package com.tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Salesforce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Krishna\\\\eclipse-workspace\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.cssSelector("input#username.input.r4.wide.mb16.mt8.username")).sendKeys("krishna");
		driver.findElement(By.cssSelector("input#password.input.r4.wide.mb16.mt8.password")).sendKeys("krish");
		driver.findElement(By.cssSelector("input#Login.button.r4.wide.primary")).click();
		System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());
		driver.close();
	}

}
