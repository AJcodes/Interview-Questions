import java.util.Arrays;
import java.util.TreeSet;


public class MergeSortedArray {

	//Given two arrays of sorted integers, merge them keeping in mind that there might be common elements in the arrays 
	//and that common elements must only appear once in the merged array
	
	//If additional buffer is allowed
	//Use a TreeSet (extension of Set)
	//Elements that already exist in the Set will not be added
	//Treeset will also automatically sort the elements
	//Treeset: 
    //-guarantees log(n) time cost for the basic operations (add, remove and contains)
    //-guarantees that elements of set will be sorted (ascending, natural, or the one specified by you via its constructor)
    //-doesn't offer any tuning parameters for iteration performance
    //-offers a few handy methods to deal with the ordered set like first(), last(), headSet(), and tailSet() etc

	public static int[] MergeArray(int[] a, int[] b)
	{
		TreeSet tree = new TreeSet();
		int[] answer;
		for (int i= 0; i<a.length; i++) {tree.add(a[i]);}
		for (int i= 0; i<b.length; i++) {tree.add(b[i]);} 
		answer = new int[tree.size()];
		int count = 0;
		for (Object value : tree) {answer[count] = ((Integer)value).intValue(); count++;}
		return answer;
	}
	
	//If additional buffer is not allowed
	public static int[] MergeArray2(int[] a, int[] b)
	{
		int[] answer = null;
		
		return answer;
	}
	
	public static void main(String[] args) 
    {
    	int[] test = {1,2,4,6};
    	int[] test2 = {2,3,4,5,6,7,8};
    	System.out.println(Arrays.toString(MergeArray(test,test2)));
    }
	
}
