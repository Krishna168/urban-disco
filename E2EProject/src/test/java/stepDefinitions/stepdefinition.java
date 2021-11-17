package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage1;
import pageObjects.LoginPage1;
import pageObjects.portalHomePage;
import resources.Base1;

public class stepdefinition extends Base1 {

	@Given("^Initialize the browser with chrome\\.$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" Site\\.$")
	public void navigate_to_Site(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	@Given("^Click on Login link in home page to land on secure sign in page\\.$")
	public void click_on_Login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		LandingPage1 l = new LandingPage1(driver);
		if (l.getPopUpSize()>0) {
			l.getPopUp().click();
		}
		l.getLogIn().click();
	}

	@When("^User enters (.+) and (.+) and logs in.$")
	public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage1 lp = new LoginPage1(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogIn().click();
	}

	@Then("^Verify that user is successfully logged in\\.$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		portalHomePage s = new portalHomePage(driver);
		Assert.assertTrue(s.getSearchBox().isDisplayed());

	}
	@And("^Close the browsers\\.$")
    public void close_the_browsers() throws Throwable {
        driver.quit();
    }


}