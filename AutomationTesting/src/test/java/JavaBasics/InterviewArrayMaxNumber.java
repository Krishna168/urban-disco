package JavaBasics;

public class InterviewArrayMaxNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b[][]= {{2,8,20},{4,5,8},{9,5,1}};
		int max=b[0][0];
		int maxcolumn = 0;		

		//To find the largest number in the array.
		for(int i=0;i<3;i++)//rows
		{
			for(int j=0;j<3;j++)//columns.
			{
				if(b[i][j]>max)
				{
					max=b[i][j];
					maxcolumn=j;
				}
			}
		}
		//System.out.println(max);

		int min=b[0][maxcolumn];
		int k=0;
		while(k<3)
		{
			if(b[k][maxcolumn]<min)
			{
				min=b[k][maxcolumn];
			}
			k++;
		}

		System.out.println(min);
	}

}
