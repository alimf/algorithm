package practice.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Practice {
  public static void matrixRotation(List<List<Integer>> matrix, int r) {
    List<Integer> fList = flaten(matrix);
    System.out.print("Com");
    List<Integer> rotated = rotate(fList, r);
    System.out.print("Com");
    unFlaten(rotated, matrix);
  }

  private static List<Integer> flaten(List<List<Integer>> matrix) {
    List<Integer> flat = new ArrayList<>();
    int r = matrix.size();
    int c = matrix.get(0).size();
    int noOfLayers = Math.min(r, c) / 2;

    for (int layer = 0; layer < noOfLayers; layer++) {
      for (int i = layer; i < r - layer; i++) {
        flat.add(matrix.get(i).get(layer));
      }

      for (int j = layer + 1; j < c - layer; j++) {
        flat.add(matrix.get(r - 1 - layer).get(j));
      }

      for (int i = r - 2 - layer; i >= layer; i--) {
        flat.add(matrix.get(i).get(c - 1 - layer));
      }

      for (int j = c - 2 - layer; j > layer; j--) {
        flat.add(matrix.get(layer).get(j));
      }
    }
    return flat;
  }

  private static void unFlaten(List<Integer> flat, List<List<Integer>> matrix) {
    int r = matrix.size();
    int c = matrix.get(0).size();
    int noOfLayers = Math.min(r, c) / 2;
    int fc = 0;

    for (int layer = 0; layer < noOfLayers; layer++) {
      for (int i = layer; i < r - layer; i++) {
        matrix.get(i).set(layer, flat.get(fc++));
      }

      for (int j = layer + 1; j < c - layer; j++) {
        matrix.get(r - 1 - layer).set(j, flat.get(fc++));
      }

      for (int i = r - 2 - layer; i >= layer; i--) {
        matrix.get(i).set(c - 1 - layer, flat.get(fc++));
      }

      for (int j = c - 2 - layer; j > layer; j--) {
        matrix.get(layer).set(j, flat.get(fc++));
      }
    }
  }

  private static List<Integer> rotate(List<Integer> flat, int r) {
    List<Integer> rotated = new ArrayList<>();
    int size = flat.size();
    r = r % size;

    for (int i = 0; i < size; i++) {
      rotated.add(flat.get((i + r) % size));
    }
    return rotated;
  }

  public static void main(String[] args) {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(new ArrayList<>(List.of(1, 2, 3, 4)));
    matrix.add(new ArrayList<>(List.of(5, 6, 7, 8)));
    matrix.add(new ArrayList<>(List.of(9, 10, 11, 12)));
    matrix.add(new ArrayList<>(List.of(13, 14, 15, 16)));

    matrixRotation(matrix, 2);
  }
}
