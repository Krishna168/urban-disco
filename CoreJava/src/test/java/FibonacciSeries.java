
public class FibonacciSeries {

	public static void main(String[] args) {
		// 0,1,1,2,3,5,8,13,21,34,55,89
		//0-a
		//1-b     //a
		//1-sum   //b     //a
				 //sum=2  //b      //a
		                  //sum=3  //b      //a
								   //sum=5  //b
		                                    //sum=8
		// fibonacci series using while loop
		int a=0;
		int b=1;
		System.out.println(a);
		System.out.println(b);
		int sum=0;
		int i=1;
		while(i<10)
		{
			sum=a+b;
			System.out.println(sum);
			a=b;
			b=sum;
			i++;
		}
		// fibonacci series using for loop
		int c=0;
		int d=1;
		int sum1=0;
		System.out.print(c);
		System.out.print("\t");
		System.out.print(d);
		System.out.print("\t");
		for(int j=1;j<16;j++)
		{
			sum1=c+d;
			System.out.print(sum1);
			System.out.print("\t");
			c=d;
			d=sum1;		
	}

}
}
