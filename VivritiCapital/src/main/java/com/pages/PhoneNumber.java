package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.TestBase;

public class PhoneNumber extends TestBase {

	@FindBy(xpath = "//div[text()='Get responses faster with SMS notifications.']")
	WebElement phoneNumberPageTitle;

	@FindBy(id = "PHONE_NUMBER")
	WebElement phoneNumberTextBox;

	public PhoneNumber() {
		PageFactory.initElements(driver, this);
	}

	public void phoneNumberPage() {
		if (phoneNumberPageTitle.isDisplayed()) {
			Assert.assertTrue(phoneNumberTextBox.isDisplayed());
		}
	}

}
