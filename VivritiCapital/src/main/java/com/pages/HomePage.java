package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.utils.CodeReusable;

public class HomePage extends TestBase {

	@FindBy(xpath = "//form[@class='hero__form'] //input[@name='postal_code_input']")
	WebElement location;

	@FindBy(css = ".button.button--branded.blue.go")
	WebElement go;

		public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void getHomePage(String locationValue) {
		location.clear();
		location.sendKeys(locationValue);
		location.sendKeys(Keys.ARROW_DOWN);
		go.click();
		CodeReusable.getNextButton().click();
		
	}

}
