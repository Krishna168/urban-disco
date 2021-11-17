package com.tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderTrainer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Krishna\\eclipse-workspace\\drivers\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		//April 23
		Thread.sleep(5000);
		driver.findElementByXPath("//input[@id='departure']").click();


		while(!driver.findElement(By.cssSelector("[class='DayPicker-Month'] [class='DayPicker-Caption']")).getText().contains("May"))
		{
			driver.findElement(By.cssSelector("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		}


		//List<WebElement> dates= driver.findElements(By.className("day"));
		//Grab common attribute//Put into list and iterate
		int count=driver.findElements(By.className("dateInnerCell")).size();

		for(int i=0;i<count;i++)
		{
			String text=driver.findElements(By.className("dateInnerCell")).get(i).getText();
			if(text.equalsIgnoreCase("21"))
			{
				driver.findElements(By.className("dateInnerCell")).get(i).click();
				break;
			}

		}
	}

}

