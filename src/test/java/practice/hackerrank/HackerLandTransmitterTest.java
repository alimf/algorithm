package practice.hackerrank;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class HackerLandTransmitterTest {

  @Test
  public void sample1To5RangeOne() {
    List<Integer> houses = new ArrayList<>(List.of(1, 2, 3, 4, 5));
    assertEquals(2, HackerLandTransmitter.hackerlandRadioTransmitters(houses, 1));
  }

  @Test
  public void singleHouse() {
    List<Integer> houses = new ArrayList<>(List.of(7));
    assertEquals(1, HackerLandTransmitter.hackerlandRadioTransmitters(houses, 2));
  }

  @Test
  public void unsortedInput() {
    List<Integer> houses = new ArrayList<>(List.of(7, 2, 4, 6, 5, 9, 12, 11));
    assertEquals(3, HackerLandTransmitter.hackerlandRadioTransmitters(houses, 2));
  }

  @Test
  public void spreadFarApart() {
    List<Integer> houses = new ArrayList<>(List.of(1, 10, 20));
    assertEquals(3, HackerLandTransmitter.hackerlandRadioTransmitters(houses, 2));
  }

  @Test
  public void allCoveredByOne() {
    List<Integer> houses = new ArrayList<>(List.of(1, 2, 3));
    assertEquals(1, HackerLandTransmitter.hackerlandRadioTransmitters(houses, 5));
  }

  @Test
  public void duplicatesAreHandled() {
    List<Integer> houses = new ArrayList<>(List.of(1, 1, 2, 2, 3, 3));
    assertEquals(1, HackerLandTransmitter.hackerlandRadioTransmitters(houses, 1));
  }

  @Test
  public void mainRunsWithoutError() {
    assertDoesNotThrow(() -> HackerLandTransmitter.main(new String[]{}));
  }
}
