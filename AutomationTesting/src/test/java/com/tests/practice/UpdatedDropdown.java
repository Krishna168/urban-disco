package com.tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Krishna\\\\eclipse-workspace\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://spicejet.com");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();


		//driver.findElement(By.xpath("(contains[class,'.ui-state-default.ui-state-highlight.ui-state-active']")).click();

		//To select the checkbox
		/*driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).click();
	driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("input[id*='SeniorCitizenDiscount']"))).click().build().perform();
		Thread.sleep(5000);
		driver.close();*/

		//To find the field is enabled or disabled.
		System.out.println(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style"));
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style"));
		if(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("1"))
				{
			System.out.println("its enabled");
			Assert.assertTrue(true);
				}
		else {
			Assert.assertTrue(false);
		}
		
		//To check the senior citizen checkbox
		System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
		
		//To count the no. of checkboxes.
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		driver.close();




	}

}
