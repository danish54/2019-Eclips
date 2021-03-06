package practice;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		int a = 0, b = 1, c, i, count;
		
		System.out.print("Enter the number of Counts : "); 
		Scanner sc = new Scanner(System.in); 
		count = sc.nextInt();  

		
		// To print 0 and 1
		System.out.print(a + " " + b);
		// loop starts from 2. We have already printed 0 and 1 in the previous step
		for (i = 2; i < count; i++) {
			c = a + b;
			System.out.print(" " + c);
			a = b;
			b = c;
		}
		
	}

}
