package practice;

public class LeftTrianglePattern {

	public static void main(String[] args) {
		
		
		int i,j;
		int R=6;
		
		for(i=0; i<R; i++)
		{
			for(j=R-i; j>=0; j--)
			{
				System.out.print(" ");
				
			}
			
			for(j=0; j<=i; j++)
			{
				System.out.print("*");
			}
			
			System.out.println();
			
		}
		

	}

}
