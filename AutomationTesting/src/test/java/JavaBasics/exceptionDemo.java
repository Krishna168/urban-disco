package JavaBasics;

public class exceptionDemo {
	static int a=5;
	static int b=4;
	static int c=0;

	/*
	public void getData()
	{
		System.out.println(k);
	}
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//exceptionDemo ed = new exceptionDemo();
		//ed.getData();

		try
		{
			//int k=b/c;
			int arr[]=new int[6];
			System.out.println(arr[8]);
		}
		catch(ArithmeticException ed)//This catch will handle only Arithmetic Exception
		{
			System.out.println("I catched the arithmetic Exception");
		}
		catch(IndexOutOfBoundsException eds)//This catch will handle only Arithmetic Exception
		{
			System.out.println("I catched the IndexOutofBound Exception");
		}
		catch(Exception e)//This is a general Exception, it can handle all types of exceptions.
		{
			System.out.println("I catched the Exception");
		}
		finally
		{
			System.out.println("delete all cookies before next test cases execution");
		}

	}

}
