package com.tests.practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d= new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("M/dd/yyyy");
		System.out.println(sdf.format(d));
		SimpleDateFormat sd=new SimpleDateFormat("M-dd-yyyy");
		System.out.println(sd.format(d));
		SimpleDateFormat sdt=new SimpleDateFormat("dd-M-yyyy hh:mm:ss a Z");
		System.out.println(sdt.format(d));
		System.out.println(d.toString());
	}

}
