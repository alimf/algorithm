package practice.netcode;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
  public static String encode(List<String> strs) {
    StringBuilder encoded = new StringBuilder();

    for(String s : strs){
      encoded.append(s.length()).append('#').append(s);
    }
    return encoded.toString();

  }

  public static List<String> decode(String str) {
    List<String> decoded = new ArrayList<>();

    int i = 0;

    while( i < str.length()){
      int j = i;
      while(str.charAt(j) != '#'){
        j++;
      }

      int length = Integer.parseInt(str.substring(i, j));

      i = j + 1;
      String s = str.substring(i, i+length);

      decoded.add(s);

      i += length;
    }
    return decoded;
  }

  public static void main(String[] args) {
    List<String> strs = List.of("Hello", "W#rld", "Java");
    String encoded = encode(strs);
    System.out.println("Encoded: " + encoded);

    List<String> decoded = decode(encoded);
    System.out.println("Decoded: " + decoded);
  }
}
