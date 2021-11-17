package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class DemoTest3 
{
    
    @Test
    public void sum()
    {
    	System.out.println("SUM");
        int a=10;
        int b=20;
        Assert.assertEquals(a+b, 30);
    }
    
    @Test
    public void subtract()
    {
    	System.out.println("SUBTRACT");
        int a=10;
        int b=20;
        Assert.assertEquals(b-a, 10);
    }
    
    @Test
    public void multiply()
    {
    	System.out.println("MULTIPLY");
        int a=10;
        int b=20;
        Assert.assertEquals(a*b, 200);
    }
    
    @Test
    public void division()
    {
    	System.out.println("DIVISION");
        int a=10;
        int b=20;
        Assert.assertEquals(b/a, 2);
    }
}
