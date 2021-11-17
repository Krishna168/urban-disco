
public class PrimeNumber {

	public static void main(String[] args) {
		// 41%i==0 ----->not prime number
		//41%i!=0 ------>prime number		
		System.out.println(PrimeNumber.checkPrimeNumber(42));		
	}
	
	public static String checkPrimeNumber(int val)
	{
		boolean flag=false;
		for(int i=2;i<=val/2;i++)//it is enough to check till the half of the given number 
		{
			if(val%i==0)
			{
				flag=true;
				break;
				
			}
		}
		if(flag)
			 return "it is not a prime number";
		else
			return "it is a prime number";
		

	}
}
