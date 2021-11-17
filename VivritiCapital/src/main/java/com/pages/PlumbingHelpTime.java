package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.utils.CodeReusable;

public class PlumbingHelpTime extends TestBase {

	@FindBy(xpath = "//div[text()='When do you require plumbing?']")
	WebElement plumbingHelpTimePageTitle;

	@FindBy(xpath = "//div[text()='On a specific date']/preceding-sibling::div")
	WebElement onaSpecificDate;

	public PlumbingHelpTime() {
		PageFactory.initElements(driver, this);
	}

	public void geTimeOfPlumbingPage() {
		if (plumbingHelpTimePageTitle.isDisplayed()) {
			onaSpecificDate.click();
			CodeReusable.getNextButton().click();
		}
	}

}
