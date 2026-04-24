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
