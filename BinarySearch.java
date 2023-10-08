//Question : Binary Search in an Array
import java.util.*;

public class BinarySearch {
    public static int binSearch(int arr[], int key) {
        int start = 0;
        int end = arr.length-1;

        while(start <= end) {
            int mid = (end + start)/2;
            //case 1
            if(arr[mid] == key) {
                return mid;
            } 
            else if(arr[mid] < key) {
                start = mid + 1;
            }
            else {
                end = mid-1;
            }
        }

        return -1;
    }
    public static void main(String args[]) {
        System.out.println("Enter the size of Array");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element" + (i+1));
            arr[i]=sc.nextInt();
        }
        System.out.println("Which number do you want to search");
        int num = sc.nextInt();
        int idx = binSearch(arr, num);
        System.out.println("index is : " + idx);
        sc.close();
    }
}
