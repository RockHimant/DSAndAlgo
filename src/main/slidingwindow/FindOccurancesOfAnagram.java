package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Finds the count of occurrences of anagrams of a pattern within a given text.
 * 
 * Problem Statement:
 * Given a pattern string pat and a text string txt, return the count of 
 * all occurrences of anagrams of the pattern in the text.
 * 
 * Examples:
 * - Input: txt = "forxxorfxdofr", pat = "for"
 *   Output: 3
 *   Explanation: "for", "orf", and "ofr" are anagrams appearing in the text.
 * - Input: txt = "aabaabaa", pat = "aaba"
 *   Output: 4
 *   Explanation: "aaba" appears 4 times as an anagram in the text.
 * 
 * Algorithm:
 * This class uses a Sliding Window approach with a HashMap to efficiently find anagrams:
 * 1. Build a frequency map of all characters in the pattern.
 * 2. Use a sliding window of size equal to the pattern length over the text.
 * 3. For each position, update the frequency map by:
 *    - Decrementing the count of the newly added character (right end of window).
 *    - Incrementing the count of the removed character (left end of window).
 * 4. When the window is full, check if all character frequencies are zero (indicating an anagram).
 * 5. Slide the window by moving both pointers and repeat until the text is exhausted.
 * 
 * Time Complexity: O(n + m)
 * - Building the pattern frequency map: O(m), where m = length of pattern.
 * - Main sliding window loop: O(n), where n = length of text.
 *   - Each character in the text is processed exactly once (added and removed from the window).
 *   - HashMap operations (put, getOrDefault) are O(1) on average.
 *   - The anagram check (iterating through map values) is O(k), where k is the number of 
 *     unique characters in the pattern (at most 26 for lowercase English letters, hence effectively O(1)).
 *   - The anagram check is performed O(n - m + 1) times, which is O(n).
 * - Overall: O(n + m)
 * 
 * Space Complexity: O(k)
 * - The HashMap stores at most k unique characters, where k = number of unique characters in the pattern.
 * - For lowercase English letters, k ≤ 26, so space complexity is effectively O(1).
 * - For general Unicode characters, space complexity is O(k).
 * 
 * Key Advantages:
 * - Efficient: Avoids redundant character comparisons using the sliding window technique.
 * - Flexible: The HashMap approach works with any character set (not limited to lowercase letters).
 * - Clean: The getOrDefault method simplifies character frequency management.
 * 
 * @author Himant
 */
public class FindOccurancesOfAnagram {

    /**
     * Counts the number of anagrams of the pattern found in the text.
     * 
     * Algorithm Flow:
     * 1. Validate inputs: Return 0 if text or pattern is null, or if pattern is longer than text.
     * 2. Build frequency map of pattern characters.
     * 3. Initialize sliding window pointers: i (left) and j (right).
     * 4. Expand window by incrementing j until window size equals pattern length.
     * 5. When window is full, check if all frequencies are zero (anagram found).
     * 6. Slide window: Remove left character and add right character.
     * 7. Repeat until entire text is processed.
     * 
     * Time Complexity: O(n + m)
     * - Pattern frequency map building: O(m)
     * - Text processing via sliding window: O(n)
     * - Anagram verification (worst case): O(k), where k ≤ 26 (constant for English letters)
     * 
     * Space Complexity: O(k), where k is the number of unique characters in the pattern.
     * 
     * @param txt the text string to search for anagrams (may contain null)
     * @param pat the pattern string to find anagrams of (may contain null)
     * @return the count of anagrams of pat found in txt;
     *         returns 0 if txt or pat is null, or if pat is longer than txt
     * 
     * @example
     * FindOccurancesOfAnagram finder = new FindOccurancesOfAnagram();
     * int result = finder.solve("forxxorfxdofr", "for");  // Returns 3
     * int result2 = finder.solve("aabaabaa", "aaba");     // Returns 4
     *
     * int result = finder.solve("forxxorfxdofr", "for");  // Returns 3
     * int result2 = finder.solve("aabaabaa", "aaba");     // Returns 4
     */
    public int solve(String txt, String pat) {

        if (txt == null || pat == null || txt.length() < pat.length()) {
            return 0;
        }

        Map<Character, Integer> count = new HashMap<>();
        for (char ch : pat.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        int i = 0;  int j = 0;  int anagramCount = 0;
        while (j < txt.length()) {
            char currentChar = txt.charAt(j);
            count.put(currentChar, count.getOrDefault(currentChar, 0) - 1);

            if (j - i + 1 < pat.length()) {
                j++;
            } else if (j - i + 1 == pat.length()) {
                boolean isAnagram = true;
                for (int num : count.values()) {
                    if (num != 0) {
                        isAnagram = false;
                        break;
                    }
                }
                if (isAnagram) {
                    anagramCount++;
                }
                char leftChar = txt.charAt(i);
                count.put(leftChar, count.getOrDefault(leftChar, 0) + 1);
                i++;
                j++;
            }
        }
        return anagramCount;
    }
}
