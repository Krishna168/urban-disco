package collections;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 10, 5, 20, 11, 6 };
		System.out.println("Primitive Array before sorting is");
		for (int a1 : a) {
			System.out.println(a1);
		}
		Arrays.sort(a);
		System.out.println("Primitive Array After sorting is");
		for (int a2 : a) {
			System.out.println(a2);
		}

		String[] b = { "A", "Z", "B" };
		System.out.println("Object Array before sorting is");
		for (String b1 : b) {
			System.out.println(b1);
		}
		Arrays.sort(b);
		System.out.println("Object Array After sorting is");
		for (String b2 : b) {
			System.out.println(b2);
		}

		Arrays.sort(b, new MyComparator());
		System.out.println("Object Array After sorting by Comparator is:");
		for (String c2 : b) {
			System.out.println(c2);
		}

	}

}

class MyComparator implements Comparator {

	public int compare(Object o1, Object o2) {
		String s1 = (String) o1;
		String s2 = (String) o2;
		return s2.compareTo(s1);
	}

}
