package introduction;

public class captcha {

	public static void main(String[] args) {
	
		String lement = "Sum of 9 + 6 = ?";
		String[] substr = lement.split(" ");
		
		
		int ss=Integer.parseInt(substr[2]);
		System.out.println(ss);
		
		int s2=Integer.parseInt(substr[4]);
		System.out.println(s2);
		
		int sum=ss+s2;
		String som=Integer.toString(sum);
		System.out.println(som);

	}

}
