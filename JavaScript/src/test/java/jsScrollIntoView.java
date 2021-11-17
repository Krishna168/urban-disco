import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jsScrollIntoView {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().version("84.0.4147.30").setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement ele=driver.findElement(By.xpath("//div[@id='mCSB_3_container'] //p[contains(text(),'Quis autem vel')][2]"));
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
		System.out.println(ele.getText());
		WebElement ele1 = driver.findElement(By.xpath("(//p[contains(text(),'Excepteur')])[6]"));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView(true)", ele1);
		System.out.println(ele1.getText());
		WebElement ele2 = driver.findElement(By.xpath("(//p[contains(text(),'explicabo')])[7]"));
		js.executeScript("arguments[0].scrollIntoView(true)", ele2);
		System.out.println(ele2.getText());
		
		
	}

}
