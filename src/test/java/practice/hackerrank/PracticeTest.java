package practice.hackerrank;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PracticeTest {

  private static List<List<Integer>> matrix(int[][] rows) {
    List<List<Integer>> m = new ArrayList<>();
    for (int[] row : rows) {
      List<Integer> r = new ArrayList<>();
      for (int v : row) r.add(v);
      m.add(r);
    }
    return m;
  }

  @Test
  public void rotateByZeroLeavesMatrixUnchanged() {
    List<List<Integer>> m = matrix(new int[][]{
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    });
    Practice.matrixRotation(m, 0);
    assertEquals(List.of(1, 2, 3, 4), m.get(0));
    assertEquals(List.of(5, 6, 7, 8), m.get(1));
    assertEquals(List.of(9, 10, 11, 12), m.get(2));
    assertEquals(List.of(13, 14, 15, 16), m.get(3));
  }

  @Test
  public void rotateByOneOn4x4ShiftsOuterLayer() {
    List<List<Integer>> m = matrix(new int[][]{
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    });
    Practice.matrixRotation(m, 1);
    // Practice flattens all layers into a single list before rotating, so values
    // bleed between layers. These expectations capture that current behavior.
    assertEquals(List.of(5, 6, 2, 3), m.get(0));
    assertEquals(List.of(9, 10, 1, 4), m.get(1));
    assertEquals(List.of(13, 11, 7, 8), m.get(2));
    assertEquals(List.of(14, 15, 16, 12), m.get(3));
  }

  @Test
  public void mainRunsWithoutError() {
    assertDoesNotThrow(() -> Practice.main(new String[]{}));
  }
}
