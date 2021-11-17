package child;

import parent.Demo;

public  class ChildDemo extends Demo {
	
	ChildDemo get()
	 {
		System.out.println("sub class");
		return this;
		 
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Demo d= new Demo(); You cannot instantiate the abstract class.
//d.run();
	}
	/*
	public int run()
	{
		return 5;
	}
 
	*/
	
	/*public void shape()//cannot override the final methods
	 *
	{
		
	}*/

}
