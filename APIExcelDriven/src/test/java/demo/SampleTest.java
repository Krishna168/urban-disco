package demo;

import java.io.IOException;
import java.util.ArrayList;

public class SampleTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataDriven d= new DataDriven();
		ArrayList h=d.getData("Purchase");
		System.out.println(h.get(0));
		System.out.println(h.get(1));
		System.out.println(h.get(2));
		System.out.println(h.get(3));
	}

}
