import java.util.ArrayList;

public class CompareArray {

	public static void main(String[] args) {
		int a[] = { 1, 4, 5, 7 };
		int b[] = { 6, 4, 3, 7 };
//		int ab[] = new int[4];
		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++) {
			if (a[i] == b[i]) {
				al.add(b[i]);
			}
		}
		System.out.println(al);
		Object[] c = al.toArray();
		for (Object c1 : c) {
			System.out.println(c1);
		}
		

	}

}
