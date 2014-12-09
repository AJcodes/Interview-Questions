
public class ReverseWords {

	public static String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
 
		// split to words by space
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}
	
	public static String reverseString(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		String reverse = "";
		int length = s.length();
		 
	    for ( int i = length - 1 ; i >= 0 ; i-- )
	        reverse = reverse + s.charAt(i);

		return reverse;
	}
	
	//Time: O(n)
	//Find length of longest substring
	public static int longestTwoDistinctCharacterSubString(String str) {

	    int longest = 0;
	    int startIndex = 0;
	    int currentConsecutiveCount = 1;

	    Character firstDistinctChar = null;
	    Character secondDistinctChar = null;

	    for (int i = 0; i < str.length(); i++) {
	        Character charAtPreviousIndex = (i > 0) ? str.charAt(i - 1) : null;
	        Character charAtCurrentIndex = str.charAt(i);

	        if ((firstDistinctChar != null && firstDistinctChar.equals(charAtCurrentIndex)) || 
	            (secondDistinctChar != null && secondDistinctChar.equals(charAtCurrentIndex))) {
	            // continue with function
	        } else if (firstDistinctChar == null) {
	            firstDistinctChar = charAtCurrentIndex;
	        } else if (secondDistinctChar == null) {
	            secondDistinctChar = charAtCurrentIndex;
	        } else {
	            int length = i - startIndex;
	            if (length > longest) {
	                longest = length;
	            }

	            firstDistinctChar = null;
	            secondDistinctChar = null;
	            startIndex = i - currentConsecutiveCount;
	        }

	        if (charAtCurrentIndex.equals(charAtPreviousIndex)) {
	            currentConsecutiveCount++;
	        } else {
	            currentConsecutiveCount = 1;
	        }
	    }

	    return longest;
	}
	
	//Code a function that receives a string composed by words separated by spaces and returns a string where
	//words appear in the same order but than the original string, but every word is inverted.
	//Example, for this input string

	//@"the boy ran"

	//the output would be

	//@"eht yob nar"

	//Tell the complexity of the solution.
	
	//Space O(N), Time O(N)
	public static String reverse(String input){
		if(input == null){
			return null;
		}		
		String output = "";
		String tmp = String.valueOf(input.charAt(0));
		for(int i = 1; i < input.length(); i++){
			if(input.charAt(i) ==' '){
				output = output + tmp + ' ';
				tmp = "";
			}else{
				tmp = input.charAt(i) + tmp;
			}
		}
                //Append last word
		output = output + tmp;
		return output;
	}
	
	public static void main(String[] args) {
	    System.out.println(reverseWords("the sky is blue"));    
	    System.out.println(reverseString("the sky is blue")); 
	    System.out.println(reverse("the sky is blue"));
	    System.out.println(longestTwoDistinctCharacterSubString("abcbbbbcccbdddadacb"));
	}
	
}
