package practice;

public class ReverserString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Using StringBuffer class
		StringBuffer a = new StringBuffer("Software Testing Material");
		// use reverse() method to reverse string
		System.out.println(a.reverse());
		
		String input="danish";
		StringBuilder input1 = new StringBuilder();
		input1.append(input);
		input1=input1.reverse(); 
		System.out.println(input1);
		
		
		}
	}

