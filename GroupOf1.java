import java.util.ArrayList;
import java.util.Arrays;

public class GroupOf1 {

	//Find largest group of 1s, return size
	public static int findBig(int[][] input){
		int count = 0;
		int tempcount = 0;
		for (int i = 0; i < input.length; i++)
		{
			for (int j = 0; j < input[i].length; j++)
			{
				if (input[i][j] == 1)
				{
					count += crawl(i,j,input,i,j);
					if (tempcount < count)
   				    {
					    tempcount = count;
						count = 0;
					}
					else if (tempcount > count)
					{
						count = 0;
					}
					
				}
				
			}
		}
		return tempcount;
	}
	
	//Find smallest group of 1s, return size
	public static int findSmall(int[][] input){
		int count = 0;
		int tempcount = 0;
		for (int i = 0; i < input.length; i++)
		{
			for (int j = 0; j < input[i].length; j++)
			{
				if (input[i][j] == 1)
				{
					count += crawl(i,j,input,i,j);
					if (tempcount == 0)
					{
						tempcount = count;
						count = 0;
					}
					else if (tempcount > count)
   				    {
						tempcount = count;
						count = 0;
					}
					else if (tempcount < count)
					{
						count = 0;
					}
					
				}
				
			}
		}
		return tempcount;
	}
	
	public static int findPerimeter(int[][] input){
		int count = 0;
		int tempcount = 0;
		for (int i = 0; i < input.length; i++)
		{
			for (int j = 0; j < input[i].length; j++)
			{
				if (input[i][j] == 1)
				{
					count += crawl(i,j,input,i,j);
				}
				
			}
		}
		return tempcount;
	}
	
	public static int crawl(int x, int y, int[][]input, int prevRow, int prevCol)
	{
		int count = 0;
		if (x < 0 || y < 0 || x >= input.length || y >= input[x].length || input[x][y] == 0)
			return 0;
		
		count = 1;
		input[x][y] = 0;
		if (prevRow != x + 1 || prevCol != y)//This if condition prevents going in the route we came from
			count += crawl(x + 1, y, input, x, y);
		if (prevRow != x || prevCol != y + 1)//This if condition prevents going in the route we came from 
			count += crawl(x, y + 1,input,  x, y);
		if (prevRow != x - 1 || prevCol != y)//This if condition prevents going in the route we came from 
			count += crawl(x - 1, y, input, x, y);
		if (prevRow != x || prevCol != y - 1)//This if condition prevents going in the route we came from 
			count += crawl( x, y - 1, input, x, y);
		return count;
	}
	
	/******************************************************************************************************************************************/
	
	private static int count(int[][] matrix, int m, int n) {
		int count = 0;
	    for(int i=0; i<m; i++) {
		   for(int j=0; j<n; j++) {
			   if(matrix[i][j] == 1) {
				   count++;
				   clear(matrix, m, n, i, j);
			   }
		   }
	    }
	    return count;
	}

	/**
	 * Clear the group of 1s connected in four directions.
	 * @param matrix
	 * @param m
	 * @param n
	 * @param i
	 * @param j
	 */
	private static void clear(int[][] matrix, int m, int n, int i, int j) {
		//Boundary checks to avoid java.lang.ArrayIndexOutOfBoundsException.
		//If the data is 0, then return.
		if(i<0 || j<0 || i>m-1 || j>n-1 || matrix[i][j] == 0) {
			return;
		}
		matrix[i][j] = 0;
		clear(matrix, m, n, i-1, j);
		clear(matrix, m, n, i+1, j);
		clear(matrix, m, n, i,   j-1);
		clear(matrix, m, n, i,   j+1);
	}
	
	/******************************************************************************************************************************************/
	
	//if there is an element with 0, set row and column of that 0 to zero
	public static void setZeros(int[][] matrix) {
		int[] row = new int[matrix.length];	
		int[] column = new int[matrix[0].length];

		// Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length;j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1; 
					column[j] = 1;
		 		}
			}
		}

		// Set arr[i][j] to 0 if either row i or column j has a 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if ((row[i] == 1 || column[j] == 1)) {
					matrix[i][j] = 0;
				}
			}
		}
	}	
	
	public static void main(String[] args) 
    {
    	int[][] mat =   {{1, 1, 0, 0, 0, 0, 0, 0, 0},
    					 {1, 1, 0, 1, 1, 1, 1, 0, 1},
    					 {0, 0, 0, 0, 0, 1, 0, 0, 1},
    					 {1, 1, 1, 0, 0, 1, 1, 0, 1},
    					 {1, 1, 0, 0, 1, 1, 1, 0, 1},
    					 {1, 1, 1, 0, 0, 0, 0, 0, 1}};
    	System.out.println("Largest Group of 1s: " + findBig(mat));
    	int[][] mat2 =   {{1, 1, 0, 0, 0, 0, 0, 0, 0},
						  {1, 1, 0, 1, 1, 1, 1, 0, 1},
						  {0, 0, 0, 0, 0, 1, 0, 0, 1},
						  {1, 1, 1, 0, 0, 1, 1, 0, 1},
						  {1, 1, 0, 0, 1, 1, 1, 0, 1},
						  {1, 1, 1, 0, 0, 0, 0, 0, 1}};
    	System.out.println("Smallest Group of 1s: " + findSmall(mat2));
    	int[][] mat3 =   {{1, 1, 0, 0, 0, 0, 0, 0, 0},
				  		  {1, 1, 0, 1, 1, 1, 1, 0, 1},
				  		  {0, 0, 0, 0, 0, 1, 0, 0, 1},
				  		  {1, 1, 1, 0, 0, 1, 1, 0, 1},
				  		  {1, 1, 0, 0, 1, 1, 1, 0, 1},
				  		  {1, 1, 1, 0, 0, 0, 0, 0, 1}};
    	System.out.println("Perimeter: " + findPerimeter(mat3));
    	
    }
	
}

