package com.tests.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandlingHTTPCertifications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creating desire chrome profile
		DesiredCapabilities ch = DesiredCapabilities.chrome();
		//ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
	

		//below is our local chrome browser
		ChromeOptions c = new ChromeOptions();
		// below here is merging the desired capabilties to our local chrome browser.
		c.merge(ch);




		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Krishna\\eclipse-workspace\\drivers\\chromedriver.exe");
		//passing desired capabilities from local chrome browser to chrome invoked.
		WebDriver driver = new ChromeDriver(c);
		driver.get("http://qaclickacademy.com/practice.php");
		
		
		
	}

}
