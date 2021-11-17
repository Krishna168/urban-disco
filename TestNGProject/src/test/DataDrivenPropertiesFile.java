package test;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class DataDrivenPropertiesFile {
	public WebDriver driver;
	
	
	

	@Test
	public void propertiesFile() throws Exception{

		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream("C:\\Users\\Krishna\\eclipse-workspace\\TestNGTutorial\\src\\test\\dataDriven.properties");
		prop.load(fs);
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("Password"));
		System.out.println(prop.getProperty("URL"));
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Krishna\\eclipse-workspace\\drivers\\chromedriver.exe");
			driver =new ChromeDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Krishna\\eclipse-workspace\\drivers\\geckodriver.exe");
			driver =new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Krishna\\eclipse-workspace\\drivers\\IEDriverServer.exe");
			driver =new InternetExplorerDriver();
		}


	}
}
