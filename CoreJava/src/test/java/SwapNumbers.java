
public class SwapNumbers {

	public static void main(String[] args) {

		// Swap using temporary variable
		int a = 4;
		int b = 5;
		int temp;
		temp = a;
		a = b;
		b = temp;
		System.out.println(a);
		System.out.println(b);

		// Swap without using temporary variable
		int c = 3;
		int d = 4;
		c = c + d;//c=3+4=7
		d = c - d;//d=7-4=3
		c = c - d;//c=7-3=4;
		System.out.println(c);
		System.out.println(d);

	}

}
