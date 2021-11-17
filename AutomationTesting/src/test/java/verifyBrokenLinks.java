import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class verifyBrokenLinks {


	private static int count;
	private static int count1;
	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		
       WebDriverManager.chromedriver().version("84.0.4147.30").setup();
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
       driver.get("https://the-internet.herokuapp.com/");
       List<WebElement> links = driver.findElements(By.tagName("a"));
       System.out.println("There are " + links.size() + " links in this page");
       for(int i=0;i<links.size();i++)
       {
    	   WebElement ele = links.get(i);
    	   String linkurl = ele.getAttribute("href");
    	   verifylinks(linkurl);
       }
       System.out.println("There are " + count + "valid links present in this page");
       System.out.println("There are " + count1 + "broken links present in this page");
             
	}
	public static void verifylinks(String linkurl) throws IOException
	{
		
		URL url=new URL(linkurl);
		HttpURLConnection urlconnect = (HttpURLConnection) url.openConnection();
		urlconnect.setConnectTimeout(5000);
		urlconnect.connect();
		if(urlconnect.getResponseCode()==200)
		{
			System.out.println(linkurl + " is a valid link and the response is " + urlconnect.getResponseMessage());
			count++;
		}
		else
		{
			System.out.println(linkurl + " is a broken link and the response is " + urlconnect.getResponseMessage());
			count1++;
		}
		
		
		
	}

}
