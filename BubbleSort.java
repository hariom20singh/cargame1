import java.util.*;

//Problem : Bubble Sort

public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        for(int turn=0; turn<arr.length-1; turn++) {
            for(int j=0; j<arr.length-1-turn; j++) {
                if(arr[j] > arr[j+1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        System.out.println("Enter the size of array");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            System.out.println("Enter element " + (i+1));
            arr[i] = sc.nextInt();
        }
    
        bubbleSort(arr);
        System.out.println("Sorted Array:");
        printArr(arr);
    }
}
