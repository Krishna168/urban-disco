package sauceLabsTesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

public class sauceLabsTesting {
	public static final String USERNAME = "krishna16895";
	public static final String ACCESS_KEY = "726ae9f4-c3fe-41fb-b75f-13aa7562ab6f";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("screenResolution", "1024x768");

		SafariOptions browserOptions = new SafariOptions();
		browserOptions.setCapability("platformName", "macOS 10.15");
		browserOptions.setCapability("browserVersion", "13.0");
		browserOptions.setCapability("sauce:options", sauceOptions);
		
	
		WebDriver driver = new RemoteWebDriver(new URL(URL), browserOptions);
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		driver.close();

	}

}
