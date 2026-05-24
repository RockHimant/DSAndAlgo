package com.learn.himant.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum With Zero
 *
 * Problem Statement:
 * Given an array of integers, find all unique triplets in the array which gives the sum of zero.
 *
 * Algorithm:
 * This class will implement the two-pointer technique to solve the problem efficiently:
 * - Sort the array first.
 * - For each element, use two pointers to find pairs that sum up to the negative of the current element.
 * - Skip duplicates to ensure unique triplets.
 *
 * Time Complexity: O(n^2)
 * - Sorting takes O(n log n), and the two-pointer search takes O(n^2).
 *
 * Space Complexity: O(1)
 * - Only constant extra space is used for variables.
 *
 * @author Himant
 */
public class ThreesumWithZero {

    public List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++; // Skip duplicates
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--; // Skip duplicates
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

}
