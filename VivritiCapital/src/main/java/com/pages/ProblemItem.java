package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.utils.CodeReusable;

public class ProblemItem extends TestBase {

	@FindBy(xpath = "//div[text()='The problems are to do with which of the following things?']")
	WebElement problemItemsPageTitle;

	@FindBy(xpath = "//div[text()='Tap']/parent::label/div/div")
	WebElement tap;

	public ProblemItem() {
		PageFactory.initElements(driver, this);
	}

	public void getproblemsFacingItems() {
		if (problemItemsPageTitle.isDisplayed()) {
			tap.click();
			CodeReusable.getNextButton().click();
		}

	}

}
