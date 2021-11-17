
public class PyramidDisplay {

	public static void main(String[] args) {
//		*
//		* *
//		* * *
//		* * * *
		
//		Program for printing the pyramind pattern in java
//		System.out.println("*");
		
		for(int i=1;i<5;i++)//Outer for loop for controlling the number of rows
		{
			for(int j=1;j<=i;j++) //inner loop for controlling number of columns in a row
			{
				System.out.print("*");
				System.out.print("\t"); //to press 'tab' after each character
			}
			System.out.println(); //To insert new line after each outer 'for' loop 
		}
		for(int i=1;i<5;i++)
		{
			for(int j=4;j>=i;j--)
			{
				System.out.print("*");
				System.out.print("\t"); //to press 'tab' after each character
			}
			System.out.println(); //To insert new line after each outer 'for' loop 

		}
		

	}

}
