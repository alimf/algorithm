package practice.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class MatrixLayerRotation {

  public static void matrixRotation(List<List<Integer>> matrix, int n) {
    int r = matrix.size();
    int c = matrix.get(0).size();

    int noOfLayers = Math.min(r, c) / 2;

    for (int layer = 0; layer < noOfLayers; layer++) {
      List<Integer> flat = new ArrayList<>();
      flaten(matrix, flat, layer);
      printFlat(flat);
      List<Integer> rotated = rotate(flat, n);
      printFlat(rotated);
      unflatten(rotated, matrix, layer);
    }
  }

  private static List<Integer> flaten(List<List<Integer>> matrix, List<Integer> flat, int layer) {
    int r = matrix.size();
    int c = matrix.get(0).size();
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
    return flat;
  }

  private static List<Integer> rotate(List<Integer> flat, int r) {
    int size = flat.size();
    r = r % size;
    List<Integer> rotated = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      int sourceIdx = (i - r + size) % size;
      rotated.add(flat.get(sourceIdx));
    }
    return rotated;
  }

  private static void unflatten(List<Integer> flat, List<List<Integer>> matrix, int layer) {
    int r = matrix.size();
    int c = matrix.get(0).size();
    int fc = 0;

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

  private static void printFlat(List<Integer> flat) {
    for (Integer i : flat) {
      System.out.print(i + " ");
    }
    System.out.println();
    System.out.println();
  }

  private static void printMatrix(List<List<Integer>> matrix) {
    for (List<Integer> row : matrix) {
      for (Integer i : row) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(new ArrayList<>(List.of(1, 2, 3, 4)));
    matrix.add(new ArrayList<>(List.of(5, 6, 7, 8)));
    matrix.add(new ArrayList<>(List.of(9, 10, 11, 12)));
    matrix.add(new ArrayList<>(List.of(13, 14, 15, 16)));

    printMatrix(matrix);
    matrixRotation(matrix, 2);
    printMatrix(matrix);
  }
}
