import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sessionIdCloseAndQuit {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().version("95.0.4638.54").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		SessionId sessionId = ((RemoteWebDriver)driver).getSessionId();
		System.out.println("The Session id before closing "+sessionId);
		//driver.close();
		driver.quit();
		SessionId sessionId1 = ((RemoteWebDriver)driver).getSessionId();
		System.out.println("The Session id after closing "+sessionId1);
		
		
		

	}

}
