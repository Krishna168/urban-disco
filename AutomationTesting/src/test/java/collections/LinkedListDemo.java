package collections;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l= new LinkedList();
		l.add("durga");
		l.add(30);
		l.add(null);
		l.add("durga");
		System.out.println(l);
		l.set(0, "Software");
		System.out.println(l);
		l.add(0, "venky");
		System.out.println(l);
		l.addFirst("first");
		System.out.println(l);
		System.out.println(l.getFirst());
		l.addLast("last");
		System.out.println(l.getLast());
		System.out.println(l.removeFirst());
		System.out.println(l.removeLast());
	}

}
