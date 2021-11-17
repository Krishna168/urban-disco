package annotation;

public class ThisConstructor {
	ThisConstructor() {
		System.out.println("hello a");
	}

	ThisConstructor(int x) {
		this();
		System.out.println(x);
	}
	
	public static void main(String args[]) {
		ThisConstructor a = new ThisConstructor(10);
	}
}

