package com.learn.himant.arrayAndHashing;

/* 
 * Problem Statement:
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * 
 * Algorithm:
 * This class will implement a solution using a HashMap to store the complement of each number and its index.
 * 
 * Time Complexity: O(n)
 * - Iterating through the array takes O(n) time.
 * - Adding and retrieving elements from the HashMap takes O(1) average time.
 * 
 * Space Complexity: O(n)
 * - In the worst case, the HashMap will store all n elements.
 * 
 * @author Himant
 */
public class TwoSum {

    public int[] solve(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0]; // No solution possible
        }
        java.util.HashMap<Integer, Integer> numToIndex = new java.util.HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i}; // Return indices of the two numbers
            }
            numToIndex.put(nums[i], i); // Store the index of the current number
        }
        return new int[0]; // No solution found
    }

}
