
public class LeastDifference {

	//Given - a number (n) and a sorted array
	//Find a number in the array having least difference with the given number (n).
	
	//This approach of binary search is considered as:
	//a. Find the middle element in the array. If the middle element is equal to the number then we have find our minimum difference of that number that is 0
	//b. If the number is less than the middle element then find the difference and then search further in the left half.
	//c. If the number is more than the middle element then find the difference and then search in the right half.
	//d. Here the variable difference is static for comparing this diff with other scenarios. 
	//Time complexity: O(n)
	public static int least(int[] arr, int n)
	{
		int diff = 0;
		int temp = 0;
		int min = 0;
		if (arr[arr.length/2] == n)
		{
			min = arr[arr.length/2];
			return min;
		}
		else if (n < arr[arr.length/2])
		{
			for (int i = 0; i <= arr.length/2; i++)
			{
				temp = Math.abs(arr[i] - n);
				if (i == 0)
				{
					diff = temp;
					min = arr[i];
				}
				if (temp < diff)
				{
					diff = temp;
					min = arr[i];
				}
			}
			return min;
		}
		else
		{
			for (int i = arr.length/2; i < arr.length; i++)
			{
				temp = Math.abs(arr[i] - n);
				if (i == arr.length/2)
				{
					diff = temp;
					min = arr[i];
				}
				if (temp < diff)
				{
					diff = temp;
					min = arr[i];
				}
			}
			return min;
		}
	}
	
	public static void main(String[] args) {
		int[] arr={10,20,30,40,50};
		System.out.println(least(arr,17));
		
	}
}
