package practice.netcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopFrequentElementOptimal {
  public static int[] topKFrequent(int[] nums, int k){
    Map<Integer, Integer> freq = new HashMap<>();

    for (int num : nums){
      freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    List<List<Integer>> buckets = new ArrayList<>();
    for (int i = 0; i <= nums.length; i++) {
      buckets.add(new ArrayList<>());
    }

    for (Map.Entry<Integer, Integer> entry : freq.entrySet()){
      int frequency = entry.getValue();
      int num = entry.getKey();

      buckets.get(frequency).add(num);
    }

    int[] result = new int[k];
    int index = 0;

    for (int i = nums.length - 1; i >= 0 && index < k; i--) {
      for (int num : buckets.get(i)){
        result[index++] = num;
      }
    }
    return result;
  }

  private static void print(int[] nums) {
    for (int num : nums) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 2, 2, 3};
    print(topKFrequent(nums, 2)); // expected: [1, 2]
  }
}
