import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleSVG {
	//*[name()='svg']
	public static void main(String[] args) {
		WebDriverManager.chromedriver().version("84.0.4147.30").setup();
	       WebDriver driver=new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	       driver.get("http://debeissat.nicolas.free.fr/svg3d.php");
//	       WebElement reqd = driver.findElement(By.id("preamble"));
	       driver.switchTo().frame("svg_result");
	       
	       List<WebElement> eleList = driver.findElements(By.xpath("//*[name()='svg']//*[local-name()='g' and @id='g2']//*[local-name()='path' and contains(@id,'face')]"));
	       System.out.println(eleList.size());
	       while(true)
	       {
	       for(int i=0;i<eleList.size();i++)
	       {
	    	  String face= eleList.get(i).getAttribute("id");
	    	   String d=eleList.get(i).getAttribute("d");
	    	   System.out.println(face + d);
	    	   System.out.println();
	       }
	       }
	}

}
