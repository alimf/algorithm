package practice.hackerrank;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixLayerRotationTest {

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
  public void rotateBy2On4x4() {
    List<List<Integer>> m = matrix(new int[][]{
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    });
    MatrixLayerRotation.matrixRotation(m, 2);
    assertEquals(List.of(3, 4, 8, 12), m.get(0));
    assertEquals(List.of(2, 11, 10, 16), m.get(1));
    assertEquals(List.of(1, 7, 6, 15), m.get(2));
    assertEquals(List.of(5, 9, 13, 14), m.get(3));
  }

  @Test
  public void rotateByZeroLeavesMatrixUnchanged() {
    List<List<Integer>> m = matrix(new int[][]{
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    });
    MatrixLayerRotation.matrixRotation(m, 0);
    assertEquals(List.of(1, 2, 3, 4), m.get(0));
    assertEquals(List.of(5, 6, 7, 8), m.get(1));
    assertEquals(List.of(9, 10, 11, 12), m.get(2));
    assertEquals(List.of(13, 14, 15, 16), m.get(3));
  }

  @Test
  public void rotateByFullCycleReturnsOriginal() {
    List<List<Integer>> m = matrix(new int[][]{
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    });
    // outer layer has 12 elements; inner layer has 4 -> LCM 12 returns identity
    MatrixLayerRotation.matrixRotation(m, 12);
    assertEquals(List.of(1, 2, 3, 4), m.get(0));
    assertEquals(List.of(5, 6, 7, 8), m.get(1));
    assertEquals(List.of(9, 10, 11, 12), m.get(2));
    assertEquals(List.of(13, 14, 15, 16), m.get(3));
  }

  @Test
  public void mainRunsWithoutError() {
    assertDoesNotThrow(() -> MatrixLayerRotation.main(new String[]{}));
  }
}
