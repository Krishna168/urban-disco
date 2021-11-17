package JavaBasics;

public class InterviewArrayMinNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b[][]= {{2,8,9},{4,5,8},{22,5,2}};
				int mincolumn = 0;
		//To find the smallest number in the array.
		int min=b[0][0];
		
		
		for(int i=0;i<3;i++)//rows
		{
			for(int j=0;j<3;j++)//columns.
			{
				if(b[i][j]<min)
				{
					min=b[i][j];
				   mincolumn = j;
				}
			}
		}
		int k=0;//here k is the row of the minimum column.
		int max=b[0][mincolumn];
		while(k<3)
		{
			if(b[k][mincolumn]>max)
			{
				max=b[k][mincolumn];
				
			}
			k++;
		}
		System.out.println(max);
		
		
	}

}
