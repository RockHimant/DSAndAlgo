package slidingwindow;

public class LongestSubStringWithKUniqueChars {

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
