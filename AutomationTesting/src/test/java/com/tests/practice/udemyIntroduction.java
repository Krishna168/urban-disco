package com.tests.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import library.Utility;

public class udemyIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Krishna\\\\eclipse-workspace\\\\drivers\\\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://google.com");
Utility.captureScreenshot(driver, "google1");
driver.manage().window().maximize();
System.out.println(driver.getTitle());
System.out.println(driver.getCurrentUrl());
driver.get("https://login.yahoo.com/");
Utility.captureScreenshot(driver, "yahoo");
driver.navigate().back();
driver.navigate().forward();
Utility.captureScreenshot(driver, "google2");
driver.close();
	}

}
