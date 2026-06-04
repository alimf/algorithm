package practice.netcode;

public class IsPalindrome {
  public static boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    String lower = s.toLowerCase();

    while(i < j){
      if(lower.charAt(i) != lower.charAt(j)){
        return false;
      }
      i++;
      j--;
    }
    return true;

  }

  public static void main(String[] args) {
    String s = "Was it a car or a cat I saw?";
    System.out.println(isPalindrome(s));
  }
}
