
public class ABequalsCD {

	// assuming that A, B can only be found on the left, while C, D on the right
	// assuming that A < B < C < D
	// assuming that only the first combination is needed
	// assuming sorting cannot be done
	// Time complexity: Best: O(logn) Average: O(n)
	public static void findABCD(int[] arr) {
		int A = 0;
		int D = arr.length-1;
		while(A <= arr.length/2)
		{
			for(int i = A+1; i <= arr.length/2; i++)
			{
				D = arr.length-1;
				while (D >= arr.length/2)
				{
					for(int j = D-1; j >= arr.length/2; j--)
					{
						if (arr[A] + arr[i] == arr[j] + arr[D])
						{
							System.out.printf("[ %d %d %d %d ]\n", A, i, j, D);
							
						}
					}
					D--;
				}
			}
			A++;
		}
	} 
	
	public static void main(String[] args) {
		int[] arr = {3,4,7,1,2,9,8};
		findABCD(arr);
	}
	
}
