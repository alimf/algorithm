package practice.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class TwoPlus {
  private static final char GOOD = 'G';

  private static class Plus {
    int row, col, arm, area;
    public Plus(int row, int col, int arm){
      this.row = row;
      this.col = col;
      this.arm = arm;
      this.area = 4*arm +1;
    }
  }

  private static void markPlus(boolean[][] plusMarked, Plus p, boolean b){
    plusMarked[p.row][p.col] = b;
    for(int arm = 1; arm <= p.arm; arm++){
      plusMarked[p.row - arm][p.col] = b;
      plusMarked[p.row + arm][p.col] = b;
      plusMarked[p.row][p.col - arm] = b;
      plusMarked[p.row][p.col + arm] = b;
    }
  }

  private static boolean isOverlap(boolean[][] plusMarked, Plus b){
    if(plusMarked[b.row][b.col]){
      return true;
    }
    for(int arm = 1; arm <= b.arm; arm++){
      if(plusMarked[b.row - arm][b.col]
        || plusMarked[b.row + arm][b.col]
        || plusMarked[b.row][b.col - arm]
        || plusMarked[b.row][b.col + arm]){
        return true;
      }
    }
    return false;
  }

  private static int[][] computeArms(char[][] grid, int n, int m){
    int[][] arms = new int[n][m];

    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        int length = 0;
        while(i - length >= 0 && i + length < n
          && j - length >= 0 && j + length < m
          && grid[i - length][j] == GOOD && grid[i + length][j] == GOOD
          && grid[i][j - length] == GOOD && grid[i][j + length] == GOOD){
          length++;
        }
        arms[i][j] = length - 1;
      }
    }
    return arms;
  }

  private static List<Plus> allPlussesInDesc(int[][] arms){
    List<Plus> pluses = new ArrayList<>();

    for(int i = 0; i < arms.length; i++){
      for(int j = 0; j < arms[i].length; j++){
        for(int k = 0; k <= arms[i][j]; k++){
          pluses.add(new Plus(i, j, k));
        }
      }
    }
    pluses.sort( (a, b) -> b.arm - a.arm);
    return pluses;
  }

  private static char[][] convertToCharArray(List<String> grid, int n, int m){
    char[][] chars = new char[n][m];
    for(int i = 0; i < n; i++){
      chars[i] = grid.get(i).toCharArray();
    }
    return chars;
  }

  public static int twoPluses(List<String> grid) {
    int max = 0;
    int n = grid.size();
    int m = grid.get(0).length();
    boolean[][] marked = new boolean[n][m];
    int[][] arms = computeArms(convertToCharArray(grid, n, m), n, m);
    List<Plus> pluses = allPlussesInDesc(arms);

    for(int i = 0; i < pluses.size(); i++){
      Plus plus = pluses.get(i);

      if((i + 1) < pluses.size() && plus.area * pluses.get(i + 1).area <= max){
        break;
      }
      markPlus(marked, plus, true);
      for(int j = i + 1; j < pluses.size(); j++){
        Plus pj = pluses.get(j);
        if(plus.area * pluses.get(j).area <= max){
          break;
        }
        if(!isOverlap(marked, pj)){
          max = Math.max(max, plus.area * pj.area);
          break;
        }
      }
      markPlus(marked, plus, false);
    }
    return max;
  }

  public static void main(String[] args) {
    String[] grid0 = {
      "GGGGGG",
      "GBBBGB",
      "GGGGGG",
      "GGBBGB",
      "GGGGGG"
    };
//    System.out.println("Sample 0: " + twoPluses(grid0)); // expected: 5

    String[] grid1 = {
      "BGBBGB",
      "GGGGGG",
      "BGBBGB",
      "GGGGGG",
      "BGBBGB",
      "BGBBGB"
    };
    System.out.println("Sample 1: " + twoPluses(List.of(grid1))); // expected: 25
  }
}
