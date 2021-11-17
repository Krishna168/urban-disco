package com.tests.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\auto\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		Select s = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		s.selectByIndex(5);
		Thread.sleep(5000);
		s.selectByValue("Sunday");
		Thread.sleep(5000);
		s.selectByVisibleText("Saturday");
		Thread.sleep(5000);
		System.out.println("successfully dropdown is selected");
		//Retreiving the Select dropdown values		
		List<WebElement> list=s.getOptions();
		
		//Using Enhanced for loop
		for(WebElement value:list)
		{
			System.out.println(value.getText());
		}
		
		//Using the traditional for loop
		/*for(int i=0;i<list.size();i++)
		{
		 
		}*/
		
		driver.close();




	}

}
