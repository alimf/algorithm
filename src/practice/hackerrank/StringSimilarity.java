package practice.hackerrank;

public class StringSimilarity {
  public static int stringSimilarity(String s) {
    if (s == null || s.isEmpty()) return 0;

    int n = s.length();
    int[] z = buildZArray(s);

    int sum = n;
    for (int i = 1; i < n; i++) {
      sum += z[i];
    }
    return sum;
  }

  private static int[] buildZArray(String s) {
    int n = s.length();
    int[] z = new int[n];
    int left = 0, right = 0;

    for (int i = 1; i < n; i++) {
      if (i < right) {
        z[i] = Math.min(right - i, z[i - left]);
      }
      while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
        z[i]++;
      }
      if (i + z[i] > right) {
        left = i;
        right = i + z[i];
      }
    }
    return z;
  }

  public static void main(String[] args) {
//    System.out.println(stringSimilarity("ababaa"));
//    System.out.println(stringSimilarity("aaaaaaaab"));
//    System.out.println(stringSimilarity("ababababa"));
    System.out.println(stringSimilarity("aabaabaab"));
//    System.out.println(stringSimilarity("abacabab"));
  }
}
