package parent;

public class Demo {
	private int a=5;

	public String run() {
		
		//System.out.println("string");
		return "string";
	}
	
	public final void shape()
	{
		System.out.println("shapping");
	}
	private void trim()
	{
		
	}
	
	Demo get()
	{
		System.out.println("super class");
		return this;
		
	}

}
