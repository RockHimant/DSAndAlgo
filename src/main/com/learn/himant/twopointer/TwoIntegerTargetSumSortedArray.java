package com.learn.himant.twopointer;

/**
 * Two Sum II - Input Array is Sorted
 *
 * Problem Statement:
 * Given a sorted array of integers, find two numbers such that they add up to a specific target.
 *
 * Algorithm:
 * This class will implement the two-pointer technique to solve the problem efficiently:
 * - Initialize two pointers, one at the beginning and one at the end of the array.
 * - Move the pointers towards each other based on the comparison of their sum with the target.
 * - If the sum equals the target, return the indices.
 * - If the sum is less than the target, move the left pointer right.
 * - If the sum is greater than the target, move the right pointer left.
 *
 * Time Complexity: O(n)
 * - Each element is visited at most once.
 *
 * Space Complexity: O(1)
 * - Only constant extra space is used for variables.
 *
 * @author Himant
 */
public class TwoIntegerTargetSumSortedArray {

    public int[] solve(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[0];
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // Return 1-based indices
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0]; // No solution found
    }

}
