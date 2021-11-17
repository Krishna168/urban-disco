
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String a="java is a programming language";
		String a="madam";
		String b="";
		for(int i=a.length()-1;i>=0;i--)
		{
		       b=b+a.charAt(i);			
		}
		System.out.println(b);
		if(a.equalsIgnoreCase(b))
			System.out.println("it is a palindrome");
		else
			System.out.println("it is not a palindrome");
		}

}
