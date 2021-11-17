package com.testdata;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	
	@DataProvider(name="GetData")
	public static Object[][] dataProviderMethod()
	{
		return new Object[][] {{"Chennai","Sample Text","5"}};
		
	}

}
