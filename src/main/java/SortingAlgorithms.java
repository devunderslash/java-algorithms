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