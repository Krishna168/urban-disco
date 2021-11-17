package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Automation.Cucumber.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;

public class MyStepDefinitions {
	public WebDriver driver;
	public HomePage h;
	public CartPage c;
	public CheckOutPage co;

	@Given("^The user is on GreenKart Landing Page$")
	public void the_user_is_on_greenkart_landing_page() throws Throwable {
		driver = Base.getDriver();

	}

	@When("^The user searches for (.+) vegetable$")
	public void the_user_searches_for_something_vegetable(String VegName) throws Throwable {
		h = new HomePage(driver);
		h.getSearch().sendKeys(VegName);
		Thread.sleep(3000);

	}

	@Then("^Validate the (.+) search results are displayed$")
	public void validate_the_something_search_results_are_displayed(String VegName) throws Throwable {

		
		Assert.assertTrue(h.getproductSearchResults().getText().contains(VegName));

	}

	@And("^User adding the item to the cart$")
	public void user_adding_the_item_to_the_cart() throws Throwable {
		h.getIncrement().click();
		h.getaddToCart().click();
	}

	@And("^User proceeded to the checkout page for purchase$")
	public void user_proceeded_to_the_checkout_page_for_purchase() throws Throwable {
		h.getCartBag().click();
		c = new CartPage(driver);
		c.getProceedToCheckout().click();
		Thread.sleep(5000);
	}

}