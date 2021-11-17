package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day11 {

	@AfterTest
	public void lastexecution() {
		System.out.println("I will execute in the last");
	}
	@Parameters({"URL"})
	@Test(groups= {"Smoke"})
	public void Demo(String urlname) {
		System.out.println("test");
		System.out.println(urlname);
	}

	@AfterSuite
	public void afsuite()
	{
		System.out.println("i am no.1 from last");
	}

	@Test
	public void SecondTest() {
		System.out.println("bye");

	}
}
