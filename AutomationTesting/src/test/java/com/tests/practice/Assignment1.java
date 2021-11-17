package com.tests.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().version("84.0.4147.30").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");
		
		// driver.switchTo().alert().dismiss();
		Select A = new Select(driver.findElement(By.name("adults")));
		System.out.println(A.getFirstSelectedOption().getText());
		A.selectByIndex(5);
		
		
		
		Select C = new Select(driver.findElement(By.id("Childrens")));
		C.selectByVisibleText("3");
		Select I = new Select(driver.findElement(By.id("Infants")));
		I.selectByValue("1");
		driver.findElement(By.xpath("//input[@title='Depart date']")).click();
		
		// To click on the current date

		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active ']")).click();
		// driver.findElement(By.xpath("//i[@class='blue rArrow']")).click();
		driver.findElement(By.id("MoreOptionsLink")).click();
		Select Class=new Select(driver.findElement(By.id("Class")));
		List<WebElement> classOptions=Class.getOptions();
		for(WebElement i:classOptions)
		{
			System.out.println(i.getText());
		}
		
		driver.findElement(By.xpath("//input[@placeholder='Airline name']")).sendKeys("indigo");
		driver.findElement(By.xpath("//input[@title='Search flights']")).click();
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
		System.out.println("Cleartrip testcase is successful");
		driver.close();
	

	}

}
