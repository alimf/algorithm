package practice.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HackerLandTransmitter {
  public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
    Collections.sort(x);
    int count = 0;
    int i = 0;
    int n = x.size();

    while (i < n) {
      count++;
      int leftUnCoveredLocation = x.get(i);
      int transmitterLocation = leftUnCoveredLocation + k;
      while (i < n && x.get(i) <= transmitterLocation) {
        i++;
      }
      transmitterLocation = x.get(i - 1);

      while (i < n && x.get(i) <= transmitterLocation + k) {
        i++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(hackerlandRadioTransmitters(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 1)); // expected: 2
  }
}
