package interviewQuestions;

import org.testng.annotations.Test;

public class EnabledVsAlwaysRun {

	@Test
	public void addToCartTest()
	{
		System.out.println("addToCartTest");
		int i=3/0;
	}
	
	@Test(enabled=true,alwaysRun = true,dependsOnMethods="addToCartTest")
	public void paymentTest()
	{
		System.out.println("paymentTest");
	}


}
