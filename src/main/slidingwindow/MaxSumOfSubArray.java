package slidingwindow;

/**
 * Finds the maximum sum of a subarray of size k.
 * 
 * Problem Statement:
 * Given an array of integers and a window size k, find the maximum sum of any
 * contiguous subarray of size k.
 * 
 * Examples:
 * - Input: arr = [100, 200, 300, 400], k = 2
 *   Output: 700
 *   Explanation: Subarray [300, 400] has sum 700.
 * - Input: arr = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
 *   Output: 39
 *   Explanation: Subarray [4, 2, 10, 23] has sum 39.
 * 
 * Algorithm:
 * This class uses a Sliding Window approach to compute the maximum sum:
 * - Maintain a running sum of the current window.
 * - Slide the window by adding the next element and removing the first.
 * - Track the maximum sum encountered.
 * 
 * Time Complexity: O(n)
 * - Single pass through the array with constant-time operations per element.
 * 
 * Space Complexity: O(1)
 * - Uses only a few variables for sum and pointers.
 * 
 * Key Advantages:
 * - Simple and efficient for fixed window size sum calculations.
 * - Optimal for this problem with no extra space needed.
 * 
 * @author Himant
 */
public class MaxSumOfSubArray {

    /**
     * Computes the maximum sum of any subarray of size k.
     * 
     * Algorithm Flow:
     * 1. Validate inputs: Return 0 if arr is null/empty.
     * 2. Initialize pointers i, j, current sum, and maxSum.
     * 3. Expand window with j, add to sum.
     * 4. When window size == k, update maxSum, subtract arr[i], move i.
     * 5. Return maxSum.
     * 
     * Time Complexity: O(n), where n is the array length.
     * Space Complexity: O(1).
     * 
     * @param arr the input array of integers
     * @param k the size of the subarray
     * @return the maximum sum of any subarray of size k;
     *         returns Integer.MIN_VALUE if k > arr.length or invalid input
     */
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
