package JavaBasics;

public class multiDimensionalArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//One way of declaring the array where first allocating memory and assigning the values to array
		int a[][]=new int[2][3];
		a[0][0]=8;
		a[0][1]=9;
		a[0][2]=5;
		a[1][0]=5;
		a[1][1]=2;
		a[1][2]=3;
		System.out.println(a[1][1]);
		//Most popular way of declaring the array where the memory of array will be allocated directly , here we are directly assigning the values to the array.
		int b[][]= {{2,8,9},{4,5,8},{7,5,9}};
		//System.out.println(b[1][0]);
		for(int i=0;i<3;i++)//rows
		{
			for(int j=0;j<3;j++)//columns.
			{
				System.out.println(b[i][j]);
			}
		}
		


	}

}
