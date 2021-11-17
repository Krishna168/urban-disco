package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.cssSelector("input.search-keyword");
	By increment = By.cssSelector("a.increment");
	By addToCart = By.xpath("//button[text()='ADD TO CART']");
	By cartBag=By.xpath("//img[@alt='Cart']");
	By productSearchResults=By.cssSelector("h4.product-name");
	public WebElement getSearch() {
		return driver.findElement(search);
	}

	public WebElement getIncrement() {
		return driver.findElement(increment);
	}

	public WebElement getaddToCart() {
		return driver.findElement(addToCart);
	}
	
	public WebElement getCartBag()
	{
		return driver.findElement(cartBag);
	}
	public WebElement getproductSearchResults()
	{
		return driver.findElement(productSearchResults);
	}
	}
	


