package com.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.DateSelection;
import com.pages.EmailOrPhoneNumber;
import com.pages.HomePage;
import com.pages.NeedPage;
import com.pages.PlumberAddInfo;
import com.pages.PlumbingHelpTime;
import com.pages.ProblemDescription;
import com.pages.ProblemItem;
import com.pages.TimeSelection;
import com.testdata.DataProviderClass;

public class StarOfService extends TestBase {

	@Test(dataProvider = "GetData", dataProviderClass = DataProviderClass.class)
	public void test(String location, String text,String howLongValue) throws IOException {

		initialization();

		HomePage homepage = new HomePage();
		ProblemItem problemItem = new ProblemItem();
		NeedPage needPage = new NeedPage();
		ProblemDescription problemDescription = new ProblemDescription();
		PlumberAddInfo plumberAddInfo = new PlumberAddInfo();
		PlumbingHelpTime plumberHelpTime = new PlumbingHelpTime();
		DateSelection dateSelection = new DateSelection();
		TimeSelection timeSelection = new TimeSelection();
		EmailOrPhoneNumber emailOrPhoneNumber = new EmailOrPhoneNumber();

		homepage.getHomePage(location);

		for (int i = 0; i < 10; i++) {

			String page = driver.findElement(By.xpath("//*[@class='v2__title___1Covm v2__commonFormTitle___3kSbd'] | //div[@class='styles__titleV2___15cVd styles__titleBase___JOpQ3']"))
					.getText();

			switch (page) {

			case "The problems are to do with which of the following things?": {
				problemItem.getproblemsFacingItems();
				break;
			}

			case "What do you need done?": {
				needPage.getNeedPageItems();
				break;
			}

			case "What problem(s) do you have?": {
				problemDescription.getProblemDescription();
				break;
			}

			case "Is there anything else that the Plumber needs to know?": {
				plumberAddInfo.getplumberAdditionalInfoPage(text);
				break;
			}

			case "When do you require plumbing?": {
				plumberHelpTime.geTimeOfPlumbingPage();
				break;
			}

			case "On what date?": {
				dateSelection.getDatePage();
				break;
			}

			case "What time do you need the Plumber?" :{
				timeSelection.getTimePage(howLongValue);
				break;
			}

			case "Get responses faster with SMS notifications.": {
				emailOrPhoneNumber.getEmailOrPhoneNumberField();
				break;
			}


			}

		}
	}

}
