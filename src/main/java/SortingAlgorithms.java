// The following class contains 3 sorting algortithm methods that accepts an array of integers
// and sorts them in ascending order. The methods are bubbleSort, selectionSort, and insertionSort.
// The class also contains a main method that tests the sorting methods with an example array.
// The class has a main method where the tests and input can be controlled


public class SortingAlgorithms {

    // Bubble Sort algorithm
    // Explanation of Bubble Sort:
    // Bubble Sort is a simple sorting algorithm that repeatedly steps through the list,
    // compares adjacent elements and swaps them if they are in the wrong order.
    // The pass through the list is repeated until the list is sorted.
    // The algorithm gets its name because smaller elements "bubble" to the top of the list.
    // Time Complexity: O(n^2) in the worst and average case, O(n) in the best case (when the array is already sorted).
    // Resource - https://www.geeksforgeeks.org/bubble-sort-algorithm/
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort algorithm
    // Explanation of Selection Sort:
    // Selection Sort is a simple sorting algorithm that divides the input list into two parts:
    // a sorted part and an unsorted part. It repeatedly selects the smallest (or largest) element
    // from the unsorted part and moves it to the end of the sorted part.
    // The algorithm maintains two subarrays in a given array:
    // 1. The subarray which is already sorted.
    // 2. The remaining subarray which is unsorted.
    // In each iteration, the minimum element from the unsorted subarray is picked and moved to the sorted subarray.
    // Time Complexity: O(n^2) in all cases (worst, average, and best).
    // Resource - https://www.geeksforgeeks.org/selection-sort/
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // Insertion Sort algorithm
    // Explanation of Insertion Sort:
    // Insertion Sort is a simple sorting algorithm that builds the final sorted array (or list)
    // one item at a time. It is much less efficient on large lists than more advanced algorithms
    // such as quicksort, heapsort, or merge sort.
    // The algorithm works by dividing the array into a sorted and an unsorted part.
    // It iterates through the array, and for each element, it finds the correct position in the sorted part
    // and inserts it there. This process is repeated until the entire array is sorted.
    // Time Complexity: O(n^2) in the worst and average case, O(n) in the best case (when the array is already sorted).
    // Resource - https://www.geeksforgeeks.org/insertion-sort/
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Merge Sort algorithm
    // Explanation of Merge Sort:
    // Merge Sort is an efficient, stable, and comparison-based sorting algorithm.
    // It divides the unsorted list into n sublists, each containing one element,
    // and then repeatedly merges sublists to produce new sorted sublists until there is only one sublist remaining.
    // The algorithm works by recursively dividing the array into halves until each subarray contains a single element,
    // and then merging those subarrays back together in sorted order.
    // Time Complexity: O(n log n) in all cases (worst, average, and best).
    // Resource - https://www.geeksforgeeks.org/merge-sort/
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Heap Sort algorithm
    // Explanation of Heap Sort:
    // Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure.
    // It first builds a max heap from the input array, and then repeatedly extracts the maximum element
    // from the heap and rebuilds the heap until the array is sorted.
    // The algorithm works by first building a max heap from the input array, and then repeatedly
    // extracting the maximum element from the heap and placing it at the end of the array.
    // Time Complexity: O(n log n) in all cases (worst, average, and best).
    // Resource - https://www.geeksforgeeks.org/heap-sort/
    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    // Quick Sort algorithm
    // Explanation of Quick Sort:
    // Quick Sort is a divide-and-conquer algorithm that works by selecting a 'pivot' element
    // from the array and partitioning the other elements into two sub-arrays,
    // according to whether they are less than or greater than the pivot.
    // The sub-arrays are then sorted recursively.
    // Time Complexity: O(n log n) on average, O(n^2) in the worst case (when the array is already sorted).
    // Resource - https://www.geeksforgeeks.org/quick-sort/
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Helper method to create a random array or sorted array depending on the string input
    public static int[] createArray(String type, int size) {
        int[] arr = new int[size];
        if (type.equals("random")) {
            for (int i = 0; i < size; i++) {
                arr[i] = (int) (Math.random() * size);
            }
        } else if (type.equals("sorted")) {
            for (int i = 0; i < size; i++) {
                arr[i] = i;
            }
        }
        return arr;
    }


    // Helper method to print the array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    

    // Simple tests to check the sorting algorithms functionality
    public static void testFunctionality() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: ");
        printArray(arr);

        // Test Bubble Sort
        bubbleSort(arr);
        System.out.println("Sorted array using Bubble Sort: ");
        printArray(arr);

        // Reset the array for next test
        arr = new int[]{64, 34, 25, 12, 22, 11, 90};

        // Test Selection Sort
        selectionSort(arr);
        System.out.println("Sorted array using Selection Sort: ");
        printArray(arr);

        // Reset the array for next test
        arr = new int[]{64, 34, 25, 12, 22, 11, 90};

        // Test Insertion Sort
        insertionSort(arr);
        System.out.println("Sorted array using Insertion Sort: ");
        printArray(arr);
    }



    //  Test time complexity of each sorting algorithm  
    public static void testTimeComplexity(int size, String arrayType) {
        int[] arr; // Declare the array
        long startTime, endTime; // Declare timing variables 


        // --------- Testing Random Sorted Arrays ---------

        // Initialize array
        arr = createArray(arrayType, size);

        // Measure time taken by Bubble Sort
        startTime = System.nanoTime();
        bubbleSort(arr);
        endTime = System.nanoTime();
        System.out.println("   Bubble Sort Time for " + arrayType + " array of " + size + ": " + (endTime - startTime) + " ns");

        // Reset the array for next test
        arr = createArray(arrayType, size);

        // Measure time taken by Selection Sort
        startTime = System.nanoTime();
        selectionSort(arr);
        endTime = System.nanoTime();
        System.out.println("Selection Sort Time for " + arrayType + " array of " + size + ": " + (endTime - startTime) + " ns");

        // Reset the array for next test
        arr = createArray(arrayType, size);

        // Measure time taken by Insertion Sort
        startTime = System.nanoTime();
        insertionSort(arr);
        endTime = System.nanoTime();
        System.out.println("Insertion Sort Time for " + arrayType + " array of " + size + ": " + (endTime - startTime) + " ns");
    }


    // Main method to test the sorting algorithms
    public static void main(String[] args) {

        System.out.println("Testing sorting algorithms functionality:");
        testFunctionality();

        int size = 0; // Initialize size variable
        String arrayType = ""; // Initialize arrayType variable

        // Setting the size of the array for time complexity test
        size = 100; // You can change this value to test with different sizes
        arrayType = "random"; // You can change this to "sorted" or "random" to test different types of arrays
        System.out.println("\nTesting time complexity of sorting algorithms with random array size: " + size);
        testTimeComplexity(size, arrayType);

        // You can also test with sorted arrays
        arrayType = "sorted"; // Change to "sorted" for sorted arrays
        System.out.println("\nTesting time complexity of sorting algorithms with sorted array size: " + size);
        testTimeComplexity(size, arrayType);


        // You can also test with larger arrays
        size = 5000; // Change this value to test with larger arrays
        arrayType = "random"; // Change to "sorted" for sorted arrays
        System.out.println("\nTesting time complexity of sorting algorithms with random array size: " + size);
        testTimeComplexity(size, arrayType);
        // You can also test with sorted arrays
        arrayType = "sorted"; // Change to "sorted" for sorted arrays
        System.out.println("\nTesting time complexity of sorting algorithms with sorted array size: " + size);
        testTimeComplexity(size, arrayType);

    }

}