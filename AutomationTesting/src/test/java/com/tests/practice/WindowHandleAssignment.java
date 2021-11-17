package com.tests.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver","G:\\KrishnaEclipseWorkspace\\drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().version("84.0.4147.30").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it =ids.iterator();
		String parentWindowID=it.next();
		String childWindowID =it.next();//In this step, the focus will not be shifted to child window, but the child window id will be stored in the string variable.
		System.out.println(parentWindowID);
		System.out.println(childWindowID);
		driver.switchTo().window(childWindowID);
		System.out.println(driver.findElement(By.xpath("//h3[text()='New Window']")).getText());
		driver.switchTo().window(parentWindowID);
		System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());




	}

}
