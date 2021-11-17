package javaStreams;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamTest1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().version("84.0.4147.30").setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//span[text()='Veg/fruit name']")).click();
		List<WebElement> webElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		List<String> originalList = webElements.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertEquals(sortedList, originalList);
		Assert.assertTrue(originalList.equals(sortedList));
		List<String> price;
		do
		{
		List<WebElement> webElements1 = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		 price=webElements1.stream().filter(s->s.getText().contains("Wheat")).
		map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
		if(price.size()<1)
		{
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		}while(price.size()<1);
		
		
		
		
	}

	private static String getPriceVeggie(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

	

}
