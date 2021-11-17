package Academy1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage1;
import resources.Base1;

//import org.apache.logging.log4j.*;

public class TitleValidation extends Base1 {
	// private static Logger log=LogManager.getLogger(Base1.class.getName());
	LandingPage1 l;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		// log.info("Chromedriver is initialized");

		driver.get(prop.getProperty("url"));
		// log.info("Navigated to qaclickacademy");
	}

	@Test()
	public void ValidateAppTitle() throws IOException

	{
		l = new LandingPage1(driver);
		// l.getTitle().getText().equalsIgnoreCase("FEATURED COURSES")
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		// log.info("Featured Courses title displayed successfully");

	}

	@Test()
	public void ValidateHeader() throws IOException

	{

		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");

	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;

	}

}
