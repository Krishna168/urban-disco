package JavaBasics;

import java.util.ArrayList;

public class FindDuplicateElementinString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="Madam";
		ArrayList<String> a=new ArrayList<String>();
		for (int i=0;i<str.length();i++)
		{
			for(int j=i+1;j<str.length();j++)
			{
				if(i==j)
				{
				//a.add(Integer.toString(i));
					a.add(String.valueOf(i));
				System.out.println(a);
				}
				
			}
			
		}
		
	}
	
}
