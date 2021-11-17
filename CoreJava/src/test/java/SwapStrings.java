
public class SwapStrings {

	public static void main(String[] args) {
		
		//Swap using temp variable
		String s1="Learn";
		String s2="Automation";
		String temp=null;
		temp=s1;
		s1=s2;
		s2=temp;
		System.out.println(s1);
		System.out.println(s2);
		
		String a="api";
		String b="automation";
		System.out.println("Strings before swapping: a is " + a + " and b is " + b);
		a=a+b;
		System.out.println(a);
		b=a.substring(0, (a.length()-b.length()));
		System.out.println(b);
		a=a.substring(b.length());
		System.out.println(a);
		System.out.println("Strings before swapping: a is " + a + " and b is " + b);
		
		

	}

}
