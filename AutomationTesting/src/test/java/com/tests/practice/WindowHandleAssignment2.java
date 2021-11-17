package com.tests.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleAssignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver","G:\\KrishnaEclipseWorkspace\\drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().version("84.0.4147.30").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		//System.out.println(driver.getTitle());
		//String parentWindow=driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it =ids.iterator();
		while(it.hasNext())
		{
			System.out.println(driver.switchTo().window(it.next()));
			System.out.println(driver.getTitle());
			//System.out.println(driver.switchTo().window(it.next()));
			//System.out.println(it.next());
			
		}
		



	}

}
