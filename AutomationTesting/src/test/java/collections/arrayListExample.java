package collections;

import java.util.ArrayList;

public class arrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList a=new ArrayList();
		ArrayList b=new ArrayList(10);
		//b.add(1, "6");
		
		a.add("krishna");
		a.add(4);
		
		a.add("java");//adding the string "java" to the array list a
		a.add("java");
		System.out.println(a);
		a.add(1, "testing");//adding the string "testing" to the index position 1 in array list a
		System.out.println(a);
		/*a.remove(0);  //removing the value present at index 0 from array list a
		a.remove("java");  //removing the value "java" from the array list a.
		a.removeAll(a);  //removing all the values present in the arraylist a.
		System.out.println(a); */
		System.out.println(a.get(2));
		System.out.println(a.contains("testing"));
		System.out.println(a.contains("123"));
		a.set(1, "mava");
		a.add(2,"tava");
		System.out.println(a);
		System.out.println(a.indexOf("row"));
	
		System.out.println(a.size());
		System.out.println(a.isEmpty());
		System.out.println(b.size());
		
		
		
		
	}

}
