import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PowerSet {

	//Write a program to print the powerset.
	//E.g. given this set {1,2,3}, it will print {},{1},{2},{3},{1,2},{1,3}, {2,3}, {1,2,3}
	
	//Generating combinations of k elements from the given set follows similar algorithm used to generate all permutations, 
	//but since we don't want to repeat an a character even in a different order we have to force the recursive calls to not to follow 
	//the branches that repeat a set of characters.
	
	//Here we will have to make sure, once we start a "branch" from a node (character), we must not come back to that 
	//node (character) again to start another "branch". So, starting off a new recursive call (to traverse a new "branch") 
	//must start from the following node (character)!
	
	public static void combine(char[] arr, int k, int startId, char[] branch, int numElem)
	{
	    if (numElem == k)
	    {
	        System.out.println(Arrays.toString(branch));
	        return;
	    }
	   
	    for (int i = startId; i < arr.length; ++i)
	    {
	        branch[numElem++] = arr[i];
	        combine(arr, k, ++startId, branch, numElem);
	        --numElem;
	    }
	}
	
	//Generating all subsets (the power set) of a given set of characters (or numbers) is very similar to generating combinations. 
	//While generating k-element combinations our goal was to print the current "branch" only when it holds all k characters from 
	//the given string. Since a power set contains combination of all lengths, we will simply call combine to generate k combinations 
	//for all k where 0 <= k < SIZE(string).
	
	public static void powerSet(char[] arr)
	{
	    for (int i = 0; i < arr.length; ++i)
	    {
	        char[] branch = new char[i];
	        combine(arr, i, 0, branch, 0);
	    }   
	}
	
	public static void main(String[] args)
	{
		char[] test = {'a','b','c'};
		char[] test2 = {'1','2','3'};
		powerSet(test);
		powerSet(test2);

	}
	
}
