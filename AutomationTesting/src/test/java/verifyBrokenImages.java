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

public class verifyBrokenImages {


	private static int count;
	private static int count1;
	public static void main(String[] args) throws MalformedURLException, IOException {		
		
       WebDriverManager.chromedriver().version("84.0.4147.30").setup();
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
       driver.get("https://the-internet.herokuapp.com/broken_images");
       List<WebElement> images = driver.findElements(By.tagName("img"));
       System.out.println("There are " + images.size() + " images in this page");
       for(int i=0;i<images.size();i++)
       {
    	   WebElement ele = images.get(i);
    	   String linkurl = ele.getAttribute("src");
    	   verifyBrokenImage(linkurl);
       }
       System.out.println("There are " + count + " valid images present in this page");
       System.out.println("There are " + count1 + " broken images present in this page");
             
	}
	public static void verifyBrokenImage(String linkurl) throws IOException
	{
		
		URL url=new URL(linkurl);
		HttpURLConnection urlconnect = (HttpURLConnection) url.openConnection();
		urlconnect.setConnectTimeout(5000);
		urlconnect.setRequestMethod("GET");
		if(urlconnect.getResponseCode()==200)
		{
			System.out.println(linkurl + " is a valid image and the response is " + urlconnect.getResponseMessage());
			count++;
		}
		else
		{
			System.out.println(linkurl + " is a broken image and the response is " + urlconnect.getResponseMessage());
			count1++;
		}
		
		
		
	}

}
