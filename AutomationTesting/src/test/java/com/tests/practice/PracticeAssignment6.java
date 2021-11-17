package com.tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PracticeAssignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Krishna\\eclipse-workspace\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://qaclickacademy.com/practice.php");
		WebElement checboxToBeClicked = driver.findElement(By.id("checkBoxOption3"));
		checboxToBeClicked.click();
		String opt = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[3]")).getText();
		System.out.println(opt);

		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByVisibleText(opt);
		driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys(opt);
		driver.findElement(By.id("alertbtn")).click();
		String alertMessage = driver.switchTo().alert().getText();
		//driver.switchTo().alert().accept();
		if (alertMessage.contains(opt)) {
			//System.out.println("Alert message is Successful");
			Assert.assertTrue(true);
		} else {
			//System.out.println("Alert message is Failure");
			Assert.assertFalse(false);
		}

	}

}
