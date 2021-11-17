package demo;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class vegPrice {
	
	@Test
	public void getVegPrice()
	{
		List<String> price;
		WebDriverManager.chromedriver().version("95.0.4638.17").setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		do
		{
		List<WebElement> elementsList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		price = elementsList.stream().filter(s->s.getText().equalsIgnoreCase("Rice"))
		.map(s->getVeggiePrice(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		if(price.size()<1)
		{
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		}
		while(price.size()<1);
			
	}

	private String getVeggiePrice(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
