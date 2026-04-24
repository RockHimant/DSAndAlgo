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
