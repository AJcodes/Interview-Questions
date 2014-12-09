import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramCheck {
   
    /*
     * One way to find if two Strings are anagram in Java. This method
     * assumes both arguments are not null and in lowercase.
     *
     * @return true, if both String are anagram
     */
    public static boolean isAnagram(String word, String anagram){       
        if(word.length() != anagram.length()){
            return false;
        }
       
        char[] chars = word.toCharArray();
       
        for(char c : chars){
            int index = anagram.indexOf(c);
            if(index != -1){
                anagram = anagram.substring(0,index) + anagram.substring(index + 1, anagram.length());
            }else{
                return false;
            }           
        }
        return anagram.isEmpty();
    }
   
    /*
     * Another way to check if two Strings are anagram or not in Java
     * This method assumes that both word and anagram are not null and lowercase
     * @return true, if both Strings are anagram.
     */
    public static boolean isAnagram2(String word, String anagram){
        char[] charFromWord = word.toCharArray();
        char[] charFromAnagram = anagram.toCharArray();       
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);
       
        return Arrays.equals(charFromWord, charFromAnagram);
    }
   
   
    public static boolean checkAnagram(String first, String second){
        char[] characters = first.toCharArray();
        StringBuilder sbSecond = new StringBuilder(second);
       
        for(char ch : characters){
            int index = sbSecond.indexOf("" + ch);
            if(index != -1){
                sbSecond.deleteCharAt(index);
            }else{
                return false;
            }
        }
       
        return sbSecond.length()==0 ? true : false;
    }
    
    /************************************************************************************************************************************************/
    
    //Input - List<String> ["star", "rats", "ice", "cie", "arts"]
    //print all anagrams in buckets:
    //	["star", "rats", "arts"]
    //	["ice", "cie"]
    
    //This question assumes that there is no isAnagram function available. But what if there was?
    
    //Our implementation will take advantage of hashing and string sorting.
	//This is O(n*mlog(m)) where m is the length of average string, n=# strings.
	//We first sort each string using quicksort on the characters.
	//Then, hash the sorted strings into numbers which takes O(n*m). 
	//Then we make one more pass and dump them into buckets.
    public static void anagramBuckets(List<String> input)
    {
    	HashMap<Integer, List<String>> map = 
				new HashMap<Integer, List<String>>();
		
		for (int i=0; i<input.size(); i++) {
			String srtedstr = sortstr(input.get(i));
			int code = srtedstr.hashCode();
			if (map.containsKey(code)) {
				map.get(code).add(input.get(i));
			}
			else {
				List<String> z = new ArrayList<String>();
				z.add(input.get(i));
				map.put(code, z);
			}
		}
		
		/*for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
			System.out.println("Key " + entry.getKey() + 
				" bucket: " + entry.getValue().toString());
		}*/
		System.out.println(map);
    }
    
    //Assumption is if there is already an isAnagram function to use
    public static void anagramBuckets2(List<String> input)
    {
    	List<List<String>> bucket = new ArrayList<List<String>>();
		int i = 0;
		int move = 0;
		while (i < input.size())
		{
			String t = input.get(i);
			for (List<String> test:bucket)
			{
				if(test.contains(t))
				{
					i++;
					move = 1;
					break;
				}
				else move = 0;
			}
			if (move == 0)
			{
				List<String> result = new ArrayList<String>();
				for (int j=0; j<input.size(); j++) {
					if (isAnagram2(t, input.get(j)))
					{
						result.add(input.get(j));
					}
				}
				bucket.add(result);
				i++;
			}
		}
		System.out.println(bucket);
    }
    
    static String sortstr(String str) {
		/* encapsulating original sortstr method */
		char[] chararr = str.toCharArray();
		sortstr(chararr, 0, str.length()-1);
		return new String(chararr);
	}
	
	static void sortstr(char[] arrchar, int start, int end) {
		/* inplace quicksort, car=>acr */
		if (start > end)
			return;
		
		int piv = arrchar[end];
		int lo = start;
		int hi = end;
		while (lo <= hi) {
			while (arrchar[lo] < piv)
				lo += 1;
			while (arrchar[hi] > piv)
				hi -= 1;
			if (lo <= hi) {
				char tmp = arrchar[lo];
				arrchar[lo] = arrchar[hi];
				arrchar[hi] = tmp;
				lo += 1;
				hi -= 1;
			}
		}
		sortstr(arrchar, start, hi);
		sortstr(arrchar, lo, end);
	}
    
	/************************************************************************************************************************************************************/
	
	
    public static void main(String[] args) {
		String input = "neni";
		String test = "nine";
		List<String> input2 = new ArrayList<String>();
		input2.add("star");
		input2.add("rats");
		input2.add("ics");
		input2.add("cie");
		input2.add("arts");
		anagramBuckets(input2);
		anagramBuckets2(input2);
		System.out.println(isAnagram2(input,test));
		
	}
}


