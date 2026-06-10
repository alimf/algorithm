package practice.netcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopFrequentElement {
  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int num : nums) {
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
      Comparator.comparingInt(Map.Entry::getValue)
    );

    for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
      maxHeap.offer(entry);

      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }

    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = maxHeap.poll().getKey();
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
