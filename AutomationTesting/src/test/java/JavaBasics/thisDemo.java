package JavaBasics;

public class thisDemo {
	int a=5;//global variable.
	public void getData()
	{
		int a=6;//local variable.
		System.out.println(a);
		System.out.println(this.a);//"this.a" refers to 'a' value in the class level not in this method level.
		int c=a+this.a;
		System.out.println(c);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		thisDemo d=new thisDemo();
		d.getData();


	}

}
