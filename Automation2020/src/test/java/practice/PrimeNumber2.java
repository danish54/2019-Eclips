package practice;

public class PrimeNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num=0;
	    int i=0;
	    String prime="";
	    for(i=2; i<=100; i++) {
	    	int count=0;
	    	for(num=i; num>1; num--) {
	    		if(i%num==0) {
	    			count=count+1;
	    		}
	    	}
	    	if(count==1) {
	    	
	    		prime= prime+i+" ";
	    	}
	    	}
	
	    
	    
	    System.out.print("Prime Numbers are = "+prime );
		
		

}}
