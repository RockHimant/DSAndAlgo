package com.learn.himant.arrayAndHashing;

/* 
 * Problem Statement:
 * Given an array of integers, determine if the array contains any duplicate elements.
 * 
 * Algorithm:
 * This class will implement a solution using a HashSet to efficiently check for duplicates.
 * 
 * Time Complexity: O(n)
 * - Iterating through the array takes O(n) time.
 * - Adding elements to the HashSet takes O(1) average time.
 * 
 * Space Complexity: O(n)
 * - In the worst case, all elements are unique, and the HashSet will store all n elements.
 * 
 * @author Himant
 */
public class ContainsDuplicate {
    public boolean solve(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false; // No duplicates possible
        }
        java.util.HashSet<Integer> seen = new java.util.HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // Duplicate found
            }
            seen.add(num);
        }
        return false; // No duplicates found
    }

}
