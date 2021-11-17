package collections;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList l= new ArrayList();
		l.add("Z");
		l.add("A");
		l.add("K");
		l.add("N");
		System.out.println("Before Sorting:" +l);
		Collections.sort(l);
		System.out.println("After Sorting:" +l);
		Collections.reverse(l);
		System.out.println("The reversed list is:" +l);
		System.out.println(Collections.binarySearch(l, "Z"));
		System.out.println(Collections.binarySearch(l, "B"));
	}

}
