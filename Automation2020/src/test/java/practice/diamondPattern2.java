package practice;

import java.util.Scanner;

public class diamondPattern2 {
	
	 
	public static void main(String args[])  
	{  
	int row, i, j, space = 1;  
	System.out.print("Enter the number of rows you want to print: ");  
	Scanner sc = new Scanner(System.in);  
	row = sc.nextInt();  
	space= row+1;
	System.out.println("Number of Rows to be Printed " +row);
	
	//for space for top portion
	
	for(i=0; i<=row; i++)
	{
		for(j=0; j<=space; j++)
		{
			System.out.print(" ");
		}
		space--;
		for(j=0; j<=2*i; j++)
		{
			System.out.print("*");
		}
	System.out.println("");
	}
	
	space=1;
	for(i=0; i<=row; i++)
	{
		for(j=0; j<=space; j++)
		{
			System.out.print(" ");
		}
		space++;
		for(j=0; j<=2*(row-i); j++)
		{
			System.out.print("*");
		}
	System.out.println("");
	}
	}
	}

