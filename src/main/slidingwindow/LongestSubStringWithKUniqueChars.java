package slidingwindow;

/**
 * Finds the length of the longest substring with exactly k unique characters.
 * 
 * Problem Statement:
 * Given a string s and an integer k, find the length of the longest substring 
 * that contains exactly k unique characters. If no such substring exists, return 0.
 * 
 * Examples:
 * - Input: s = "aabacbebebe", k = 3
 *   Output: 7
 *   Explanation: "abebebe" has exactly 3 unique characters (a, b, e).
 * - Input: s = "abc", k = 4
 *   Output: 0
 *   Explanation: String has only 3 unique characters.
 * 
 * Algorithm:
 * This class uses a Sliding Window approach with a HashMap to track character frequencies:
 * 1. Use two pointers i and j to maintain the current window.
 * 2. Expand the window by moving j, adding characters to the map.
 * 3. If the number of unique characters exceeds k, shrink from the left by moving i.
 * 4. When the number of unique characters is exactly k, update the maximum length.
 * 5. Continue until the end of the string.
 * 
 * Time Complexity: O(n)
 * - The algorithm processes each character in the string exactly once.
 * - HashMap operations (put, getOrDefault) are O(1) on average.
 * - The while loop for shrinking the window runs in amortized O(n) time.
 * 
 * Space Complexity: O(min(n, k))
 * - The HashMap stores at most k unique characters, but in the worst case (all unique), it could be O(n).
 * - For practical purposes with limited character sets (e.g., ASCII), it's O(1).
 * 
 * Key Advantages:
 * - Efficient for large strings with sliding window technique.
 * - Handles any character set using HashMap.
 * - Exact k constraint ensures precise substring length calculation.
 * 
 * @author Himant
 */
public class LongestSubStringWithKUniqueChars {

    /**
     * Computes the length of the longest substring with exactly k unique characters.
     * 
     * Algorithm Flow:
     * 1. Validate inputs: Return 0 if string is null/empty or k <= 0.
     * 2. Initialize pointers i and j, maxLength, and character frequency map.
     * 3. Expand window with j, update map, shrink if unique chars > k.
     * 4. If unique chars == k, update maxLength.
     * 5. Return maxLength.
     * 
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(min(n, k)), for the HashMap.
     * 
     * @param s the input string (may be null or empty)
     * @param k the exact number of unique characters required
     * @return the length of the longest substring with exactly k unique characters;
     *         returns 0 if no such substring exists or inputs are invalid
     */
    public int solve(String s, int k) { 
        
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int maxLength = 0;
        java.util.Map<Character, Integer> charCountMap = new java.util.HashMap<>();

        while (j < s.length()) {
            char endChar = s.charAt(j);
            charCountMap.put(endChar, charCountMap.getOrDefault(endChar, 0) + 1);

            while (charCountMap.size() > k) {
                char startChar = s.charAt(i);
                charCountMap.put(startChar, charCountMap.get(startChar) - 1);
                if (charCountMap.get(startChar) == 0) {
                    charCountMap.remove(startChar);
                }
                i++;
            }

            if (charCountMap.size() == k) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
            j++;
        }

        return maxLength;
    }

}
