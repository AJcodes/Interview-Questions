import java.util.HashSet;


public class ConcantentationOfStrings {

	//You're given a dictionary of strings, and a key. Check if the key is composed of an arbitrary number of concatenations of strings from the dictionary. For example:

	//dictionary: "world", "hello", "super", "hell"
	//key: "helloworld" --> return true
	//key: "superman" --> return false
	//key: "hellohello" --> return true
	static String[] dic={"world","hello","super","hell"};

	static boolean isConcantentationOfOtherStrings(String word)
	{
		HashSet<String> hs=new HashSet<String>();
		
		for(String s: dic) hs.add(s);
		int len=word.length();

		boolean[] table=new boolean[len+1];	
		table[0]=true;	

		for(int i=0; i < len;i++)
		{
			for(int j=i; j >= 0;j--)
			{
				String subWord=word.substring(j,i+1);
				if(hs.contains(subWord))
				{
					if(table[j]) table[i+1]=true;
				}
			}
		}
		return table[len];
	}
	
	public static void main(String[] args) {
		System.out.println(isConcantentationOfOtherStrings("helloworld"));
		System.out.println(isConcantentationOfOtherStrings("superman"));
		System.out.println(isConcantentationOfOtherStrings("hellohello"));

	}
	
}
