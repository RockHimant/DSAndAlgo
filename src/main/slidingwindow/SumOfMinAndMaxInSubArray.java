package slidingwindow;

/**
 * Computes the sum of minimum and maximum elements for each subarray of size k.
 * 
 * Problem Statement:
 * Given an array of integers and a window size k, calculate the sum of the minimum
 * and maximum elements for each subarray of size k, then return the total sum of these values.
 * 
 * Examples:
 * - Input: arr = {2, 5, -1, 7, -3, -1, -2}, k = 4
 *   Output: 18
 *   Explanation: Subarrays: {2,5,-1,7} min+max=6, {5,-1,7,-3}=4, {-1,7,-3,-1}=4, {7,-3,-1,-2}=4, sum=18
 * 
 * Algorithm:
 * This class uses two Deques to maintain the minimum and maximum elements in the current window:
 * - minDeque stores indices in increasing order of values (front is minimum).
 * - maxDeque stores indices in decreasing order of values (front is maximum).
 * - For each window, sum the front values of both deques.
 * - Slide the window by removing out-of-window elements from deques.
 * 
 * Time Complexity: O(n)
 * - Each element is added to and removed from each deque exactly once.
 * - Amortized time for deque operations is O(1) per element.
 * 
 * Space Complexity: O(k)
 * - Each deque stores at most k elements (indices in the window).
 * 
 * Key Advantages:
 * - Efficient sliding window with dual deques for min/max tracking.
 * - Handles arrays with positive and negative integers.
 * 
 * @author Himant
 */
import java.util.Deque;

public class SumOfMinAndMaxInSubArray {

    /**
     * Computes the total sum of (min + max) for each subarray of size k.
     * 
     * Algorithm Flow:
     * 1. Validate inputs: Return 0 if arr is null/empty.
     * 2. Initialize minDeque and maxDeque for tracking indices.
     * 3. Iterate with j, maintain deques for min and max.
     * 4. When window full, add min + max to sum, slide window.
     * 5. Return total sum.
     * 
     * Time Complexity: O(n), where n is the array length.
     * Space Complexity: O(k), for the deques.
     * 
     * @param arr the input array of integers
     * @param k the size of the sliding window
     * @return the sum of (min + max) for each subarray of size k;
     *         returns 0 if invalid input
     */
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
