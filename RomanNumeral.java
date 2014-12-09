

public class RomanNumeral {
	
	//Convert a string of Roman numerals to an integer in O(n) time
	//arrays can access any index in O(1); thus, this algorithm works in O(n)
	public static int Roman2Num(String a){
		int sum = 0;
		int cur = 1001;
		int pre = 0;
		for (int i = 0; i<a.length(); i++){
			switch (a.charAt(i)){
				case 'I': cur = 1;
					break;
				case 'V': cur = 5;
					break;
				case 'X': cur = 10;
					break;
				case 'L': cur = 50;
					break;
	            case 'C': cur = 100;
	                break;
				case 'D': cur = 500;
					break;
				case 'M': cur = 1000;
					break;
			}
			if (cur <= pre)
				sum += cur;
			else
				sum = sum - pre - pre + cur;
			pre = cur;
		}
	    return sum;
	}
	
	public static void main(String[] args)
	{
		System.out.println(Roman2Num("IV"));
		System.out.println(Roman2Num("DXIV"));
	}
	
}
