package com.tests.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"G:\\KrishnaEclipseWorkspace\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Nested Frames")).click();
		System.out.println(driver.findElements(By.tagName("frameset")).size());
		/*WebElement wholeFrame = driver.findElement(By.xpath("//frameset[@frameborder='1']"));
		driver.switchTo().frame(wholeFrame);*/
		//driver.switchTo().frame(0);
		WebElement frameTop = driver.findElement(By.cssSelector("frame[name='frame-top']")); 
		driver.switchTo().frame(frameTop);
		WebElement frameMiddle = driver.findElement(By.cssSelector("frame[name='frame-middle']")); 
		driver.switchTo().frame(frameMiddle);
		System.out.println(driver.findElement(By.id("content")).getText());



	}

}
