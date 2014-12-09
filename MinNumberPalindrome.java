import java.util.ArrayList;


public class MinNumberPalindrome {

	//A palindrome is a word, phrase, number, or other sequence of symbols or elements that reads the same forward or reversed, with 
	//general allowances for adjustments to punctuation and word dividers.
	
	//Given a substring ending at the index i, str[0, i], we do not have to split if the substring is a palindrome itself. 
	//Otherwise it is split between two characters at index j and j+1 only if the substring str[j+1,i] is a palindrome.
	//The value of f(n-1) is the value of the minimal number of splits to partition str into palindromes, if n is the length of str
	
	//it costs O(n) time to check whether a string with length n is a palindrome
	public static boolean isPalindrome(String s) 
	{
		int i = 0;
		int j = s.length() - 1;
		while (i < j) 
		{
			if (s.charAt(i++) != s.charAt(j--)) 
			{
				return false;
			}
		}
		return true;
	}
	
	
	//Write a function that takes a string and returns true if the entire string is a palindrome, otherwise return false. 
	//The function should be case-insensitive and ignore any whitespace or punctuation. 
	public static boolean isPalindrome2(String s) 
	{
		int i = 0;
		int j = s.length() - 1;
		
		while (i < j) 
		{
			if(s.toLowerCase().charAt(i) < 'a' || s.toLowerCase().charAt(i) > 'z')
			{
				i++;
				continue;
			}
			if(s.toLowerCase().charAt(j) < 'a' || s.toLowerCase().charAt(j) > 'z' )
			{
				j--;
				continue;
			}
			if (s.toLowerCase().charAt(i++) != s.toLowerCase().charAt(j--)) 
			{
				return false;
			}
		}
		return true;
	}
	
	//it costs O(n) time to check whether an int n is a palindrome
	public boolean isPalindrome(int x) {
        //negative numbers are not palindrome
		if (x < 0)
			return false;
 
		// initialize how many zeros
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}
 
		while (x != 0) {
			int left = x / div;
			int right = x % 10;
 
			if (left != right)
				return false;
 
			x = (x % div) / 10;
			div /= 100;
		}
 
		return true;
    }
	
	/******************************************************************************************************************************************/
	
	//it costs O(n^2) time to find the minimum number of cuts (both functions give a total time O(n^3)
	public static int minCuts(String s)
	{
		 
		int cuts = -1;
		for (int i = 0; i < s.length(); i++) 
		{
			for (int j = s.length(); j > 0; j--) 
			{
				final String t = s.substring(i, j);
				if (isPalindrome(t)) 
				{
					cuts++;
					i = j - 1;
					break;
				}
			}
		}
		 
		return cuts;
	}
	
	/******************************************************************************************************************************************/
	
	//Time O(n^2), Space O(1) to find the longest Palindrome
	public static String longestPalindrome(String s) {
		if (s.isEmpty()) {
			return null;
		}
	 
		if (s.length() == 1) {
			return s;
		}
	 
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			// get longest palindrome with center of i
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
	 
			// get longest palindrome with center of i, i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
	 
		return longest;
	}
	
	
	// Given a center, either one letter or two letter, 
	// Find longest palindrome
	public static String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}
	
	/******************************************************************************************************************************************/
	
	//String compression
	//For example, if the input string is "wwwwaaadexxxxxx", then the function should return "w4a3dex6"
	//Assume all alphabets are sorted together
	//Time Complexity: O(n)
	static String ReturnString(String inputstring)
	{
		String result = "";
		int count = 0;
		char previousChar = inputstring.charAt(0);
		//result += previousChar;
		for (int i = 0; i < inputstring.length(); i++)
		{
			if (previousChar == inputstring.charAt(i))
			{
				count++;
				previousChar = inputstring.charAt(i);
			}
			else
			{
				result += previousChar;
				result += count;
				count = 0;
				previousChar = inputstring.charAt(i);
				count++;
			}
		}
		result += previousChar;
		result += count;
		return result.toString();
	}
	
	/******************************************************************************************************************************************/
	 
	//find all partitions
	public static ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	 
		if (s == null || s.length() == 0) {
			return result;
		}
	 
		ArrayList<String> partition = new ArrayList<String>();
		addPalindrome(s, 0, partition, result);
	 
		return result;
	}
	 
	private static void addPalindrome(String s, int start, ArrayList<String> partition,
			ArrayList<ArrayList<String>> result) {
		//stop condition
		if (start == s.length()) {
			ArrayList<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
		}
	 
		for (int i = start + 1; i <= s.length(); i++) {
			String str = s.substring(start, i);
			if (isPalindrome(str)) {
				partition.add(str);
				addPalindrome(s, i, partition, result);
				partition.remove(partition.size() - 1);
			}
		}
	}
	 
	/******************************************************************************************************************************************/
	
	//A k-palindrome is a string which transforms into a palindrome on removing at most k characters.

	//Given a string S, and an interger K, print "YES" if S is a k-palindrome; otherwise print "NO".
	//Constraints:
	//S has at most 20,000 characters.
	//0<=k<=30

	//Sample Test Case#1:
	//Input - abxa 1
	//Output - YES
	//Sample Test Case#2:
	//Input - abdxa 1
	//Output - No
	
	//Need to clarify if "At most k characters" implies that if any removal of character < K derives a YES
	//below solution is O(n*k), by using an external function to check palindrome presence
	public static boolean kpalindrome(String input, int k)
	{
		while (k != 0)
		{
			StringBuilder sb = new StringBuilder(input);
			for (int i = 0; i < input.length(); i++)
			{
				sb = new StringBuilder(input);
				sb.deleteCharAt(i);
				if (isPalindrome(sb.toString()) == true)
				{
					System.out.println("YES");
					System.out.println(sb.toString());
					return true;
				}
			}
			k--;
		}
		System.out.println("NO");
		return false;
	}
	
	/******************************************************************************************************************************************/
	
	public static void main (String[] args) {
		String test = "aaba"; 
		String test4 = "axba"; 
		String test3 = "wwwwaaadexxxxxx";
		String test5 ="A man, a plan, a canal: Panama.";
		ArrayList<ArrayList<String>> test2 = new ArrayList<ArrayList<String>>();
		test2 = partition(test);
	    System.out.println(test2);
		kpalindrome(test4,1);
		System.out.println("Minimum Number of Cuts:" + minCuts(test));
		System.out.println("Longest Palindrome: " + longestPalindrome(test));
		System.out.println("String Compression: " + ReturnString(test3));
		System.out.println(isPalindrome2(test5));
	}
	
}
