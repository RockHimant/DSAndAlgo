package slidingwindow;

public class LongestRepeatingCharacterReplacement {

    public int solve(String s, int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] charCount = new int[26];
        int maxCount = 0; // Max count of a single character in the current window
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            charCount[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']);

            // If the number of characters to replace exceeds k, shrink the window
            while ((right - left + 1) - maxCount > k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
                // Recalculate maxCount after shrinking the window
                maxCount = 0;
                for (int count : charCount) {
                    maxCount = Math.max(maxCount, count);
                }
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
