
public class ExcelColumn {

	//Microsoft Excel numbers cells as 1...26 and after that AA, AB.... AAA, AAB...ZZZ and so on.
	//Given a number, convert it to that format and vice versa.
	
	public static String Column(int n)
	{
		int dividend = n;
	    String columnName = "";
	    int modulo;

	    while (dividend > 0)
	    {
	    	
	        modulo = (dividend - 1) % 26;
	        columnName = Character.toString ((char) (65 + modulo)) + columnName;
	        dividend = (int)((dividend - modulo) / 26);
	    } 

	    return columnName;
	}
	
	public static void main(String[] args)
	{
		System.out.println(Column(29));
	}
	
}
