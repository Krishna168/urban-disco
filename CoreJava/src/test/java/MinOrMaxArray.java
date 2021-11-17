
public class MinOrMaxArray {

	public static void main(String[] args) {
	
		int abc[][]= {{2,4,5},{3,4,7},{1,2,9}};
		int min=abc[0][0];
				
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(abc[i][j]<min)
				{
					min=abc[i][j];
				}
			}
		}
		System.out.println(min);
	
		
		int def[][]={{2,4,5},{3,4,7},{1,2,9}};
		int max=def[0][0];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(def[i][j]>max)
				{
					max=def[i][j];
				}
			}
		}
		System.out.println(max);

	}

}
