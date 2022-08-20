package week1.assignments;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// initialize 3 int variables (Tip: range = 8, firstNum = 0, secNum = 1, sum in the series)
		int range=8; int firstNum =0; int secNum=1; int sum;
		// Print first number
		System.out.println(firstNum);
		System.out.println(secNum);
		// Iterate from 1 to the range
		for (int i = 1; i <=range; i++) {
			// add first and second number assign to sum
			sum= firstNum+secNum;
			// Assign second number to the first number
			firstNum=secNum;
			// Assign sum to the second number
			secNum=sum;
			// print sum
			System.out.println(sum);
			
		}
	
	}

}
