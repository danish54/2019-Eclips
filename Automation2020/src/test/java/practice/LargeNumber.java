package practice;

public class LargeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] arr={3,15,9,17,4,23,2};
		 
		int val=arr[0];
 
		for(int i=0; i<arr.length; i++){
			if(arr[i] > val){
				val=arr[i];
			}
		}
		System.out.println("Largest value in the Given Array is "+ val);
	}

}
