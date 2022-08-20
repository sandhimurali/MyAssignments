package week1.assignments;

public class Palindrome {

	public static void main(String[] args) {
		//Initialize a  temporary variable.
		int input=34343,rem=0,sum=0,reverseNum=input;
		//Reverse the number (using for loop and add to the temporary variable)
		while (input>0) {
			rem=input%10;
			sum=(sum*10)+rem;
			input=input/10;
		}
		
		System.out.println(sum);
		if(reverseNum==sum) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not a Palindrome");
		}
	}

}
