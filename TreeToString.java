
public class TreeToString {
	
	//Serialize a Binary Tree to String
	public static String TreeToString(Node node)
	{
		String str = "";
		if (node == null)
	       {
	           return str + " ";
	       }
	       else
	       {
	    	   str = str + node.data + " ";
	    	   if (node.left != null || node.right != null)
	    	   {
	    		   str = str + TreeToString(node.left);
	    		   str = str + TreeToString(node.right);
	    	   }
   
	       }
		return str;
	}
	
	//Deserialize a String to Binary Tree
	//assuming order of nodes are as the TreeToString order
	public static Node StringToTree(String input, int index)
	{
		Node root = null, left = null, right = null;
		String [] arr = input.split(" ", 2);
		if (arr[1].length() > 0 && index % 2 == 0)
		{
			left = StringToTree(arr[1], index++);
		}
		else if (arr[1].length() > 0 && index % 2 == 1)
		{
			right = StringToTree(arr[1], index++);
		}
		root = new Node(Integer.parseInt(arr[0]));
		root.left = left;
		root.right = right;
		return root;
	}
	
	public static void main(String[] args) 
    {
    	Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(22);
        Node e = new Node(40);
        b.left = a;
        b.right = c;
        c.left = d;
        c.right = e;
        String tests = TreeToString(b);
        System.out.println(tests);
        Node root = StringToTree(tests, 0);
        System.out.println(TreeToString(root));
        
     }
	
}

class Node 
{
    Node left;
    Node right;
    int data;
    public Node(int i) 
    {
        this.data = i;
    }
}