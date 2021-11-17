package JavaBasics;

import java.util.LinkedList;

public class linkedListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l=new LinkedList();
		l.add("durga");
		l.add(30);
		l.add(null);
		l.add(null);
		l.add("durga");
		System.out.println(l);
		l.set(2, "Software");
		l.add(0,"venky");
		System.out.println(l);
		l.addFirst(1);
		System.out.println(l);
		l.addLast(10);
		System.out.println(l);
		System.out.println(l.getFirst());
		System.out.println(l.getLast());
		System.out.println(l.removeFirst());
		System.out.println(l);
		System.out.println(l.removeLast());
		System.out.println(l);
		System.out.println(l.size());
		l.clear();
		System.out.println(l);
		System.out.println(l.isEmpty());
	}

}
