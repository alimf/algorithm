package sort;

public class QuickSort {
  private static void quickSort(int[] data, int low, int high) {
    if (low < high) {
      int pi = partition(data, low, high);
      quickSort(data, low, pi - 1);
      quickSort(data, pi + 1, high);
    }
  }

  private static int partition(int[] data, int low, int high) {
    int pivot = data[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (data[j] < pivot) {
        i++;
        swap(data, i, j);
      }
    }
    swap(data, i + 1, high);
    return i + 1;
  }

  private static void swap(int[] data, int i, int j) {
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }

  private static void printArray(int[] data) {
    for (int i : data) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] data = {10, 99, 12, 14, 15, 23, 33, 66, 72, 85, 96};
    printArray(data);
    quickSort(data, 0, data.length - 1);
    printArray(data);
  }
}
