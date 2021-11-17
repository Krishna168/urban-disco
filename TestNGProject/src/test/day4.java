package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class day4 {
	@Test(groups= {"Smoke"})
	public void WebLoginHomeLoan()
	{
		System.out.println("webloginHome");
	}
	@Test
	public void MobileLoginHomeLoan()
	{
		System.out.println("MobileloginHome");
		Assert.assertTrue(false);
	}
	@Test
	public void LoginAPIHomeLoan()
	{
		System.out.println("APIloginHome");
	}


}
