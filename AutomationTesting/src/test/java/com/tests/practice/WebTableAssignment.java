package com.tests.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Krishna\\eclipse-workspace\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		WebElement table = driver.findElement(By.id("product"));
		/* One way of assignment
		System.out.println("The number of rows in the table is " +table.findElements(By.tagName("tr")).size());
		System.out.println("The number of columns in the table is " +table.findElements(By.xpath("//table[@id='product']/tbody/tr/th")).size());
		//table[@id='product']/tbody/tr[2]/td
		System.out.println(table.findElement(By.xpath("//table[@id='product']/tbody/tr[2]/td[1]")).getText());
		System.out.println(table.findElement(By.xpath("//table[@id='product']/tbody/tr[2]/td[2]")).getText());
		System.out.println(table.findElement(By.xpath("//table[@id='product']/tbody/tr[2]/td[3]")).getText());
		*/
		
		System.out.println(table.findElements(By.tagName("tr")).size());
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		
		List<WebElement> secondRow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(secondRow.get(0).getText());
		System.out.println(secondRow.get(1).getText());
		System.out.println(secondRow.get(2).getText());
		
	}

}

