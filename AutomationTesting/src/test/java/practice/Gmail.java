package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"G:\\KrishnaEclipseWorkspace\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/");
		driver.findElement(By.id("identifierId")).sendKeys("prasath.ragavendran",Keys.ENTER);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("prasath12345",Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Next']")).click();


	}

}
