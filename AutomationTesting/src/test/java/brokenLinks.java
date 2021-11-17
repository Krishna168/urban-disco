import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class brokenLinks {


	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		String url="";
       HttpURLConnection huc=null;
       int responseCode,count=0;
       WebDriverManager.chromedriver().version("84.0.4147.30").setup();
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
       driver.get("https://www.google.co.in/");
       List<WebElement> links = driver.findElements(By.tagName("a"));
       System.out.println(links.size());
       Iterator<WebElement> it = links.iterator();
       while(it.hasNext())
       {
    	   url = it.next().getAttribute("href");
    	   huc=(HttpURLConnection)(new URL(url).openConnection());
    	   huc.connect();
    	   responseCode=huc.getResponseCode();
    	   if(responseCode>=400)
    	   {
    		   System.out.println(url + " is a broken link");
    		   count++;
    		  
    	   }
    	   else
    	   {
    		   System.out.println(url + " is a valid link");
    	   }
    	   
       }
       System.out.println("There are " + count + "broken links in this web page");
       
	}

}
