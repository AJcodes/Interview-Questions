
public class ArithmeticProg {

	//Example :
	//Given the AP :- 1 3 7 9 11 13 find the missing value "which would be 5 here".

	//Conditions :
	//Get an user for the length of AP sequence and make sure user provides length is above 3.
	//Get the input in a single line ex:- "1 3 5 7 9 11"
	//Provide the solution in O(n) or less if you can.
	
	//assume that the sequence provided is always sorted
	//Time Complexity: O(N)
	//Divide and conquer method
	
	public static int findMissing(int[] arr)
	{
		assert arr != null && arr.length > 2;
		int ans = 0;
		int diff = Math.min(arr[2]-arr[1], arr[1]-arr[0]);
		int low = 0, high = arr.length-1;
		int mid = arr.length / 2;
		while(low <= mid) {
			if (arr[low+1] - arr[low] != diff)
			{
				ans = arr[low+1] - diff;
				return ans;
			}
			if (arr[high] - arr[high-1] != diff)
			{
				ans = arr[high] - diff;
				return ans;
			}
			low++;
			high--;
		}
		
		return -1;
	}
	
	public static void main(String[] args)
	{
		int[] test = {1,3,7,9,11,13};
		int[] test2 = {-1,3,7,15};
		System.out.println(findMissing(test));
		System.out.println(findMissing(test2));
	}
	
}
