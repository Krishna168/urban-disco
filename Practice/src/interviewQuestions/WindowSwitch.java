package interviewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowSwitch {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().version("94.0.4606.61").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String parentWindowId = driver.getWindowHandle();
		driver.findElement(By.cssSelector("[src*='linkedin']")).click();
		driver.findElement(By.cssSelector("[src*='facebook']")).click();
		driver.findElement(By.cssSelector("[src*='twiter']")).click();
		driver.findElement(By.cssSelector("[src*='youtube']")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		Set<String> windowHandles = driver.getWindowHandles();
		//		for (String e:windowHandles )
		//		{
		//			System.out.println(e+"\n");
		//		}
		ArrayList<String> hList = new ArrayList<String> (windowHandles);

		switchToRightWindow("Facebook", hList);
		switchToParentWindow(driver,parentWindowId);
		closeAllWindows(driver, hList, parentWindowId);
	}
	public static boolean switchToRightWindow(String windowTitle, List<String> hList)
	{
		for(String e: hList)
		{
			String title = driver.switchTo().window(e).getTitle();
			if(title.contains(windowTitle))
			{
				System.out.println("Switched to the right window..." +windowTitle);
				return true;

			}
		}
		return false;

	}

	public static void switchToParentWindow(WebDriver driver,String parentWindowId )
	{
		driver.switchTo().window(parentWindowId);
	}

	public static void closeAllWindows(WebDriver driver, List<String> hList, String parentWindowId)
	{
		for(String e : hList)
		{
			if(!e.equals(parentWindowId))
			{
				driver.switchTo().window(e).close();
			}
		}
	}


}
