package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base1 {
	public  WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("G:\\KrishnaEclipseWorkspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		//System.getProperty("user.dir") - Need to check this later 
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		//String browserName=System.getProperty("browser");
		System.out.println(browserName);
		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"G:\\KrishnaEclipseWorkspace\\drivers\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		} 
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"G:\\KrishnaEclipseWorkspace\\drivers\\geckodriver.exe");			
			driver = new FirefoxDriver();

		} 
		else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					"G:\\KrishnaEclipseWorkspace\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
	public void getScreenshot(String result) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File desc=new File("./Screenshots/"+result+"screenshot.png");
		FileUtils.copyFile(src,desc);
	}

}
