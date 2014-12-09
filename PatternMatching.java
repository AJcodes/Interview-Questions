
public class PatternMatching {

	//Pattern Matching
	//----------------
	//Characters: a to z
	//Operators: * +
	//* -> matches zero or more (of the character that occurs previous to this operator)
	//+ -> matches one or more (of the character that occurs previous to this operator)

	//Output if a given pattern matches a string.
	//Example:
	//pattern:a*b
	//string:aaab b, ab, aab, aaab, ab
	//output:1

	//pattern:a+aabc
	//string:ab aabc, aaabc, aaaabc ..
	//output:0

	//pattern:aa*b*ab+
	//string:aab aab, aabab, aaaabbab
	//output:1

	//pattern: a+a*b*
	//string: a ab, aab, aaabb
	//output: 1

	//Valid Assumptions: Please assume that both the pattern and string input are valid
	
	public static boolean isMatched(String regex, String str) {
        if (str.length() == 0) {
            // Match is true when regex is exhausted or it's last char is "*" - allowing optional str
            return regex.length() == 0 || regex.charAt(regex.length() - 1) == '*';
        }

        if (regex.length() == 0 || (regex.length() == 1 && regex.charAt(regex.length() - 1) == '*')) {
            // Match is true only if str is fully consumed
            return str.length() == 0;
        }

        Character curReg = regex.charAt(0);
        Character nextReg = regex.length() >= 2 ? regex.charAt(1) : null;
        Character curStr = str.length() != 0 ? str.charAt(0) : null;

        if (nextReg == null || (nextReg != '*' && nextReg != '+')) {
            // This is a simple match - just take the first char from both regex and str and recurse IFF current match is detected
            return isCharMatched(curReg, curStr) && isMatched(regex.substring(1), str.substring(1));
        } else {
            if (nextReg == '*') {
                // The current regex char is followed by "*" - create 2 branches:
                // - one with unmodified regex and reduced str IFF current match detected - meaning to continue repetition if possible
                // - the other one with reduced regex and unmodified str - meaning to try out the optional nature of "*"
                return (isCharMatched(curReg, curStr) && isMatched(regex, str.substring(1))) || isMatched(regex.substring(2), str);
            } else if (nextReg == '+') {
                // The current regex char is followed by "+" - reduce to 1 branch with "*" instead of "+"
                return isCharMatched(curReg, curStr) && isMatched(curReg + "*" + regex.substring(2), str.substring(1));
            } else {
                return false;
            }
        }
    }

    public static boolean isCharMatched(Character regexCh, Character strCh) {
        return regexCh == strCh || (regexCh == '.' && strCh >= 'a' && strCh <='z');
    }
    
    /***************************************************************************************************************************************/
    
    //Given a regular expression with characters a-z, ' * ', ' . '
    //the task was to find if that string could match another string with characters from: a-z
    //where ' * ' can delete the character before it, and ' . ' could match whatever character. ' * ' always appear after a a-z character.
    //Example:
    //isMatch("a*", "") = true;
    //isMatch(".", "") = false;
    //isMatch("ab*", "a") = true;
    //isMatch("a.", "ab") = true;
    //isMatch("a", "a") = true;
    
    public static boolean isMatch(String regex, String s)
    {
        return IsMatch(regex, s, regex.length() - 1, s.length() - 1);
    }

    public static boolean IsMatch(String regex, String s, int i, int j)
    {
        if (i < 0)
        {
            return j < 0;
        }

        boolean result = false;

        if (j >= 0)
        {
            if (regex.charAt(i) == '.' || regex.charAt(i) == s.charAt(j)) 
            	result |= IsMatch(regex, s, i - 1, j - 1);
        }

        if (regex.charAt(i) == '*') 
        	result |= IsMatch(regex, s, i - 2, j) || IsMatch(regex, s, i - 1, j);

        return result;
    }
    
    /***************************************************************************************************************************************/
    
    public static void main(String[] args) {
		System.out.println(isMatched("F.cebo*k","Ficebook"));
		System.out.println(isMatch("a.","ab"));
	}
}
