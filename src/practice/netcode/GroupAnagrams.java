package practice.netcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> res = new HashMap<>();

    for (String s : strs) {
      int[] count = new int[26];

      for (char c : s.toCharArray()) {
        count[c - 'a']++;
      }

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 26; i++) {
        sb.append(count[i]);
        sb.append("#");
      }
      String key = sb.toString();
      res.putIfAbsent(key, new ArrayList<>());

      res.get(key).add(s);
    }
    return new ArrayList<>(res.values());
  }

  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(groupAnagrams(strs));
  }
}
