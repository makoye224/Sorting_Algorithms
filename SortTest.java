import org.junit.*;
import static org.junit.Assert.*;

public class SortTest {

  @Test
  public void insertionSortTest() {
    int[] arr = new int[] { 5, 6, 8, 3, 10, 75, 2, 1, -4 };
    Sort.insertionSort(arr);
    assertEquals(-4, arr[0]);
    assertEquals(1, arr[1]);
    assertEquals(2, arr[2]);
    assertEquals(3, arr[3]);
    assertEquals(5, arr[4]);
    assertEquals(6, arr[5]);
    assertEquals(8, arr[6]);
    assertEquals(10, arr[7]);
    assertEquals(75, arr[8]);

  }

  @Test
  public void quickSortTest() {
    int[] arr = new int[] { 5, 6, 8, 3, 10, 75, 2, 1, -4 };
    Sort.quickSort(arr);
    assertEquals(-4, arr[0]);
    assertEquals(1, arr[1]);
    assertEquals(2, arr[2]);
    assertEquals(3, arr[3]);
    assertEquals(5, arr[4]);
    assertEquals(6, arr[5]);
    assertEquals(8, arr[6]);
    assertEquals(10, arr[7]);
    assertEquals(75, arr[8]);

  }

  @Test
  public void mergeSortTest() {
    int[] arr = new int[] { 5, 6, 8, 3, 10, 75, 2, 1, -4 };
    Sort.mergeSort(arr);
    assertEquals(-4, arr[0]);
    assertEquals(1, arr[1]);
    assertEquals(2, arr[2]);
    assertEquals(3, arr[3]);
    assertEquals(5, arr[4]);
    assertEquals(6, arr[5]);
    assertEquals(8, arr[6]);
    assertEquals(10, arr[7]);
    assertEquals(75, arr[8]);

  }

  @Test
  public void randomArraySortTest() {
    int[] arr = Sort.randomArray(5, 10, 50);
    assertEquals(5, arr.length);
    assertEquals(true, arr[0] >= 10 && arr[0] <= 50);
    assertEquals(true, arr[1] >= 10 && arr[0] <= 50);
    assertEquals(true, arr[2] >= 10 && arr[0] <= 50);
    assertEquals(true, arr[3] >= 10 && arr[0] <= 50);
    assertEquals(true, arr[4] >= 10 && arr[0] <= 50);

  }

  @Test
  public void selectionSortTest() {
    int[] arr = new int[] { 5, 6, 8, 3, 10, 75, 2, 1, -4 };
    Sort.selectionSort(arr);
    assertEquals(-4, arr[0]);
    assertEquals(1, arr[1]);
    assertEquals(2, arr[2]);
    assertEquals(3, arr[3]);
    assertEquals(5, arr[4]);
    assertEquals(6, arr[5]);
    assertEquals(8, arr[6]);
    assertEquals(10, arr[7]);
    assertEquals(75, arr[8]);

  }

}
