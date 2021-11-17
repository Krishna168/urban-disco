package test;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	
	
	public  void onTestSuccess(ITestResult result) {
	    // not implemented
		System.out.println("I successfull executed listeners pass code.");
	  }
	@Override
	public  void onTestFailure(ITestResult result) {
	    // not implemented
		//Screenshot code if test case is failed.
		
		System.out.println("I executed because test case is failed " +result.getName());
	  }

	
	 

}
