package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListSort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList l = new ArrayList();
		l.add("Z");
		l.add("A");
		l.add("K");
		l.add("N");
		System.out.println(l.contains("N"));

		l.set(3, "J");
		// l.add(null);
		// l.add(new Integer(10));

		System.out.println("Before Sorting:" + l);
		Collections.sort(l, new MyComparator());
		System.out.println("After Sorting:" + l);
		System.out.println(Collections.binarySearch(l, "A", new MyComparator()));
		System.out.println(Collections.binarySearch(l, "N"));//unpredicatable results because we are not passing the comparator object.
		System.out.println(Collections.binarySearch(l, "N", new MyComparator()));
		Comparator reverseOrder=Collections.reverseOrder(new MyComparator());
		System.out.println(reverseOrder);

	}

}

class MyComparator implements Comparator {

	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		String s1 = (String) o1;
		String s2 = o2.toString();
		return s2.compareTo(s1);
	}
}