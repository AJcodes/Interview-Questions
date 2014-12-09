
public class FindOccurence {

	//How many occurrences of a given search word can you find in a two-dimensional array of characters given that 
	//the word can go up, down, left, right, and around 90 degree bends? 
	/**
	 * Time complexity: O(N^3)
	 * Space complexity: O(1)
	*/
	public static int find(char[][] input, String target){
		int count = 0;
		for (int i = 0; i < input.length; i++)
		{
			for (int j = 0; j < input[i].length; j++)
			{
				if (input[i][j] == target.charAt(0))
				{
					count += crawl(i,j,input,target,0,i,j);
				}
			}
		}
		return count;
	}
	
	public static int crawl(int x, int y, char[][]input, String target, int textIndex, int prevRow, int prevCol)
	{
		if (x < 0 || y < 0 || x >= input.length || y >= input[x].length)
			return 0;
		if (input[x][y] == target.charAt(textIndex) && textIndex == target.length()-1)
			return 1;
		int count = 0;
		if (input[x][y] == target.charAt(textIndex))
		{
			if (prevRow != x + 1 || prevCol != y)//This if condition prevents going in the route we came from
				count += crawl(x + 1, y, input, target, textIndex + 1,	x, y);

			if (prevRow != x || prevCol != y + 1)//This if condition prevents going in the route we came from 
				count += crawl(x, y + 1,input,  target, textIndex + 1,x, y);
			
			if (prevRow != x - 1 || prevCol != y)//This if condition prevents going in the route we came from 
				count += crawl(x - 1, y, input, target, textIndex + 1,x, y);
			
			if (prevRow != x || prevCol != y - 1)//This if condition prevents going in the route we came from 
				count += crawl( x, y - 1, input, target, textIndex + 1,x, y);
			
		}
		return count;
	}
	   
	public static void main(String[] args) {
		char[][] a = { { 'S', 'N', 'B', 'S', 'N' },
				{ 'B', 'A', 'K', 'E', 'A' }, 
				{ 'B', 'K', 'B', 'B', 'K' },
				{ 'S', 'E', 'B', 'S', 'E' } };

		String str = "SNAKES";
		System.out.println(find(a, str));
	}
}
