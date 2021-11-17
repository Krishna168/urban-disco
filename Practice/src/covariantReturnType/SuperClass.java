package covariantReturnType;

public class SuperClass {

	public SuperClass get()
	{
		System.out.println("Super Class");
		return this;
	}
	public static void main(String[] args) {
		
		SuperClass test1= new SubClass();
		test1.get();

	}

}
