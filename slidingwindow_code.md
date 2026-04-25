# Sliding Window Programs

## FindOccurancesOfAnagram.java

```java
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

```

## FirstNegativeNumberInEverySubArray.java

```java
package slidingwindow;

import java.util.*;

public class FirstNegativeNumberInEverySubArray {

    public int[] solve(int[] arr, int k) {

        Deque<Integer> deque = new java.util.LinkedList<>();

        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int i = 0;
        int j = 0;
        int[] result = new int[arr.length - k + 1];
        int index = 0;

        while (j < arr.length) {
            if (arr[j] < 0) {
                deque.offerLast(j);
            }

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (!deque.isEmpty()) {
                    result[index++] = arr[deque.peekFirst()];
                } else {
                    result[index++] = 0;
                }
                if (!deque.isEmpty() && deque.peekFirst() == i) {
                    deque.pollFirst();
                }
                i++;
                j++;
            }
        }
        return result;

    }

}

```

## LargestSubArrayWithSumK.java

```java
package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Finds the length of the largest subarray with sum equal to k.
 * 
 * Problem Statement:
 * Given an array of integers and a target sum k, find the length of the longest 
 * contiguous subarray that sums to exactly k. The array may contain positive, 
 * negative, and zero values.
 * 
 * Algorithm:
 * This class uses prefix sums with a HashMap to efficiently find subarrays with sum k:
 * - Compute prefix sums as we iterate through the array
 * - Use a HashMap to store the earliest index where each prefix sum was seen
 * - For each position, check if (prefixSum - k) exists in the map
 * - If found, the subarray from map index + 1 to current index sums to k
 * - Track the maximum length found
 * - Store prefix sums only when first encountered to ensure earliest start index
 * 
 * Time Complexity: O(n)
 * - Single pass through the array
 * - HashMap operations are O(1) on average
 * - Total time is linear in the size of the input
 * 
 * Space Complexity: O(n)
 * - HashMap stores at most n+1 entries (one for each prefix sum)
 * - In worst case, all prefix sums are unique
 * 
 * Key Advantages:
 * - Handles negative numbers correctly (unlike sliding window for positives only)
 * - Efficient O(n) time complexity
 * - Uses constant extra space beyond the HashMap
 * 
 * @author Himant
 */
public class LargestSubArrayWithSumK {

    /**
     * Computes the length of the largest subarray with sum equal to k.
     * 
     * Algorithm Flow:
     * 1. Handle edge cases: return 0 for null or empty arrays
     * 2. Initialize HashMap with prefix sum 0 at index -1
     * 3. Iterate through each element in the array:
     *    - Add current element to prefix sum
     *    - Check if (prefixSum - k) exists in map
     *    - If found, calculate length from stored index to current
     *    - Update maximum length if this is larger
     *    - Store current prefix sum in map (only if not already present)
     * 4. Return the maximum length found
     * 
     * Time Complexity: O(n), where n is the length of the array
     * - Each element is processed exactly once
     * - HashMap lookups and insertions are O(1) average case
     * 
     * Space Complexity: O(n)
     * - HashMap may store up to n different prefix sums
     * - Worst case occurs when all prefix sums are unique
     * 
     * @param arr the input array of integers (may contain negatives, positives, zeros)
     * @param k the target sum to find in subarrays
     * @return the length of the longest subarray with sum equal to k;
     *         returns 0 if no such subarray exists or if arr is null/empty
     * 
     * Example:
     * LargestSubArrayWithSumK finder = new LargestSubArrayWithSumK();
     * int result = finder.solve(new int[]{10, 5, 2, 7, 1, -10}, 15);
     * // Returns 6 (entire array sums to 15)
     * int result2 = finder.solve(new int[]{1, 2, 3}, 5);
     * // Returns 2 ([2,3] sums to 5)
     */
    public int solve(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1); // prefix sum 0 at index -1

        int prefixSum = 0;
        int maxLength = 0;

        for (int j = 0; j < arr.length; j++) {
            prefixSum += arr[j];

            // Check if prefixSum - k exists in map
            if (prefixMap.containsKey(prefixSum - k)) {
                int startIndex = prefixMap.get(prefixSum - k);
                int length = j - startIndex;
                maxLength = Math.max(maxLength, length);
            }

            // Store the earliest index for this prefix sum
            if (!prefixMap.containsKey(prefixSum)) {
                prefixMap.put(prefixSum, j);
            }
        }

        return maxLength;
    }

}

```

## LongestSubStringWithKUniqueChars.java

```java
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

```

## MaxOfAllSubArrayofSizeK.java

```java
package slidingwindow;

import java.util.Deque;

/**
 * Finds the maximum element in each subarray of size k using a sliding window approach.
 * 
 * Problem Statement:
 * Given an array of integers and a window size k, return an array containing the maximum
 * element from each subarray of size k.
 * 
 * Algorithm:
 * This class uses a Deque (double-ended queue) to maintain the indices of elements in decreasing order:
 * - The deque stores indices of array elements in decreasing order of their values.
 * - For each new element, remove elements from the back of the deque that are smaller than the current element.
 * - When the window is full, the front of the deque contains the index of the maximum element in the current window.
 * - Slide the window by removing elements from the front that are out of the current window.
 * 
 * Time Complexity: O(n)
 * - Each element is added to and removed from the deque exactly once.
 * - Amortized time for deque operations is O(1) per element.
 * 
 * Space Complexity: O(k)
 * - The deque stores at most k elements (indices of the current window).
 * 
 * @author Himant
 */
public class MaxOfAllSubArrayofSizeK {

    /**
     * Computes the maximum element for each subarray of size k.
     * 
     * Algorithm Flow:
     * 1. Validate inputs: Return empty array if arr is null/empty or k <= 0.
     * 2. Initialize deque to store indices in decreasing order of values.
     * 3. Iterate through the array with pointer j:
     *    - Remove from deque back if current element is larger.
     *    - Add current index to deque.
     *    - If window size < k, continue.
     *    - If window size == k, record max from deque front, slide window.
     * 4. Return the result array.
     * 
     * Time Complexity: O(n), where n is the length of the array.
     * Space Complexity: O(k), for the deque.
     * 
     * @param arr the input array of integers
     * @param k the size of the sliding window
     * @return an array containing the maximum of each subarray of size k;
     *         returns empty array if arr is null/empty or k <= 0
     * 
     * Example:
     * MaxOfAllSubArrayofSizeK finder = new MaxOfAllSubArrayofSizeK();
     * int[] result = finder.solve(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
     * // Returns [3, 3, 5, 5, 6, 7]
     */
    public int[] solve(int[] arr, int k) {

        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[0];
        }

        int i = 0;
        int j = 0;
        int[] result = new int[arr.length - k + 1];
        int index = 0;

        Deque<Integer> deque = new java.util.LinkedList<>();

        while (j < arr.length) {
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[j]) {
                deque.pollLast();
            }
            deque.offerLast(j);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                result[index++] = arr[deque.peekFirst()];
                if (deque.peekFirst() == i) {
                    deque.pollFirst();
                }
                i++;
                j++;
            }
        }
        return result;
    }

}

```

## MaxSumOfSubArray.java

```java
package slidingwindow;

/**
 * Given an array of integers arr[] and a number k. Return the maximum sum of a
 * subarray of size k.
 * 
 * Input: arr[] = [100, 200, 300, 400], k = 2
 * Output: 700
 * Explanation: arr2 + arr3 = 700, which is maximum.
 * 
 * Input: arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
 * Output: 39
 * Explanation: arr1 + arr2 + arr3 + arr4 = 39, which is maximum.
 */
public class MaxSumOfSubArray {

    public int solve(int[] arr, int k) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int i = 0;  int j = 0;  int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        while (j < arr.length) {
            sum += arr[j];

            if ((j - i + 1) < k) {
                j++;
            } else if (j - i + 1 == k) {
                maxSum = Math.max(sum, maxSum);
                sum = sum - arr[i];
                i++;
                j++;
            }

        }

        return maxSum;
    }

}

```

## SumOfMinAndMaxInSubArray.java

```java
package slidingwindow;

/* *
 * Given an array of both positive and negative integers, 
 * the task is to compute sum of minimum and maximum elements of all sub-array of size k.
 * 
 * Input : arr[] = {2, 5, -1, 7, -3, -1, -2}  
*   K = 4
*   Output : 18
*   Explanation : Subarrays of size 4 are : 
*    {2, 5, -1, 7},   min + max = -1 + 7 = 6
*    {5, -1, 7, -3},  min + max = -3 + 7 = 4      
*    {-1, 7, -3, -1}, min + max = -3 + 7 = 4
*    {7, -3, -1, -2}, min + max = -3 + 7 = 4   
*/
import java.util.Deque;

public class SumOfMinAndMaxInSubArray {

    public int solve(int[] arr, int k) {

        Deque<Integer> maxDeque = new java.util.LinkedList<>();
        Deque<Integer> minDeque = new java.util.LinkedList<>();

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        int sum = 0;

        while (j < arr.length) {
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[j]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(j);
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[j]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(j);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                minVal = arr[minDeque.peekFirst()];
                maxVal = arr[maxDeque.peekFirst()];
                sum  += minVal + maxVal;
                if (minDeque.peekFirst() == i) {
                    minDeque.pollFirst();
                }
                if (maxDeque.peekFirst() == i) {
                    maxDeque.pollFirst();
                }
                i++;
                j++;
            }

        }
        return sum;
    }

}

```

