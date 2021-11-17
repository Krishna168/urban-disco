
public class AdjacentArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,4,8,15,17};
		int b[]= {-2,-1,-3,-4,-5};
		int maxdiff=0;
		int mindiff=0;
		
		for(int i=0;i<a.length-1;i++)
		{
			if(a[i+1]-a[i]>maxdiff)
			{
				maxdiff=a[i+1]-a[i];
			}
		}
		System.out.println(maxdiff);
		for(int i=0;i<b.length-1;i++)
		{
			if(b[i+1]-b[i]<mindiff)
			{
				mindiff=b[i+1]-b[i];
				
			}
		}
		System.out.println(mindiff);

	}

}
