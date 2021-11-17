import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.network.Network;
import org.openqa.selenium.devtools.v95.network.model.ConnectionType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EmulateNetworkSpeed {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().browserVersion("95.0.4638.54").setup();
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(true, 3000, 10000, 15000, Optional.of(ConnectionType.WIFI)));
		devTools.addListener(Network.loadingFailed(), loadingFailed->
		{
			System.out.println(loadingFailed.getBlockedReason());
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
			
		});
		long startTime = System.currentTimeMillis();
		driver.get("https://google.com");
		driver.findElement(By.cssSelector("[name='q']")).sendKeys("netflix",Keys.ENTER);
		driver.findElements(By.cssSelector("[class*='LC20lb']")).get(0).click();
		System.out.println(driver.findElement(By.xpath("(//h1[@class='our-story-card-title'])[1]")).getText());
		//		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		//		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		Thread.sleep(3000);
		driver.close();
		//with Emulation -233210
		//Without Emulation -5855 


	}

}
