package excel.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.lib.util.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().version("81.0.4044.138").setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Xls_Reader reader = new Xls_Reader("./src/main/java/com/excel/lib/util/SampleExcel.xlsx");
		
		int rowCount=reader.getRowCount("CRM");
		WebElement username=driver.findElement(By.name("username"));
		WebElement password=driver.findElement(By.name("password"));
		
		for(int rowNum=2;rowNum<=rowCount;rowNum++)
		{
		
		String uname=reader.getCellData("CRM", 0, rowNum);
		String pwd=reader.getCellData("CRM", "Password", rowNum);
		
		username.clear();		
		username.sendKeys(uname);
		
		password.clear();
		password.sendKeys(pwd);
		
		}

	}

}
