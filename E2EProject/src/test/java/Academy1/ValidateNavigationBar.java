package Academy1;

import java.io.IOException;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage1;
import resources.Base1;

public class ValidateNavigationBar extends Base1 {
	//private static Logger log=LogManager.getLogger(Base1.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		//log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		//log.info("navigated to the qaclickacademy website");
	}

	@Test
	public void ValidateAppNavBar() throws IOException {
		LandingPage1 l = new LandingPage1(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
				//log.info("Navigation Bar validation is successful");
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;

	}

}
