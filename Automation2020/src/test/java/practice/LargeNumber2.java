package practice;

public class LargeNumber2 {

	public static void main(String[] args) {
		
		int[] Arr= {15,55,56,88,99};
		
		int val = Arr[0];
		
		for(int i=0; i<Arr.length; i++) {
			
			if(Arr[i]>val) {
				
				val=Arr[i];
			}
		}
		
		System.out.println("Large number is "+ val);
	}

}
