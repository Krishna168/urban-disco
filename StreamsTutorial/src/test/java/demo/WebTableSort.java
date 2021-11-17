package demo;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().version("95.0.4638.17").setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on column name
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capture all webelements into list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
		//capturing all text of webelements into original list
		List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//apply sorting and prepare the sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		//compare original and sorted list
		Assert.assertEquals(originalList, sortedList);
		

	}

}
