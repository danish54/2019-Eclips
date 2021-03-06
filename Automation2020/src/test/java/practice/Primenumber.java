package practice;

public class Primenumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		       int i =0;
		       int num =0;
		       String  primeNumbers = "";
		 
		       for (i = 2; i <= 100; i++){ 		  	  
		          int counter=0; 	  
		          for(num =i; num>1; num--){
		             if(i%num==0){
		            	 counter = counter + 1;
		             }
		          }
				  if (counter ==1){
				     primeNumbers = primeNumbers + i + " ";
				  }	
		       }	
		       System.out.println("Prime numbers from 1 to 100 are :");
		       System.out.println(primeNumbers);
		   }
	}


