package JavaBasics;

public class childDemo extends parentDemo {
	String name="text";
	public childDemo()
	{
		super();//Whenever you use the parent constructor in the child constructor, make sure that the parent constructor is in the first line of the child constructor.
		System.out.println("Child Class Constructor");
	}

	public void getStringData()
	{
		System.out.println(name);
		System.out.println(super.name);
		
	}

	public void getData()
	{
		System.out.println("i am in the child class");
		super.getData();

	}
	//final void getTest()//final method from parentDemo class can't be overriden here
	{
		System.out.println("test");
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		childDemo cd = new childDemo();
		cd.getStringData();//Handling the child and parent variable
		cd.getData();//Handling the child and parent method.
		

	}

}
