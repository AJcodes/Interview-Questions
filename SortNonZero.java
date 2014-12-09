import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;


public class SortNonZero {

	// sort all nonzeros in an array to the left side, while all zeros to the right
	// the order of nonzeros is irrelevant
	// using two pointer method as usual
	// Time complexity: O(n^2)
	// Space complexity: O(1)
	public static int[] sort(int[] arr) {
		int i = 0;
		int j = arr.length-1;
		while (i < arr.length)
		{
			if (arr[i] == 0)
			{
				while (j > i)
				{
					if (arr[j] > 0)
					{
						arr[i] = arr[j];
						arr[j] = 0;
						break;
					}
					j--;
				}
				
			}
			i++;
			j = arr.length-1;
		}
		return arr;
	} 
	
	// see if there's an optimal way to do this
	public static int[] sort2(int[] arr) {
		int j = 0;
		for(int i = 0 ; i < arr.length-j; i++){
			if(arr[i] == 0) {
				j++;
				arr[i] = arr[arr.length-j];
				arr[arr.length-j] = 0;
				i=-1;
			}
		}
		return arr;
	} 
	
		
	public static void main(String[] args) {
		int[] arr = { 1, 0, 2, 0, 0, 3, 4};
		int[] arr2 = null;
		arr = sort(arr);
		arr2 = sort2(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
	}
	
}
