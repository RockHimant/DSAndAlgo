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

        int i = 0;
        int j = 0;
        int maxSum = Integer.MIN_VALUE;
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
