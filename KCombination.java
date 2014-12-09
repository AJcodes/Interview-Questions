import java.util.ArrayList;

public class KCombination {

	//Print out all combinations of k numbers out of 1...N e.g. when k = 2, n = 4 Print 
	//out 12, 13, 14, 23, 24, 34

	//need to clarify on output conditions
	
	public static ArrayList<Integer> kcombo(int k, int n)
	{
	   ArrayList<Integer> test = new ArrayList<Integer>();
	   int p = k;
	   for (int i = 1; i < n; i++)
	   {
		   String t = "";
		   t += i;
		   int j = i+1;
		   while (j <= n)
		   {
			   int l = j;
				   while (p > 1)
				   {
					   if (l <= n)
					   {
						   t += l;
					   }
					   l++;
					   p--;
				   }
				   if (t.length() == k)
				   {
					   test.add(Integer.parseInt(t));
				   }
				   t = "";
				   t += i;
				   j++;
				   p = k;
		   }
	   }
	   return test;
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> test = new ArrayList<Integer>();
		test = kcombo(2,4);
		System.out.println(test);
	}
	
}
