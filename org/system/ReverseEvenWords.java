package org.system;

public class ReverseEvenWords {
	/*Build a logic to reverse the even position words (output: I ma a erawtfos tester)*/
	

	public static void main(String[] args) {
	     
		// intput String test = "I am a software tester"; 
	     String test = "I am a software tester"; 
	 
	     //a) split the words and have it in an array
	     String[] split = test.split(" ");
  	
        //b) Traverse through each word (using loop)
      	for(int i=0;i< split.length; i++) {
      	
      	//c) find the odd index within the loop (use mod operator)
      	if(i%2==1) {
      		System.out.print(" ");
      	
      	//d)split the words and have it in an array
      	char[] charArray = split[i].toCharArray();
      	
    	//e)print the even position words in reverse order using another loop (nested loop)
    	for(int j=charArray.length-1;j>=0;j--) {
    		System.out.print(charArray[j]);
    	}
    	/*f) Convert words to character array if the position is 
    	even else print the word as it is(concatenate space at the end).*/
    		System.out.print(" ");
      	}
      	else {
      		System.out.print(split[i]);
      	}
      	}
      	
	}
		
		
	}

