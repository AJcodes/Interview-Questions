import java.util.ArrayList;
import java.util.List;


public class PowerSet2 {

	//Given a number N, write a program that returns all possible combinations of numbers that add up to N, as lists. (Exclude the N+0=N)
	//For example, if N=4 return {{1,1,1,1},{1,1,2},{2,2},{1,3}}
	
	//Use simple recursion. There are two cases:
	//1) Include the given number in the sum
	//2) Exclude the number from the sum and proceed to next number 
	public static void findNum(int numToAdd, int n, List<Integer> result) {

		if (n == 0 && result.size() != 1) {
		    System.out.println(result);
		    return;
		}
		if (n < 0 || numToAdd > n) {
		    return;
		}
		result.add(numToAdd);
		findNum(numToAdd, n - numToAdd, result); // uses the current number to add and substracts from the integer n to get e.g. [1,1,1,1]
		result.remove(result.size() - 1); // once you have the first list of 1s, remove the last element
		findNum(numToAdd + 1, n, result); // increment the number to add and add to the list of 1s, then rinse and repeat
	}
	
	public static void main(String[] args) {
		int n = 4;
		List<Integer> result = new ArrayList<Integer>();
		findNum(1, n, result);
	}
	
}
