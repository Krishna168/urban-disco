
public class Multiply {
	// Print 5 multiplication table without using Multiply operator
	public static void main(String[] args) {
		int result = multiply(5,10);// 50
		System.out.println(result);
		int result1=multiply1(5,10);
		System.out.println(result1);
	}

	public static int multiply(int i, int j) {
		// Logic: i has to sum itself j times to get desired output
		int k = 0;
		int sum = 0;
		while (k < j) {
			sum = sum + i;
			k++;
		}
		return sum;

	}
	
	public static int multiply1(int a,int b)
	{
		int sum1 = 0;
		for(int i=0;i<b;i++)
			//a++;
		sum1=sum1+a;
		
		return sum1;
	}

}
