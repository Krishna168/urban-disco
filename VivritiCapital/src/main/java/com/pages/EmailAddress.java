package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.TestBase;

public class EmailAddress extends TestBase {

	@FindBy(xpath = "//div[text()='Where would you like us to notify you about new quotes received on your request?']")
	WebElement emailAddressPageTitle;

	@FindBy(xpath = "//input[@placeholder='Email address']")
	WebElement emailAddressTextBox;

	/*
	 * @FindBy(xpath = "//button[text()='Next']") 
	 * WebElement nextInEmailPage;
	 */

	public EmailAddress() {
		PageFactory.initElements(driver, this);
	}

	public void emailAddressPage() {
		// SoftAssert sa=new SoftAssert();
		if (emailAddressPageTitle.isDisplayed()) {
			Assert.assertTrue(emailAddressTextBox.isDisplayed());
		}

	}

}
