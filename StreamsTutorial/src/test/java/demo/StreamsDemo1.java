package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.testng.Assert;

public class StreamsDemo1 {



	public static void main(String[] args)
	{
		//regular();
		//streamFilter();
		streamMap();

	}
	/*
	public static int regular()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		int count=0;

		for (int i=0;i<names.size();i++)
		{
			String actual = names.get(i);
			if(actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
		return count;


	}
*/
	public static void streamFilter()
	{/*
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");

		long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
*/
		long d = Stream.of("Abhijeet","Don","Alekhya","Adam","Ram").filter(s->
		{
			return s.startsWith("D");			 
		}).count();
		System.out.println("The d value is "+d);
		
		//print names whose length is >4
		Stream.of("Abhijeet","Don","Alekhya","Adam","Ram").filter(s->s.length()>4).forEach(s->System.out.println(s));
		Stream.of("Abhijeet","Don","Alekhya","Adam","Ram").filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
		/*Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).filter(s->s.toUpperCase())
		.forEach(s->System.out.println(s));*/


	}
	
	public static void streamMap()
	{
		//Print names ending with letter "a" and convert that to the Uppercase.
		Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		//Print names starting with letter "A" with Sorted and lowercase
		String[] a ={"Azbhijeet","Don","Alekhya","Adam","Ram"};
		Arrays.asList(a).stream().filter(s->s.startsWith("A")).sorted().map(s->s.toLowerCase())
		.forEach(s->System.out.println(s));
		
		//Merge 2 ArrayLists into single and then sort and print
		System.out.println("*****Merging 2 array lists*********");
		ArrayList<String> names = new ArrayList<String>();
		names.add("man");
		names.add("Don");
		names.add("women");
		
		String[] b ={"Azbhijeet","Don","Alekhya","Adam","Ram"};
	List<String> bList=Arrays.asList(b); 
		
		Stream<String> newStream = Stream.concat(names.stream(), bList.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		
		//Check particular text present in the Stream and return boolean value
		System.out.println("*****Checking particular text in Stream*****");
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
		//Convert the end stream back to list 
		System.out.println("*******Converting stream back to list and perform operation******");
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("Abhijeet");
		list1.add("Don");
		list1.add("Alekhya");
		list1.add("Adam");
		list1.add("Rama");
		List<String> list2 = list1.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(list2.get(0));


		//Print Unique and Sorted numbers from the array
		System.out.println("*******Printing Unique and Sorted elements from the Array****");
		//int[] a2= {3,2,2,7,5,1,9,7};
		Arrays.asList(3,2,2,7,5,1,9,7).stream().distinct().sorted().forEach(s->System.out.println(s));
		
		
		//Get 3rd index from the sorted and unique array
		System.out.println("*********Get 3rd index from the sorted and unique array*********");
	List<Integer> setList = Arrays.asList(3,2,2,7,5,1,9,7).stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(setList.get(2));
		
		
		
		
		
		
		
		
		
	}
	
	
}




