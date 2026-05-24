package com.learn.himant.arrayAndHashing;

/* 
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class ProductOfArrayExceptForSelf {

    public int[] solve(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0]; // No elements to process
        }
        int n = nums.length;
        int[] result = new int[n];
        // Calculate the product of all elements to the left of each index
        result[0] = 1; // No elements to the left of the first element
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        // Calculate the product of all elements to the right and multiply with the left products
        int rightProduct = 1; // No elements to the right of the last element
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct; // Multiply with the product from the right
            rightProduct *= nums[i]; // Update the right product for the next iteration
        }
        return result;
    }
}
