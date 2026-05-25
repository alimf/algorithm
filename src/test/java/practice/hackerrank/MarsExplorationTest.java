package practice.hackerrank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MarsExplorationTest {

  @Test
  public void noChanges() {
    assertEquals(0, MarsExploration.marsExploration("SOSSOS"));
  }

  @Test
  public void singleSosUnchanged() {
    assertEquals(0, MarsExploration.marsExploration("SOS"));
  }

  @Test
  public void sampleFromMain() {
    assertEquals(3, MarsExploration.marsExploration("SOSSPSSQSSOR"));
  }

  @Test
  public void allChangedSosMessages() {
    assertEquals(3, MarsExploration.marsExploration("ABC"));
  }

  @Test
  public void multipleBlocksAllChanged() {
    assertEquals(6, MarsExploration.marsExploration("ABCDEF"));
  }

  @Test
  public void onlyMiddleCharsWrong() {
    assertEquals(2, MarsExploration.marsExploration("SXSSXS"));
  }

  @Test
  public void mainRunsWithoutError() {
    assertDoesNotThrow(() -> MarsExploration.main(new String[]{}));
  }
}
