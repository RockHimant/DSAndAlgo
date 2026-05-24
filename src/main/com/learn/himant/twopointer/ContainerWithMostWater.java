package com.learn.himant.twopointer;
/**
 * Container With Most Water
 *
 * Problem Statement:
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i are at (i, ai) and (i, 0).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Algorithm:
 * This class will implement the two-pointer technique to solve the problem efficiently:
 * - Initialize two pointers, one at the beginning and one at the end of the array.
 * - Calculate the area formed by the lines at these pointers and update maximum area if needed.
 * - Move the pointer that has the shorter line inward, as this is the limiting factor for area.
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
 * Input: height = [1,7,2,5,4,7,3,6]

    Output: 36
 * 
 * @author Himant
 */
public class ContainerWithMostWater {

    public int solve(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

}
