package practice;

import org.testng.annotations.Test;

public class SimplePattern {

	@Test
	public void Pattern2() {
		
		for(int i=0; i<20; i++)   
		{   
		for(int j=0; j<=i; j++)   
		{   
		System.out.print("* ");   
		}   
		System.out.println();
	}

}
}