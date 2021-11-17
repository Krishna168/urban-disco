package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage1 {
	
	
	public WebDriver driver;
	
	
	private By signin=By.cssSelector("a[href*='sign_in']");
	private By title=By.xpath("//div/h2");
	private By navBar=By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	private By header=By.cssSelector("div[class*='video-banner'] h3");
	private By popup=By.xpath("//button[text()='NO THANKS']");
	
	public LandingPage1(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getLogIn()
	{
		return driver.findElement(signin);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavigationBar()
	{
		return driver.findElement(navBar);
	}
	public int getPopUpSize()
	{
		return driver.findElements(popup).size();
	}
	public WebElement getPopUp()
	{
		return driver.findElement(popup);
	}
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}

}
