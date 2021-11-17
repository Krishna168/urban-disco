package JavaBasics;

public class ArraysDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//One way of declaring the array where first allocating memory and assigning the values to array
		int a[]= new int[5];
		a[0]=2;
		a[1]=4;
		a[2]=9;
		a[3]=7;
		a[4]=5;
		
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		System.out.println("*********************************");
		//Most popular way of declaring the array where the memory of array will be allocated directly , here we are directly assigning the values to the array.
		int b[]= {8,9,6,2,4,5,7};
		for(int c:b)
			System.out.println(c);

		}
		
	}


