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
