package week1.assignments;

import java.util.Arrays;

public class MissingElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Here is the input
				int[] arr = {1,2,3,4,7,6,8};    int count=1;
			// Sort the array	
			Arrays.sort(arr);
				// loop through the array (start i from arr[0] till the length of the array)
			for (int i = 0; i <= arr.length-1; i++) {
				// check if the iterator variable is not equal to the array values respectively
				if(arr[i] != i + count) {
				// print the number
				System.out.println(i + count);
				// once printed break the iteration
				count++;
			}
					
						
	}
	}
}
