package javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamTest {

	//@Test
	public void regular() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Abhijeet");
		al.add("Don");
		al.add("Alekhya");
		al.add("Adam");
		al.add("Ram");
		int count = 0;
		for (int i = 0; i < al.size(); i++) {
			String actual = al.get(i);
			if (actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);

	}

	//@Test
	public void StreamFilter() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Abhijeet");
		al.add("Don");
		al.add("Alekhya");
		al.add("Adam");
		al.add("Ram");

		Long c = al.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);
		
		Long d=Stream.of("Abhijeet","Don","Alekhya","Adam","Ram").filter(s->
		{
			s.startsWith("D");
			return true;
		}).count();
		System.out.println(d);
		
		//print all the results from the list
		Stream.of("Abhijeet","Don","Alekhya","Adam","Ram").forEach(s->System.out.println(s));
		
		//print the results if length > 4
    	al.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		//print ony the first item inthe arraylist
		al.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
	}



//	@Test
	public void StreamMap()
	{
		
		//print list of name whose length>4 in uppercase
		Stream.of("Abhijeet","Don","Alekhya","Adam","Ram").filter(s->s.length()>4)
		.forEach(s->System.out.println(s.toUpperCase()));
		
		//print list of names endswith letter 'a' in uppercase
		Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
				
		//print names in array which startswith 'a' in sorted order and in uppercase
		String[] a= {"Abhijeet","Don","Alekhya","Adam","Rama"};
		Arrays.asList(a).stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Merge two arraylist items into single list and perform sorting order.
		System.out.println("Merging 2 arraylist into one and performing sorting");
		ArrayList<String> ad = new ArrayList<String>();
		ad.add("man");
		ad.add("women");
		ad.add("Don");
		ArrayList<String> af = new ArrayList<String>();
		af.add("Abhijeet");
		af.add("Don");
		af.add("Alekhya");
		af.add("Adam");
		af.add("Rama");
		Stream<String> newStream=Stream.concat(ad.stream(), af.stream());
		newStream.sorted().forEach(s->System.out.println(s));
		
		//verifying the present of element in the stream
		System.out.println("Verifying the element present");
		Stream<String> ofStream = Stream.of("Abhijeet","Don","Alekhya","Adam","Rama");
		boolean flag = ofStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag); 
		
	}
	
	@Test
	public void Collectors()
	{
		
		System.out.println("Collectors");
		List<String> l = Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(l.get(0));
		
		//Printing only unique numbers.
		Integer[] aw= {3,2,2,7,5,1,9,7};
		Arrays.asList(aw).stream().distinct().forEach(d->System.out.println(d));
		
		//Printing in sorted order and unique numbers
		System.out.println("sorted order");
		Arrays.asList(aw).stream().sorted().distinct().forEach(d->System.out.println(d));
		
		//Print in reverse order
		System.out.println("reverse order");
		//Arrays.asList(aw).stream().sorted(new MyComparator()).distinct().forEach(d->System.out.println(d));
		List<Integer> c1 = Arrays.asList(aw).stream().sorted().distinct().collect(Collectors.toList());
		Collections.reverse(c1);
		System.out.println(c1);
		System.out.println(c1.get(3));
	}

	
	
	
	

}
 class MyComparator implements Comparator
{

	@Override
	public int compare(Object o1, Object o2) {

			Integer I1=(Integer)o1;
			Integer I2=(Integer)o2;
		return I2.compareTo(I1);
	}
	}
