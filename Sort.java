import java.util.Arrays;
import java.util.Random;

public class Sort {

  public static void insertionSort(int[] arr) {
    // loops around the array and moves every element to it's correct index
    for (int i = 1; i < arr.length; i++) {
      // the array to be inserted
      int toInsert = arr[i];
      // reference index to the array
      int j = i;
      // loops until toInsert is greater than the previous element or j < 0
      while (j > 0 && toInsert < arr[j - 1]) {
        // switches an element with the previous one
        arr[j] = arr[j - 1];
        // decrements the reference index to check the previous elements
        j--;
      }
      // inserts the element at the correct spot
      arr[j] = toInsert;
    }

  }

  public static void quickSort(int[] arr) {
    // calls the helper method qSort to sort the array
    qSort(arr, 0, arr.length - 1);

  }

  // helper method qSort
  private static void qSort(int[] arr, int lower, int higher) {
    // the base, the right pointer has crossed with the left pointer
    if (lower >= higher) {
      return;
    }
    // chooses a pivot randomly among the array elements to be sorted
    int p = new Random().nextInt(higher - lower) + lower;
    int pivot = arr[p];
    // swaps the last element with the pivot
    swap(arr, p, higher);
    // splits the array into halves
    int split = partition(arr, lower, higher, pivot);
    // sorts the left array
    qSort(arr, lower, split - 1);
    // sorts the right array
    qSort(arr, split + 1, higher);
  }

  // helper method for partition
  public static int partition(int[] arr, int lower, int higher, int pivot) {
    // left pointer
    int i = lower;
    // right pointer
    int j = higher;
    // loops half way from right to left and left to right
    while (i < j) {
      // increments left pointer when the element is less than the pivot
      while (arr[i] <= pivot && i < j) {
        i++;
      }
      // decrements the right pointer when the element is greater than the pivot
      while (arr[j] >= pivot && i < j) {
        j--;
      }
      // swaps the left and right element accordingly
      swap(arr, i, j);
    }
    // finally swaps the pivot with the largest element
    swap(arr, i, higher);
    // returns the index of the partitioning point
    return i;
  }

  // swap helper method
  public static void swap(int[] arr, int lower, int higher) {
    // temporarily stores the element of the lower index
    int temp = arr[lower];
    // assigns the lower index position to the higher element
    arr[lower] = arr[higher];
    // assigns the higher element to the temporary stored lower element
    arr[higher] = temp;
  }

  public static void mergeSort(int[] arr) {
    // the base case, when the array only has one element
    if (arr.length < 2) {
      return;
    }
    // splits the array into two halves: left and right
    int mid = arr.length / 2;
    // the left half
    int[] left = new int[mid];
    // the right half
    int[] right = new int[arr.length - mid];
    // populates the left and right arrays with their correct elements
    for (int i = 0; i < mid; i++) {
      // assigns the first elements of the array to the left array
      left[i] = arr[i];
    }

    for (int i = mid; i < arr.length; i++) {
      // assigns the remaining elements to the right array
      right[i - mid] = arr[i];
    }
    // mergeSort each half
    mergeSort(left);
    mergeSort(right);
    // merges the left and right arrays
    merge(arr, left, right);
  }

  // the helper method to merge two arrays into another array
  private static void merge(int[] arr, int[] left, int[] right) {
    // i => left pointer, j => right pointer, k => index to arr
    int i = 0, j = 0, k = 0;
    // loops and merges elements from right and left to arr accordingly
    while (i < left.length && j < right.length) {
      // checks if the left element is the smallest, adds it to arr
      if (left[i] <= right[j]) {
        arr[k] = left[i];
        i++;
      }
      // the right element is the smallest, so adds it to arr
      else {
        arr[k] = right[j];
        j++;
      }
      k++;
    }
    // if there are elements remaining in the left, they are added to arr
    while (i < left.length) {
      arr[k++] = left[i++];
    }
    // if there are elements remaining in the right, they are added to arr
    while (j < right.length) {
      arr[k++] = right[j++];
    }

  }

  public static int[] randomArray(int n, int a, int b) {
    // creates an array to be returned
    int[] arr = new int[n];
    // loops through n and adds integers to arr accordingly
    for (int i = 0; i < n; i++) {
      // gets a random integer and ensures that it's less or equal to b
      int x = ((int) (Math.random() * 1000000)) % (b + 1);
      // if the integer is less than a, gets another random integer
      while (x < a) {
        x = ((int) (Math.random() * 1000000)) % (b + 1);
      }
      // adds the integer to arr
      arr[i] = x;
    }
    return arr;
  }

  // extra credit selection sort method
  public static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int j = smallestIndex(arr, i, arr.length);
      swap(arr, j, i);
    }
  }

  // private method to find the index of the smallest array value in a given
  // interval
  private static int smallestIndex(int[] arr, int start, int end) {
    int temp = start;
    for (int i = start; i < end; i++) {
      if (arr[i] < arr[temp]) {
        temp = i;
      }
    }
    return temp;
  }

  public static void main(String[] args) {
    System.out.println("......................n = 10...............................");
    int[] arr = Sort.randomArray(10, 1, 100);
    long s1 = System.nanoTime();
    Sort.insertionSort(arr);
    long s2 = System.nanoTime();
    System.out.println("for n = 10, time taken for Insertion method is " + (s2 - s1));

    arr = Sort.randomArray(10, 1, 100);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.mergeSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 10, time taken for mergeSort method is " + (s2 - s1));

    arr = Sort.randomArray(10, 1, 100);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.quickSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 10, time taken for quickSort method is " + (s2 - s1));

    arr = Sort.randomArray(10, 1, 100);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.selectionSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 10, time taken for selectionSort method is " + (s2 - s1));

    System.out.println("......................n = 20...............................");
    s1 = s2 = 0;
    arr = Sort.randomArray(20, 1, 100);
    s1 = System.nanoTime();
    Sort.insertionSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 20, time taken for Insertion method is " + (s2 - s1));

    arr = Sort.randomArray(20, 1, 100);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.mergeSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 20, time taken for mergeSort method is " + (s2 - s1));

    arr = Sort.randomArray(20, 1, 100);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.quickSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 20, time taken for quickSort method is " + (s2 - s1));

    arr = Sort.randomArray(20, 1, 100);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.selectionSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 20, time taken for selectionSort method is " + (s2 - s1));

    System.out.println("......................n = 50.............................");
    arr = Sort.randomArray(50, 1, 100);
    s1 = System.nanoTime();
    Sort.insertionSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 50, time taken for Insertion method is " + (s2 - s1));

    arr = Sort.randomArray(50, 1, 100);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.mergeSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 50, time taken for mergeSort method is " + (s2 - s1));

    arr = Sort.randomArray(50, 1, 100);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.quickSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 50, time taken for quickSort method is " + (s2 - s1));

    arr = Sort.randomArray(50, 1, 100);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.selectionSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 50, time taken for selectionSort method is " + (s2 - s1));

    System.out.println("......................n = 100.............................");
    arr = Sort.randomArray(100, 1, 1000);
    s1 = System.nanoTime();
    Sort.insertionSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 100, time taken for Insertion method is " + (s2 - s1));

    arr = Sort.randomArray(100, 1, 1000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.mergeSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 100, time taken for mergeSort method is " + (s2 - s1));

    arr = Sort.randomArray(100, 1, 1000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.quickSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 100, time taken for quickSort method is " + (s2 - s1));

    arr = Sort.randomArray(100, 1, 1000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.selectionSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 100, time taken for selectionSort method is " + (s2 - s1));

    System.out.println("......................n = 200.............................");
    arr = Sort.randomArray(200, 1, 1000);
    s1 = System.nanoTime();
    Sort.insertionSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 200, time taken for Insertion method is " + (s2 - s1));

    arr = Sort.randomArray(200, 1, 1000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.mergeSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 200, time taken for mergeSort method is " + (s2 - s1));

    arr = Sort.randomArray(200, 1, 1000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.quickSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 200, time taken for quickSort method is " + (s2 - s1));

    arr = Sort.randomArray(200, 1, 1000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.selectionSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 200, time taken for selectionSort method is " + (s2 - s1));

    System.out.println("......................n = 500.............................");
    arr = Sort.randomArray(500, 1, 10000);
    s1 = System.nanoTime();
    Sort.insertionSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 500, time taken for Insertion method is " + (s2 - s1));

    arr = Sort.randomArray(500, 1, 10000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.mergeSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 500, time taken for mergeSort method is " + (s2 - s1));

    arr = Sort.randomArray(500, 1, 10000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.quickSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 500, time taken for quickSort method is " + (s2 - s1));

    arr = Sort.randomArray(500, 1, 10000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.selectionSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 500, time taken for selectionSort method is " + (s2 - s1));

    System.out.println("......................n = 1000.............................");
    arr = Sort.randomArray(1000, 1, 10000);
    s1 = System.nanoTime();
    Sort.insertionSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 1000, time taken for Insertion method is " + (s2 - s1));

    arr = Sort.randomArray(1000, 1, 10000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.mergeSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 1000, time taken for mergeSort method is " + (s2 - s1));

    arr = Sort.randomArray(1000, 1, 10000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.quickSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 1000, time taken for quickSort method is " + (s2 - s1));

    arr = Sort.randomArray(1000, 1, 10000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.selectionSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 1000, time taken for selectionSort method is " + (s2 - s1));

    System.out.println("......................n = 2000.............................");
    arr = Sort.randomArray(2000, 1, 10000);
    s1 = System.nanoTime();
    Sort.insertionSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 2000, time taken for Insertion method is " + (s2 - s1));

    arr = Sort.randomArray(2000, 1, 10000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.mergeSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 2000, time taken for mergeSort method is " + (s2 - s1));

    arr = Sort.randomArray(2000, 1, 10000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.quickSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 2000, time taken for quickSort method is " + (s2 - s1));

    arr = Sort.randomArray(2000, 1, 10000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.selectionSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 2000, time taken for selectionSort method is " + (s2 - s1));

    System.out.println("......................n = 5000.............................");
    arr = Sort.randomArray(5000, 1, 10000);
    s1 = System.nanoTime();
    Sort.insertionSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 5000, time taken for Insertion method is " + (s2 - s1));

    arr = Sort.randomArray(5000, 1, 10000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.mergeSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 5000, time taken for mergeSort method is " + (s2 - s1));

    arr = Sort.randomArray(5000, 1, 10000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.quickSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 5000, time taken for quickSort method is " + (s2 - s1));

    arr = Sort.randomArray(5000, 1, 10000);
    s1 = s2 = 0;
    s1 = System.nanoTime();
    Sort.selectionSort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 5000, time taken for selectionSort method is " + (s2 - s1));

    System.out.println("...................... Java built-in sorting with n = 5000.............................");
    arr = Sort.randomArray(5000, 1, 10000);
    s1 = System.nanoTime();
    Arrays.sort(arr);
    s2 = System.nanoTime();
    System.out.println("for n = 5000, time taken for Array built in sort is " + (s2 - s1));
  }
}
