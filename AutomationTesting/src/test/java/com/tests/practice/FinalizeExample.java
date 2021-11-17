package com.tests.practice;

import org.apache.poi.util.SystemOutLogger;

public class FinalizeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalizeExample obj = new FinalizeExample();
		//Printing the hashcode
		System.out.println("The hashcode is "+obj.hashCode());
		obj=null;
//		System.out.println("The hashcode is "+obj.hashCode());
		//calling the garbage Collector
		System.gc();
		System.out.println("End of the garbage Collection");


	}
	protected void finalize()
	{
		System.out.println("Called the Finalize() method");
	}

}
