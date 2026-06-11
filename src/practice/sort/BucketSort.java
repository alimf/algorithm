package practice.sort;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {
  public static void bucketSort(int[] arr) {
    if(arr == null || arr.length < 2){
      return;
    }
    int max = arr[0];
    int min = arr[0];

    for (int num : arr) {
      max = Math.max(max, num);
      min = Math.min(min, num);
    }

    int bucketSize = arr.length;
    List<List<Integer>> buckets = new ArrayList<>();
    int range = max - min + 1;

    for (int i = 0; i < bucketSize; i++) {
      buckets.add(new ArrayList<>());
    }

    for (int num : arr) {
      int bucketIndex = (num - min) * bucketSize / range;
      buckets.get(bucketIndex).add(num);
    }

    int idx = 0;
    for (List<Integer> bucket : buckets) {
      bucket.sort(Integer::compareTo);
      for (int num : bucket) {
        arr[idx++] = num;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {3, 6, 2, 7, 5, 8, 1, 4};
    bucketSort(arr);
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}
