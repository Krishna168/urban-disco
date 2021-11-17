package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import library.Utility;

public class Kalyanaa {

	public static void main(String[] args) {
		List<WebElement>t;
		
		Utility l=new Utility();
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "G:\\KrishnaEclipseWorkspace\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://kalyanaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("login")).click();
		driver.findElement(By.id("login-username")).sendKeys("5870");
		driver.findElement(By.id("login-password")).sendKeys("raga12345");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.cssSelector(".dropdown-toggle.big-font-top-menu")).click();
		driver.findElement(By.xpath("//li/a[text()='Quick Search ']")).click();
		driver.findElement(By.xpath("//a[text()=' Quick ']")).click();
		Select s=new Select(driver.findElement(By.id("agefrm")));
		s.selectByValue("20");
		Select d=new Select(driver.findElement(By.id("ageto")));
		d.selectByIndex(6);
		Select f=new Select(driver.findElement(By.id("subcaste")));
		f.selectByVisibleText("Madhwa Desistha");
		t=f.getOptions();
		for(int i=1;i<t.size();i++)
		{
			
				System.out.println(t.get(i).getText());
		}
		
		driver.findElement(By.id("qs-btn-submit")).click();
		String text =driver.findElement(By.xpath("//div/h4[@class='text-primary']/span")).getText();
		System.out.println("Madhwa Deshishta is " +text);
		Utility.captureScreenshot(driver, "Madhwa Deshista");
		
		
		
		
		
				
		
		/*
		 * driver.findElement(By.cssSelector(".dropdown-toggle.big-font-top-menu")).
		 * click();
		 * driver.findElement(By.xpath("//li/a[text()='Quick Search ']")).click();
		 * driver.findElement(By.xpath("//a[text()=' Quick ']")).click(); Select s1=new
		 * Select(driver.findElement(By.id("agefrm"))); s1.selectByValue("20"); Select
		 * d1=new Select(driver.findElement(By.id("ageto"))); d1.selectByIndex(6);
		 * Select f1=new Select(driver.findElement(By.id("subcaste")));
		 * f1.selectByVisibleText("Madhwa Kannada");
		 * driver.findElement(By.id("qs-btn-submit")).click(); String text1
		 * =driver.findElement(By.xpath("(//div/h4[@class='text-primary']/span")).
		 * getText(); System.out.println("Madhwa Kannada is " +text1);
		 * Utility.captureScreenshot(driver, "Madhwa Kannada");
		 * 
		 * driver.findElement(By.xpath("(//a[@class='big-font-top-menu'])[2]")).click();
		 * driver.close();
		 */


	}

}
