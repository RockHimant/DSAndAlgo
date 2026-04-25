package slidingwindow;

import java.util.*;

/**
 * Finds the first negative number in each subarray of size k.
 * 
 * Problem Statement:
 * Given an array of integers and a window size k, return an array where each element
 * is the first negative number in the corresponding subarray of size k. If no negative
 * number exists in the subarray, use 0.
 * 
 * Examples:
 * - Input: arr = [12, -1, -7, 8, -15, 30, 16, 28], k = 3
 *   Output: [-1, -1, -7, -15, -15, 0]
 *   Explanation: Subarrays: [12,-1,-7] -> -1, [-1,-7,8] -> -1, etc.
 * 
 * Algorithm:
 * This class uses a Deque to maintain indices of negative numbers in order:
 * - The deque stores indices of negative elements in increasing order.
 * - For each new element, add its index if negative.
 * - When the window is full, the front of the deque has the first negative in the window.
 * - Remove elements from the front that are out of the current window.
 * 
 * Time Complexity: O(n)
 * - Each element is added to and removed from the deque exactly once.
 * - Amortized time for deque operations is O(1) per element.
 * 
 * Space Complexity: O(k)
 * - The deque stores at most k elements (indices of negative numbers in the window).
 * 
 * Key Advantages:
 * - Efficient sliding window with deque for O(1) access to first negative.
 * - Handles large arrays with positive and negative values.
 * 
 * @author Himant
 */
public class FirstNegativeNumberInEverySubArray {

    /**
     * Computes the first negative number for each subarray of size k.
     * 
     * Algorithm Flow:
     * 1. Validate inputs: Return empty array if arr is null/empty.
     * 2. Initialize deque for negative indices and result array.
     * 3. Iterate with j, add negative indices to deque.
     * 4. When window full, record first negative from deque front or 0.
     * 5. Slide window, remove out-of-window indices from deque.
     * 6. Return result array.
     * 
     * Time Complexity: O(n), where n is the array length.
     * Space Complexity: O(k), for the deque.
     * 
     * @param arr the input array of integers
     * @param k the size of the sliding window
     * @return an array of first negative numbers for each subarray of size k;
     *         uses 0 if no negative in subarray; empty array if invalid input
     */
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
