package Automation.Cucumber;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver driver;
	public static Properties prop;

	public static WebDriver getDriver() throws IOException {
		FileInputStream fis = new FileInputStream(
				"G:\\KrishnaEclipseWorkspace\\Cucumber\\src\\main\\java\\Automation\\Cucumber\\global.properties");
		prop = new Properties();
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver", "G:\\KrishnaEclipseWorkspace\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		return driver;
	}

}
