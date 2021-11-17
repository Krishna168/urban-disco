import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().version("84.0.4147.30").setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
	       WebDriver driver=new ChromeDriver(options);
		File f=new File("G:\\KrishnaEclipseWorkspace\\AutomationTesting\\src\\main\\resources\\Global.properties");
		FileInputStream fis=new FileInputStream(f);
		Properties prop=new Properties();
		prop.load(fis);
		driver.get(prop.getProperty("url"));
		FileOutputStream fos=new FileOutputStream(f);
		prop.setProperty("Title", driver.getTitle());
		prop.store(fos, null);
		driver.close();
		
	}

}
