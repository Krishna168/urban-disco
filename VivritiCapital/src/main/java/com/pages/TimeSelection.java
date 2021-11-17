package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.TestBase;
import com.utils.CodeReusable;

public class TimeSelection extends TestBase {

	@FindBy(xpath = "//div[text()='What time do you need the Plumber?']")
	WebElement timeSelectionPageTitle;

	@FindBy(xpath = "//label[text()='At what time?']/following-sibling::div/select")
	WebElement timeSelectionDropdown;

	@FindBy(xpath = "//label[text()='For how long?']/following-sibling::input")
	WebElement howLong;



	public TimeSelection() {
		PageFactory.initElements(driver, this);
	}

	public void getTimePage(String howLongvalue) {
		if (timeSelectionPageTitle.isDisplayed()) {
			Select s = new Select(timeSelectionDropdown);
			java.util.List<WebElement> timeValues=s.getOptions();			
			s.selectByVisibleText(timeValues.get(1).getText());			
			howLong.sendKeys(howLongvalue);
			CodeReusable.getNextButton().click();
		}
	}

}
