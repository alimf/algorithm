package practice.hackerrank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringSimilarityTest {

  @Test
  public void testEmptyString() {
    assertEquals(0, StringSimilarity.stringSimilarity(""));
  }

  @Test
  public void testNullInput() {
    assertEquals(0, StringSimilarity.stringSimilarity(null));
  }

  @Test
  public void testSingleCharacter() {
    // Single character has similarity with itself only
    assertEquals(1, StringSimilarity.stringSimilarity("a"));
  }

  @Test
  public void testTwoCharactersSame() {
    // "aa" - similarity: 2 (itself) + 1 (second 'a' matches prefix 'a') = 3
    assertEquals(3, StringSimilarity.stringSimilarity("aa"));
  }

  @Test
  public void testTwoCharactersDifferent() {
    // "ab" - similarity: 2 (itself) + 0 (no match) = 2
    assertEquals(2, StringSimilarity.stringSimilarity("ab"));
  }

  @Test
  public void testAabaabaab() {
    // Test case from commented main method
    // "aabaabaab" has multiple prefix matches
    assertEquals(21, StringSimilarity.stringSimilarity("aabaabaab"));
  }

  @Test
  public void testAbabaa() {
    // Test case: "ababaa"
    assertEquals(11, StringSimilarity.stringSimilarity("ababaa"));
  }

  @Test
  public void testAaaaaaaab() {
    // Test case: "aaaaaaaab"
    // Mostly 'a's followed by 'b'
    // Z-array will show many prefix matches for the 'a's
    assertEquals(37, StringSimilarity.stringSimilarity("aaaaaaaab"));
  }

  @Test
  public void testAbabababa() {
    // Test case: "ababababa"
    // Repeating "ab" pattern
    assertEquals(25, StringSimilarity.stringSimilarity("ababababa"));
  }

  @Test
  public void testAbacabab() {
    // Test case: "abacabab"
    assertEquals(14, StringSimilarity.stringSimilarity("abacabab"));
  }

  @Test
  public void testNoRepeatingPattern() {
    // Test case: "abcdef"
    // No prefix matches after the string itself
    assertEquals(6, StringSimilarity.stringSimilarity("abcdef"));
  }

  @Test
  public void testAllSameCharacter() {
    // Test case: "aaaa"
    // Each position matches the prefix
    assertEquals(10, StringSimilarity.stringSimilarity("aaaa"));
  }

  @Test
  public void testRepeatingSubstring() {
    // Test case: "ababab"
    // Pattern "ab" repeats
    assertEquals(12, StringSimilarity.stringSimilarity("ababab"));
  }
}

