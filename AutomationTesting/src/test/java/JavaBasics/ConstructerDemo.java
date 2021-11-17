package JavaBasics;

public class ConstructerDemo {
	
	public ConstructerDemo() {
		System.out.println("I am in the default Constructor");
	}
	public ConstructerDemo(int a, int b) {
		System.out.println("I am in the parameterized Constructor");
		int c=a+b;
		System.out.println(c);
	}
	public ConstructerDemo(String str) {
		System.out.println(str);
	}
	
	public void getData()
	{
		System.out.println("I am the method");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConstructerDemo cd=new ConstructerDemo();
		ConstructerDemo c=new ConstructerDemo(2,3);
		ConstructerDemo d=new ConstructerDemo("Hello");
		

	}

}
