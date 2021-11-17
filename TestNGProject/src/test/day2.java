package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2 {

	@Test(groups= {"Smoke"})
	public void ploan() {
		System.out.println("day2test");
	}
	@BeforeTest
	public void prerequisite() {
		System.out.println("I will execute first");
	}

	}
