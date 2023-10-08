 # Sorting

## Stable

Stable sorting algorithms maintain the relative order of equal elements in the sorted output as they were in the original input. In other words, if two elements A and B are equal in the input, and A appears before B, then A will still appear before B in the sorted output.

Some common stable sorting algorithms include:
- Bubble Sort
- Insertion Sort
- Merge Sort
- Tim Sort
- Counting Sort

## Unstable

Unstable sorting algorithms do not necessarily maintain the relative order of equal elements in the sorted output. This means that if two elements A and B are equal in the input, the order of A and B in the sorted output may not be the same as their order in the input.

Some common unstable sorting algorithms include:
- Quick Sort
- Heap Sort
- Selection Sort
- Shell Sort
- Radix Sort (when used with certain implementations)

We shall discuss one from each domain that is unstable and stable

## Merge Sort
- **Merge Sort Algorithm**

`
Merge Sort is a stable sorting algorithm
`

*Merge sort is based on Divide and Conquer*
  1. Divide the unsorted list into n sublists, each containing one element.
  2. Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining.
     - Divide: Split the list into two equal halves.
     - Conquer: Recursively sort each sublist.
     - Combine: Merge the sorted sublists back together to create a single sorted list.
  3. The final merged list is now sorted.

- **Key Features**
   - Merge Sort is a divide-and-conquer sorting algorithm.
   - It is a stable sorting algorithm, preserving the relative order of equal elements.
   - Merge Sort has a time complexity of O(n log n), making it efficient for large datasets.
   - It requires additional space for creating temporary sublists during the merging phase, making it less memory-efficient than some other algorithms.

- **Code**
```java
// MergeSort function that takes an array and sorts it using Merge Sort
void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        // Find the middle point to divide the array into two halves
        int mid = (left + right) / 2;

        // Recursively sort the first and second halves
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // Merge the sorted halves
        merge(arr, left, mid, right);
    }
}

// Merge function to merge two subarrays of arr[].
// First subarray is arr[left..mid]
// Second subarray is arr[mid+1..right]
void merge(int[] arr, int left, int mid, int right) {
    // Find sizes of two subarrays to be merged
    int n1 = mid - left + 1;
    int n2 = right - mid;

    // Create temporary arrays
    int[] leftArray = new int[n1];
    int[] rightArray = new int[n2];

    // Copy data to temporary arrays leftArray[] and rightArray[]
    for (int i = 0; i < n1; i++) {
        leftArray[i] = arr[left + i];
    }
    for (int j = 0; j < n2; j++) {
        rightArray[j] = arr[mid + 1 + j];
    }

    // Merge the two arrays
    int i = 0, j = 0;
    int k = left;
    while (i < n1 && j < n2) {
        if (leftArray[i] <= rightArray[j]) {
            arr[k] = leftArray[i];
            i++;
        } else {
            arr[k] = rightArray[j];
            j++;
        }
        k++;
    }

    // Copy remaining elements of leftArray[] if any
    while (i < n1) {
        arr[k] = leftArray[i];
        i++;
        k++;
    }

    // Copy remaining elements of rightArray[] if any
    while (j < n2) {
        arr[k] = rightArray[j];
        j++;
        k++;
    }
}
```


- **Advantages**
- Stable sorting, suitable for applications requiring stable order.
- Efficient for sorting large datasets.
- Well-suited for sorting linked lists.

- **Disadvantages**
- Requires additional memory space for temporary sublists.
- Not the fastest sorting algorithm for small datasets.
- Has a time complexity of O(n log n), which may not be the best choice for already nearly sorted data.


# Quick Sort

**Quick Sort Algorithm**

`
Quick Sort is a unstable sorting algorithm
`

Quick Sort is a highly efficient and widely used sorting algorithm that uses a divide-and-conquer approach.

1. Choose a "pivot" element from the array.
2. Partition the array into two subarrays: elements less than the pivot and elements greater than the pivot.
3. Recursively apply Quick Sort to the two subarrays.
4. Combine the sorted subarrays and the pivot to produce the sorted array.

**Key Features**
   - Quick Sort is a divide-and-conquer sorting algorithm.
   - It is an unstable sorting algorithm, meaning it may not preserve the relative order of equal elements.
   - Quick Sort is known for its average-case time complexity of O(n log n), making it efficient for most scenarios.
   - In the worst case, it can have a time complexity of O(n^2), but this is rare and can be mitigated with proper pivot selection strategies.

**Code**

```java
// QuickSort function that takes an array and sorts it using Quick Sort
void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        // Partition the array into two subarrays
        int pivotIndex = partition(arr, low, high);

        // Recursively sort the subarrays
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }
}

// Partition function to select a pivot and reorder the array
int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);

    for (int j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i++;

            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // Swap arr[i+1] and arr[high] (pivot)
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
}
``````

- **Advantages**

- Quick Sort is efficient for large datasets and is often faster than many other sorting algorithms.
- It has good cache performance due to its divide-and-conquer approach.
- It is an in-place sorting algorithm, requiring minimal additional memory.

- **Disadvantages**
- It can have a worst-case time complexity of O(n^2) if the pivot selection is poor, but this is rare with proper pivot strategies.
- Quick Sort is not stable, meaning it may change the order of equal elements.
- The choice of pivot can impact its performance.