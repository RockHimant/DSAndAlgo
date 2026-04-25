package slidingwindow;

/**
 * This class solves the "Longest Substring Without Repeating Characters" problem.
 *
 * <p>Given a string s, find the length of the longest substring without repeating characters.
 * A substring is a contiguous sequence of characters within a string.</p>
 *
 * <h2>Examples:</h2>
 * <ul>
 *   <li>Input: "abcabcbb" → Output: 3 ("abc")</li>
 *   <li>Input: "bbbbb" → Output: 1 ("b")</li>
 *   <li>Input: "pwwkew" → Output: 3 ("wke")</li>
 *   <li>Input: "" → Output: 0</li>
 * </ul>
 *
 * <h2>Algorithm:</h2>
 * <p>Uses a sliding window approach with two pointers (left and right) and a HashMap to track
 * the last index of each character. When a repeating character is found, move the left pointer
 * to the right of the previous occurrence of that character. This ensures no duplicates in the
 * current window.</p>
 *
 * <h2>Time Complexity:</h2>
 * <p>O(n) - where n is the length of the string. Each character is visited at most twice
 * (once by right pointer, possibly once by left pointer).</p>
 *
 * <h2>Space Complexity:</h2>
 * <p>O(min(n, m)) - where m is the size of the character set (e.g., 256 for ASCII).
 * In the worst case, if all characters are unique, the HashMap stores up to n entries.</p>
 *
 * <h2>Advantages:</h2>
 * <ul>
 *   <li>Efficient for large strings due to linear time complexity.</li>
 *   <li>Handles edge cases like empty strings and strings with all repeating characters.</li>
 *   <li>Uses constant extra space relative to character set size.</li>
 * </ul>
 */
public class LongestSubStringWithoutRepeatingCharacters {

    /**
     * Finds the length of the longest substring without repeating characters.
     *
     * @param s the input string to analyze
     * @return the length of the longest substring without repeating characters.
     *         Returns 0 if the string is null or empty.
     *
     * <h3>Algorithm Details:</h3>
     * <p>The method uses a sliding window technique:</p>
     * <ol>
     *   <li>Initialize left pointer at 0 and a HashMap to store character indices.</li>
     *   <li>Iterate right pointer from 0 to s.length() - 1.</li>
     *   <li>If current character was seen before and its index >= left, move left to index + 1.</li>
     *   <li>Update the character's last index in the map.</li>
     *   <li>Calculate current window length and update maxLength.</li>
     * </ol>
     *
     * <h3>Time Complexity:</h3>
     * <p>O(n) - Single pass through the string.</p>
     *
     * <h3>Space Complexity:</h3>
     * <p>O(min(n, m)) - HashMap stores at most min(n, character set size) entries.</p>
     *
     * <h3>Edge Cases:</h3>
     * <ul>
     *   <li>Null or empty string: returns 0</li>
     *   <li>All unique characters: returns full string length</li>
     *   <li>All same characters: returns 1</li>
     *   <li>String with spaces or special characters: treated as regular characters</li>
     * </ul>
     */
    public int solve(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxLength = 0;
        int left = 0;
        java.util.Map<Character, Integer> charIndexMap = new java.util.HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                left = charIndexMap.get(currentChar) + 1; // Move left pointer to the right of the last occurrence
            }

            charIndexMap.put(currentChar, right); // Update the last index of the current character
            maxLength = Math.max(maxLength, right - left + 1); // Update max length
        }

        return maxLength;
    }

}
