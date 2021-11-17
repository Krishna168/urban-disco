package Academy1;

import java.io.IOException;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage1;
import pageObjects.LoginPage1;
import resources.Base1;

public class homePage extends Base1 {
	//private static Logger log=LogManager.getLogger(Base1.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		//log.info("driver is initialized");
		
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Email, String Password, String text) throws IOException

	{
		driver.get(prop.getProperty("url"));
		//log.info("navigated to the qaclickacademy website");
		LandingPage1 l = new LandingPage1(driver);
		l.getLogIn().click();
		LoginPage1 lp = new LoginPage1(driver);
		lp.getEmail().sendKeys(Email);
		//log.info("email id field is entered");
		lp.getPassword().sendKeys(Password);
		//log.info("Password field is entered");	
		System.out.println(text);
		//log.info("text field is printed successfully");
		lp.getLogIn().click();
		//log.info("Login button is clicked successfully");

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "NonRestrictedUser@gmail.com";
		data[0][1] = "12345";
		data[0][2] = "Non Restricted User";
		data[1][0] = "RestrictedUser@gmail.com";
		data[1][1] = "67890";
		data[1][2] = "Restricted User";
		return data;
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;

	}

}
