package practice.search;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

  private final int[] data = {10, 12, 14, 15, 23, 33, 66, 72, 85, 96, 99};

  @Test
  public void findsFirstElement() {
    assertEquals(0, BinarySearch.search(data, 10));
  }

  @Test
  public void findsLastElement() {
    assertEquals(10, BinarySearch.search(data, 99));
  }

  @Test
  public void findsMiddleElement() {
    assertEquals(5, BinarySearch.search(data, 33));
  }

  @Test
  public void findsElementBeforeMiddle() {
    assertEquals(1, BinarySearch.search(data, 12));
  }

  @Test
  public void findsElementAfterMiddle() {
    assertEquals(8, BinarySearch.search(data, 85));
  }

  @Test
  public void returnsMinusOneWhenSmallerThanAll() {
    assertEquals(-1, BinarySearch.search(data, 1));
  }

  @Test
  public void returnsMinusOneWhenLargerThanAll() {
    assertEquals(-1, BinarySearch.search(data, 1000));
  }

  @Test
  public void returnsMinusOneWhenNotFoundInMiddle() {
    assertEquals(-1, BinarySearch.search(data, 50));
  }

  @Test
  public void worksOnSingleElementArrayFound() {
    assertEquals(0, BinarySearch.search(new int[]{42}, 42));
  }

  @Test
  public void worksOnSingleElementArrayNotFound() {
    assertEquals(-1, BinarySearch.search(new int[]{42}, 41));
  }

  @Test
  public void mainRunsWithoutError() {
    assertDoesNotThrow(() -> BinarySearch.main(new String[]{}));
  }
}
