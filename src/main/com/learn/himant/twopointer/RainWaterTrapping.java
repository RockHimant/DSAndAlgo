package com.learn.himant.twopointer;
/**
 * Rain Water Trapping
 *
 * Problem Statement:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Algorithm:
 * This class will implement the two-pointer technique to solve the problem efficiently:
 * - Initialize two pointers, one at the beginning and one at the end of the array.
 * - Keep track of the maximum height from both ends.
 * - Move the pointer that has the shorter height inward, and calculate trapped water based on the difference between current height and maximum height.
 * - Repeat until the pointers meet.
 *
 * Time Complexity: O(n)
 * - Each element is visited at most once by either pointer.
 *
 * Space Complexity: O(1)
 * - Only constant extra space is used for variables.
 *
 * Key Advantages:
 * - Efficient O(n) time complexity compared to brute-force O(n^2).
 * - Simple implementation using two pointers.
 *
 * 
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]

    Output: 6
 *
 * @author Himant
 */

public class RainWaterTrapping {

    public int solve(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }
        return trappedWater;
    }

}
