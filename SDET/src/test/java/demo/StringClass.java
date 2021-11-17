package demo;

public class StringClass {

	public static void main(String[] args) {

		
		//String are immutable
		String a = "hello"; // String literal declaration
		String b = "hello";// here in string literal, it wont create new object as b instead it will point to a if the hello is already present in the pool
		String c=a.concat("world");//storing the changed string value in another object c
		System.out.println(c);//printing the changed string value object c
		String s=new String("hello");
		String s1=new String("hello");
		
		System.out.println(a.equals(b));//true because both a and b are having the same content as hello
		System.out.println(a==b);//true because a and b are pointing to the same hello
		System.out.println(s.equals(s1));//true because both s and s1 are having the same content as hello
		System.out.println(s==s1);//false because s and s1 are pointing to the different hello
		System.out.println(a.equals(s));//true because both a and s are having the same content as hello
		System.out.println(a==s);//false because a and s are pointing to the different hello
		
		System.out.println(a.equalsIgnoreCase(s));
		//String Buffer and String Builder are mutable
		//StringBuffer is synchronised and thread safe
		//Since,StringBuffer is synchronised, it is comparatively slower than stringbuilder.
		StringBuffer sb=new StringBuffer("hello");
		sb.append("world");
		System.out.println(sb);//helloworld
		sb.insert(2,"she");
		System.out.println(sb);//heshelloworld
		sb.replace(5, 7, "aa");//This will replace the char at 5 and 6 with aa. i.e., 7 is endpoint and it wont touch that
		System.out.println(sb);//hesheaaoworld
		sb.deleteCharAt(12);
		System.out.println(sb);//hesheaaoworl
		sb.reverse();
		System.out.println(sb);//lrowoaaehseh
		
		StringBuilder sbb=new StringBuilder("hello");
		//StringBuilder has all the same methods in stringbuffer.
		//StringBuilder is non-synchronised and not thread safe
		//Since,StringBuilder is non-synchronised, it is comparatively faster than stringbuffer.
	}

}
