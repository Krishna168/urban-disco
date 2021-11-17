package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.TestBase;

public class CodeReusable extends TestBase{
	
	public static WebElement getNextButton()
	{
		WebElement next= driver.findElement(By.xpath("//button[@data-test='next_button']"));
		return next;		
		
	}

}
