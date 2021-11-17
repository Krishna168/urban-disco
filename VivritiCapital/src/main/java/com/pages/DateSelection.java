package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.utils.CodeReusable;

public class DateSelection extends TestBase {

	@FindBy(xpath = "//div[text()='On what date?']")
	WebElement dateSelectionPageTitle;

	@FindBy(xpath = "//td[contains(@class,'today')]")
	WebElement dateSelection;

	public DateSelection() {
		PageFactory.initElements(driver, this);
	}

	public void getDatePage() {
		if (dateSelectionPageTitle.isDisplayed()) {
			dateSelection.click();
			CodeReusable.getNextButton().click();
		}
	}

}
