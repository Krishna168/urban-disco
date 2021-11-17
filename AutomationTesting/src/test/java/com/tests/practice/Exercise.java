package com.tests.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Krishna\\eclipse-workspace\\drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().version("84.0.4147.30").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://phptravels.com/demo/");
		driver.findElement(By.xpath("//small[text()='http://www.phptravels.net']")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it =ids.iterator();
		String parentWindowID=it.next();
		String childWindowID =it.next();
		System.out.println("The Parent Window id before switching is "+driver.getTitle());
		driver.switchTo().window(childWindowID);
		WebDriverWait wd= new WebDriverWait(driver, 30);
		wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Hotels')]")));
		System.out.println("The child window id after switching is "+driver.getTitle());
		driver.switchTo().window(parentWindowID);
		System.out.println("Switching back again to parent window id is "+driver.getTitle());
		
		
		
		
		

	}

}
