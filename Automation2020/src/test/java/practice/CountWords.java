package practice;

import org.testng.annotations.Test;

public class CountWords {

	@Test(enabled = false)
	public void wordcount() {
		String  element = "Who are you";
		 String[] substr = element.split(" ");
		 int count=0;
		 for (String a : substr)  
			 System.out.print(a);
			 count++;
		 
		 System.out.print(count);
}
	
	
	@Test(enabled = true)
	public void wordcount2()  
		        {  
		          int count=0;  
		          String string ="    India Is My Country";
		          
		            char ch[]= new char[string.length()];     
		            for(int i=0;i<string.length();i++)  
		            {  
		                ch[i]= string.charAt(i);  
		                if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
		                    count++;  
		            }  
		            System.out.println(count+ " words."); 
		        }  
		           
		            
		 
	
	}