import java.util.Scanner;


public class PeakElement {

	//The following program uses binary search approach to find a peak element. 
	//Time complexity: O(log n).
    public static void peak(int[] arr)

    {
        peak(arr, 0, arr.length - 1);
    }    

    public static void peak(int arr[], int low, int high)

    {
        int N = arr.length;
        if (high - low < 2)
            return;

        int mid = (low + high) / 2;
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
            System.out.print(arr[mid] +" ");

        /* Recursively find other peak elements */        
        peak (arr, low, mid);
        peak (arr, mid, high);    
    }        
    
    //Brute force method
    //Time complexity: O(n)
    public static void main(String[] args)

    {    
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of array");
        int N = scan.nextInt();
        int[] arr = new int[N + 2];
        /* set corner values to -infinity */
        arr[0] = Integer.MIN_VALUE;
        arr[N + 1] = Integer.MIN_VALUE;

        /* Accept N elements */
        System.out.println("Enter "+ N +" elements");
        for (int i = 1; i <= N; i++)
            arr[i] = scan.nextInt();

         /* Find All Peak Elements */
        System.out.println("\nAll Peak Elements : ");
        for (int i = 1; i <= N; i++)
            if (arr[i - 1] <= arr[i] && arr[i] >= arr[i + 1])
                System.out.println(arr[i] +" at position "+ i);

        System.out.println();    

    }         
}
