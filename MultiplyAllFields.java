import java.util.Arrays;


public class MultiplyAllFields {

	//input [2,3,1,4]
	//output [12,8,24,6]
	//Multiply all fields except it's own position.
	//Restrictions:
	//1. no use of division
	//2. complexity in O(n)
	
	
	/*arr = 2, 3, 1, 4

	// maintain two arrays which can be done in O(n)
	
	arr1 = 2,  6,   6,  24 (arrays multiply each number with previous and current)
	arr2 = 24, 12, 4, 4    (arrays multiplied from end)
	
	In above two arrays, put 1 in beginning of arr1 and end of arr2:
	arr1 =  1,  2, 6, 6,  24
	arr2 = 24, 12, 4, 4,   1
	
	Then to find number at index 'i' you would just do:
	
	arr1[i]*arr2[i+1]*/
	
	public static int[] MultArray(int[] input)
	{
		int[] temp = new int[input.length];
		System.arraycopy(input, 0, temp, 0, input.length);
		int j = temp.length-1;
		for (int i = 0; i < input.length; i++)
		{
			if(i >= 1)
			{
				input[i] = input[i]*input[i-1];
				temp[j-1] = temp[j]*temp[j-1];
				j--;
			}
		}
		for (int i = input.length-1; i >= 0; i--)
		{
			if(i == 0)
			{
				input[i] = 1*temp[i+1];
			}
			if (i > 0 && i < input.length-1)
			{
				input[i] = input[i-1]*temp[i+1];
			}
			if (i == input.length-1)
			{
				input[i] = input[i-1]*1;
			}
		}
		
		return input;
	}
	
	public static void main(String[] args) 
    {
    	int[] test = {2,3,1,4};
    	System.out.println(Arrays.toString(MultArray(test)));
    	
    }
	
}
