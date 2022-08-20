package week1.assignments;

public class PrimeNumber {

	public static void main(String[] args) {
		int Input=13;
		boolean flag=false;
		for(int i=2;i < Input/2;i++){
		if(Input%i==0) {
			System.out.println("Given Input is Not a prime number");
			flag=true;
			break;
		}
		}
		if(!flag) {
			System.out.println("Given input is prime number");
		}
	}
	}


