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
