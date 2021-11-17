package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.TestBase;

public class EmailOrPhoneNumber extends TestBase {

	By phoneNumberPageTitle = By.xpath("//div[text()='Get responses faster with SMS notifications.']");

	@FindBy(id = "PHONE_NUMBER")
	WebElement phoneNumberTextBox;

	By emailAddressPageTitle = By
			.xpath("//div[text()='Where would you like us to notify you about new quotes received on your request?']");

	@FindBy(xpath = "//input[@placeholder='Email address']")
	WebElement emailAddressTextBox;

	public EmailOrPhoneNumber() {
		PageFactory.initElements(driver, this);
	}

	public void getEmailOrPhoneNumberField() {

		if (isElementPresent(phoneNumberPageTitle)) {
			Assert.assertTrue(phoneNumberTextBox.isDisplayed());
		} else if (isElementPresent(emailAddressPageTitle)) {

			Assert.assertTrue(emailAddressTextBox.isDisplayed());

		}

		else {
			System.out.println("Either Phone Number or Email is not present");
		}

	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

}
