package practice.sort;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

  @Test
  public void sortsRandomArray() {
    int[] data = {10, 99, 12, 14, 15, 23, 33, 66, 72, 85, 96};
    QuickSort.sort(data);
    assertArrayEquals(new int[]{10, 12, 14, 15, 23, 33, 66, 72, 85, 96, 99}, data);
  }

  @Test
  public void sortsReverseSortedArray() {
    int[] data = {5, 4, 3, 2, 1};
    QuickSort.sort(data);
    assertArrayEquals(new int[]{1, 2, 3, 4, 5}, data);
  }

  @Test
  public void sortsAlreadySortedArray() {
    int[] data = {1, 2, 3, 4, 5};
    QuickSort.sort(data);
    assertArrayEquals(new int[]{1, 2, 3, 4, 5}, data);
  }

  @Test
  public void sortsArrayWithDuplicates() {
    int[] data = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
    QuickSort.sort(data);
    assertArrayEquals(new int[]{1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9}, data);
  }

  @Test
  public void sortsSingleElement() {
    int[] data = {42};
    QuickSort.sort(data);
    assertArrayEquals(new int[]{42}, data);
  }

  @Test
  public void sortsEmptyArray() {
    int[] data = {};
    QuickSort.sort(data);
    assertArrayEquals(new int[]{}, data);
  }

  @Test
  public void sortsNullArrayDoesNotThrow() {
    assertDoesNotThrow(() -> QuickSort.sort(null));
  }

  @Test
  public void sortsNegativeNumbers() {
    int[] data = {-3, -1, -4, -1, -5, 0, 2};
    QuickSort.sort(data);
    assertArrayEquals(new int[]{-5, -4, -3, -1, -1, 0, 2}, data);
  }

  @Test
  public void mainRunsWithoutError() {
    assertDoesNotThrow(() -> QuickSort.main(new String[]{}));
  }
}
