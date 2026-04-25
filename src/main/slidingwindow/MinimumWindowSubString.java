package slidingwindow;

/**
 * Finds the minimum window substring that contains all characters of a target string.
 * 
 * Problem Statement:
 * Given two strings s and t, find the minimum window substring in s that contains
 * all characters of t (including duplicates). If no such window exists, return an empty string.
 * 
 * Examples:
 * - Input: s = "ADOBECODEBANC", t = "ABC"
 *   Output: "BANC"
 *   Explanation: "BANC" contains A, B, C.
 * - Input: s = "a", t = "aa"
 *   Output: ""
 *   Explanation: "a" does not contain two 'a's.
 * 
 * Algorithm:
 * This class uses a Sliding Window approach with two pointers and frequency maps:
 * 1. Create frequency maps for characters in t.
 * 2. Expand the window with the right pointer, tracking formed characters.
 * 3. When all required characters are formed, shrink from the left to minimize the window.
 * 4. Track the minimum window found.
 * 
 * Time Complexity: O(n)
 * - Single pass through string s with constant-time map operations.
 * - Worst case: O(n + m), where n = length of s, m = length of t.
 * 
 * Space Complexity: O(m)
 * - Frequency maps store at most m unique characters from t.
 * - For ASCII, effectively O(1).
 * 
 * Key Advantages:
 * - Handles duplicates in t correctly using frequency counts.
 * - Efficient for large strings with sliding window optimization.
 * - Returns the smallest valid window or empty string.
 * 
 * @author Himant
 */
public class MinimumWindowSubString {

    /**
     * Finds the minimum window substring in s that contains all characters of t.
     * 
     * Algorithm Flow:
     * 1. Validate inputs: Return "" if s or t is null, or s.length() < t.length().
     * 2. Build frequency map for t, count required unique characters.
     * 3. Initialize window pointers, formed counter, and answer array.
     * 4. Expand right pointer, update window counts, increment formed when match.
     * 5. When formed == required, shrink left pointer to minimize window.
     * 6. Update answer with smallest window found.
     * 7. Return substring from answer indices or "".
     * 
     * Time Complexity: O(n), where n is the length of s.
     * Space Complexity: O(m), where m is the number of unique characters in t.
     * 
     * @param s the input string to search in (may be null)
     * @param t the target string containing characters to find (may be null)
     * @return the minimum window substring containing all characters of t;
     *         returns empty string if no such window exists or inputs are invalid
     */
    public String solve(String s, String t) {
        if (s == null || t == null || t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        java.util.Map<Character, Integer> charCountMap = new java.util.HashMap<>();
        for (char c : t.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        int required = charCountMap.size();
        int formed = 0;
        java.util.Map<Character, Integer> windowCounts = new java.util.HashMap<>();
        int left = 0, right = 0;
        int[] ans = {-1, 0, 0}; // length, left, right

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (charCountMap.containsKey(c) && windowCounts.get(c).intValue() == charCountMap.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                c = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (charCountMap.containsKey(c) && windowCounts.get(c).intValue() < charCountMap.get(c).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

}
