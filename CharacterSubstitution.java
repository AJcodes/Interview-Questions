import java.util.ArrayList;
import java.util.HashMap;

public class CharacterSubstitution {

	//Given a hashmap M which is a mapping of characters to arrays of substitute characters, 
	//and an input string S, return an array of all possible mutations of S (where any character in S 
	//can be substituted with one of its substitutes in M, if it exists).

	//What is the time complexity? What is the space complexity? Can you optimize either?

	//Example input:
	//M = { f: [F, 4], b: [B, 8] }
	//S = fab

	//Expected output:
	//[fab, Fab, 4ab, faB, FaB, 4aB, fa8, Fa8, 4a8]
	
	private static HashMap<String,ArrayList<String>> substitutesMap = new HashMap<String,ArrayList<String>>();
	
	private static void permute(String permutation, String input, int pos) {
		if(pos == input.length()) {
			System.out.println(permutation);
			return;
		}
		
		String letter = input.substring(pos,pos+1);
		
		ArrayList<String> substitutes = new ArrayList<String>();
		substitutes.add(letter);
		if(substitutesMap.get(letter) != null)
			substitutes.addAll(substitutesMap.get(letter));

		for(String substitute : substitutes)
			permute(permutation + substitute, input, pos+1);
	}
	
	
	
	/*
	 * TEST HARNESS
	 */
	
	static {
		 ArrayList<String> f = new ArrayList<String>();
		 f.add("F");
		 f.add("4");

		 ArrayList<String> b = new ArrayList<String>();
		 b.add("B");
		 b.add("8");
		 
		 substitutesMap.put("f", f);
		 substitutesMap.put("b", b);
	};


	public static void main(String args[]) {
		permute("", "fab", 0);
	}
	
}
