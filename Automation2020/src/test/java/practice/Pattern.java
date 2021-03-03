package practice;

public class Pattern
{
	static int x1;
	static int y1;
	static int row=5; 
	public static void main(String[] args) 
	{
		/*
		 * // TODO Auto-generated method stub
		 * 
		 * for (int x = 1; x <= 5; x++) {
		 * 
		 * for (int y = 1; y <= x; y++) { //System.out.print(y + " ");
		 * System.out.print("*");
		 * 
		 * }
		 * 
		 * System.out.println(); }
		 */
	

	
	
		/*
		 * //outer loop for rows for(x1=0; x1<row; x1++) { //inner loop for columns
		 * for(y1=0; y1<=x1; y1++) { //To prints stars System.out.print("* "); }
		 * //Cursor goes to the new line after printing each line. System.out.println();
		 * }
		 */
	
	
	int i, j, row = 6;       
	//Outer loop work for rows  
	for (i=0; i<row; i++)   
	{  
	//inner loop work for space      
	for (j=2*(row-i); j>=0; j--)         
	{  
	//prints space between two stars      
	System.out.print(" ");   
	}   
	//inner loop for columns  
	for (j=0; j<=i; j++ )   
	{   
	//prints star      
	System.out.print("* ");   
	}   
	//throws the cursor in a new line after printing each line  
	System.out.println();   
	}   
	}   
	
}
