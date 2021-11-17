import java.util.ArrayList;
import java.util.Collections;

public class sortArrayDemo {

	public static void main(String[] args) {
		//Sorting in ascending order
		int[] a = { 2, 6, 1, 4, 9 };
		int temp = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		for (int x : a) {
			System.out.println(x);
		}
		//Sorting in descending order
		int[] b = { 2, 6, 1, 4, 9 };
		int temp1 = 0;

		for (int i = 0; i < b.length; i++) {
			for (int j = i + 1; j < b.length; j++) {
				if (b[i] < b[j]) {
					temp1 = b[i];
					b[i] = b[j];
					b[j] = temp1;
				}
			}
		}
		for (int x : b) {
			System.out.println(x);
		}
		
		//
		
		
		//Sorting by using Arraylist in ascending and descending order
		ArrayList<Integer> ab=new ArrayList<Integer>();
		ab.add(2);
		ab.add(6);
		ab.add(1);
		ab.add(4);
		ab.add(9);
		Collections.sort(ab);
		System.out.println(ab);
		Collections.reverse(ab);
		System.out.println(ab);
	}
}
