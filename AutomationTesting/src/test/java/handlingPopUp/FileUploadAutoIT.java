package handlingPopUp;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadAutoIT {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		String downloadPath = System.getProperty("user.dir");
		System.out.println(downloadPath);
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		System.setProperty("webdriver.chrome.driver", "G:\\KrishnaEclipseWorkspace\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.ilovepdf.com/pdf_to_word");
		driver.findElement(By.xpath("//span[text()='Select PDF file']")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("G:\\FileUploadAutoIT\\FileUpload.exe");
		WebDriverWait w = new WebDriverWait(driver, 15);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTask")));
		driver.findElement(By.id("processTask")).click();
		WebDriverWait y = new WebDriverWait(driver, 60);
		y.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='pickfiles']")));
		driver.findElement(By.xpath("//a[@id='pickfiles']")).click();
		Thread.sleep(5000);
		File f = new File(downloadPath + "/Krishna_Resume_v1.docx");
		if (f.exists()) {
			System.out.println("file exists");
			if (f.delete())
				System.out.println("file is deleted");
		}

	}

}
