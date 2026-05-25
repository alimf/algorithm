package practice.hackerrank;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TwoPlusTest {

  @Test
  public void sample0() {
    List<String> grid = List.of(
      "GGGGGG",
      "GBBBGB",
      "GGGGGG",
      "GGBBGB",
      "GGGGGG"
    );
    assertEquals(5, TwoPlus.twoPluses(grid));
  }

  @Test
  public void sample1() {
    List<String> grid = List.of(
      "BGBBGB",
      "GGGGGG",
      "BGBBGB",
      "GGGGGG",
      "BGBBGB",
      "BGBBGB"
    );
    assertEquals(25, TwoPlus.twoPluses(grid));
  }

  @Test
  public void noGoodCells() {
    List<String> grid = List.of(
      "BBB",
      "BBB",
      "BBB"
    );
    assertEquals(0, TwoPlus.twoPluses(grid));
  }

  @Test
  public void twoSingleCellPluses() {
    List<String> grid = List.of(
      "GBG",
      "BBB",
      "GBG"
    );
    assertEquals(1, TwoPlus.twoPluses(grid));
  }

  @Test
  public void mainRunsWithoutError() {
    assertDoesNotThrow(() -> TwoPlus.main(new String[]{}));
  }
}
