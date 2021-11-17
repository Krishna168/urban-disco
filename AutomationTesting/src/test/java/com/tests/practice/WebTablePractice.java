package com.tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Krishna\\eclipse-workspace\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://m.cricbuzz.com/cricket-scorecard/22753/ind-vs-wi-3rd-t20i-west-indies-tour-of-india-2019");
		WebElement tableDriver = driver.findElement(By.xpath("(//div[@class='list-group'])[4]"));
		//	System.out.println(tableDriver.findElement(By.xpath("(//div[@class='list-group'])[7] //div[@class='table-responsive']//tr[2] //td[@class='cbz-grid-table-fix '][2]")).getText());
		//System.out.println(tableDriver.findElements(By.xpath("//div[@class='table-responsive'][2]//td[2]/b")).size());
		int rowCount = tableDriver.findElements(By.cssSelector("div[class='table-responsive']")).size();
		tableDriver.findElements(By.cssSelector("div[class='table-responsive']/ "));


	}

}
