
public class MaxSubArray {

	//During interviews, many candidates can solve it by enumerating all of sub-arrays and calculate their sum. 
	//An array with n elements has n(n+1)/2 sub-arrays. It costs O(n2) time at least to calculate their sum. 
	//Usually the intuitive and forceful solution is not the most optimized one. Interviewers will tell us that there are better solutions.
	
	
	//if the sum of sub-array ended with the (i-1)th number is negative, the sum of sub-array ended with the ith number 
	//should be the ith number itself (it is the third step in the Table 1). Otherwise, we can get the sum of sub-array ended 
	//with the ith number by adding the ith number and the sum of sub-array ended with the previous number
	//Dynamic Programming Approach
	//Time: O(n)
	public static int maxSubArray(int[] A) {
		int max = A[0];
		int[] sum = new int[A.length];
		sum[0] = A[0];
 
		for (int i = 1; i < A.length; i++) {
			sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
			max = Math.max(max, sum[i]);
		}
 
		return max;
	}
	
	public static int minSubArray(int[] arr) {
	    int minSum = 0;
	    int curSum = 0;
	    for (int i : arr) {
	        curSum += i;
	        minSum = Math.min(minSum, curSum);
	        curSum = Math.min(curSum, 0);
	    }
	    return minSum;
	}
	
	public static int findMaxSubArray(int[] array)
	{
	    int max=0,cumulativeSum=0,i=0,start=0,end=0,savepoint=0;
	    while(i<array.length)
	    {
	        if(cumulativeSum+array[i]<0)
	        {
	            cumulativeSum=0;
	            savepoint=start;
	            start=i+1;
	        }
	        else
	            cumulativeSum=cumulativeSum+array[i];
	        if(cumulativeSum>max)
	        {
	                max=cumulativeSum;
	                savepoint=start;
	                end=i;
	        }
	        i++;
	    }

	    System.out.println("Max : "+max+"  Start indices : "+savepoint+"  end indices : "+end);
	    return max;

	}
	
	//Time Complexity: O(N)
	public static int getGroupSum(int arr[], int target)
	{
	    int rem_sum = arr[0], start = 0;
	    for (int i = 1; i <= arr.length; i++)
	    {
	        while(rem_sum > target && start < i-1)
	        {
	            rem_sum = rem_sum - arr[start];
	            start++;
	        }
	        if(rem_sum == target)
	        {
	            System.out.printf ("Sum %d found between indexes %d and %d", target, start, i-1);
	            return 1;
	        }
	        if(i < arr.length)
	          rem_sum = rem_sum + arr[i];
	    }
	 
	    System.out.printf("No sub array with target sum");
	    return 0;
	}
	
	public static boolean isGroupSum(int arr[], int target, int start)
	{
		      /*Base condition*/
		      if(start >= arr.length)
		           return (target == 0);
		 
		      /*we found the target sum, return true*/
		      if(target == 0)
		           return true;
		 
		      /*else, check if sum can be obtained by any of the following
	            1) Including the current element
		        2) Excluding the current element*/
		      return isGroupSum(arr, target - arr[start], start+1) || isGroupSum(arr, target,start+1);
	}
	
	private static void getMinSuMArray(int[] a) {
		 if(a == null) {
		  return;
		 }
		 int minStart = -1, minEnd = -1, i=0;
		 int minSum = 0;
		 while(i < a.length) {
		  int sum = 0;
		  int j=i;
		  while(sum <= 0 && j<a.length) {
		   sum = sum + a[j];
		   if( sum < minSum) {
		    minStart = i;
		    minEnd = j;
		    minSum = sum;
		   }
		   j++;
		  }
		  i=j;
		 }

		 if(minStart == -1) {
		  minSum = Integer.MAX_VALUE;
		  for(int j=0; j<a.length; j++) {
		   if(a[j] <= minSum ) {
		    minStart = j;
		    minEnd = j;
		   }
		  }
		 }
		 System.out.println("Min : "+minSum+"  Start indices : "+minStart+"  end indices : "+minEnd);
		}
	
	public static void main (String[] args) {
		int test[] = {1, -2, 3, 10, -4, 7, 2, -5}; //expected output 18, from subarray {3, 10, -4, 7, 2}
		int test2[] = {2, -8, 3, -2, 4, -10}; //expected output 5, from subarray {3, -2, 4}
		System.out.println(maxSubArray(test));
		System.out.println(maxSubArray(test2));
		System.out.println(minSubArray(test));
		findMaxSubArray(test);
		findMaxSubArray(test2);
		getMinSuMArray(test);
		getGroupSum(test,11);
	}
	
}
