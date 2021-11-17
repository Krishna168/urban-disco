package stepDefinitions;

import java.util.List;

import org.junit.Assert;

import Automation.Cucumber.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckOutPage;

public class StepDefinition extends Base {
	//public WebDriver driver;
	public CheckOutPage co;

	@Given("^The user is on the Netbanking landing page$")
	public void the_user_is_on_the_netbanking_landing_page() throws Throwable {
		System.out.println("Navigated to login page");
	}

	@Given("The user logs into the application with {string} and {string}")
	public void the_user_logs_into_the_application_with_and(String username, String password) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("The user logs into the application with username is " + username);
		System.out.println("The user logs into the application with password is " + password);
	}

	@Given("^HomePage should be displayed$")
	public void homepage_should_be_displayed() throws Throwable {
		System.out.println("HomePage is displayed");
	}

	@Given("Cards displayed are {string}")
	public void cards_displayed_are(String string) {
		System.out.println(string);
	}
	
	 @Given("^The user signs up with the following details$")
	    public void the_user_signs_up_with_the_following_details(DataTable data) throws Throwable {
		List<List<String>> obj= data.asLists();
		System.out.println(obj.get(0).get(0));
		System.out.println(obj.get(0).get(1));
		System.out.println(obj.get(0).get(2));
		System.out.println(obj.get(0).get(3));
		System.out.println(obj.get(0).get(4));
	     
	    }
	 @Given("^The user log into the application with (.+) and (.+)$")
	    public void the_user_log_into_the_application_with_and(String username, String password) throws Throwable {
	        System.out.println(username);
	        System.out.println(password);
	    }
	   @Given("^Chrome Browser should be opened$")
	    public void chrome_browser_should_be_opened() throws Throwable {
	        System.out.println("Chrome Browser is launched");
	    }

	    @When("^Navigate to the Application URl$")
	    public void navigate_to_the_application_url() throws Throwable {
	    	System.out.println("Navigated to the Application URL");
	    }

	    @Then("^Check the Application URL by verifying its title$")
	    public void check_the_application_url_by_verifying_its_title() throws Throwable {
	    	System.out.println("Verified the app URL by its title");
	    }
	    
	    @Then("^Verify selected \"([^\"]*)\" items are displayed in the checkout page$")
		public void verify_selected_something_items_are_displayed_in_the_checkout_page(String VegName) throws Throwable {
	    	
		}
	    
	    @Then("^Verify selected (.+) items are displayed in the checkout page$")
	    public void verify_selected_items_are_displayed_in_the_checkout_page(String VegName) throws Throwable {
	    	co=new CheckOutPage(driver);
			Assert.assertTrue(co.getproductAdded().getText().contains(VegName));
	    }



}