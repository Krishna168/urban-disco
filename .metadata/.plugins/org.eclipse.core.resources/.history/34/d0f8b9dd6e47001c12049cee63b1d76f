package com.tests.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().version("81.0.4044.138").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		Actions a = new Actions(driver);
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
		WebElement move = driver.findElement(By.id("nav-link-accountList"));
		//Hover the particular element and performing the right click 
		a.moveToElement(move).contextClick().build().perform();
		//driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("HELLO");
		//Enter the given string in capital letters and selecting the entered text
		WebElement searchBox=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		//drag and drop to be discussed in the frames concept.
		System.out.println("Successful");
		searchBox.clear();
		searchBox.sendKeys("phone",Keys.ENTER);
		String variable = "//div[@data-component-type='s-search-result']//div[@class='sg-col-inner']/div/h2/a/span";
		List<WebElement> allphones=driver.findElements(By.xpath(variable));
		for(int i=0;i<allphones.size();i++)
		{
			System.out.println(allphones.get(i).getText());
		}
		
		System.out.println(driver.findElement(By.xpath("(//h2/a/span[text()='Nokia 105 2019 (Single SIM, Black)'])[2]")).getText());
		//driver.close();
		
		
		
		
		
	}

}
