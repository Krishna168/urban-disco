package covariantReturnType;

public class SubClass extends SuperClass{
	
	public SubClass get()
	{
		System.out.println("Sub Class");
		return this;
	}

	public static void main(String[] args) {
				
		SuperClass test1= new SubClass();
		test1.get();

	}

}
