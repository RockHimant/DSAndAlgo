package com.learn.himant.slidingwindow;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import slidingwindow.LargestSubArrayWithSumK;

public class LargestSubArrayWithSumKTest {

    @Test
    public void shouldReturn4ForArrayWithSumK() {
        LargestSubArrayWithSumK obj = new LargestSubArrayWithSumK();
        int[] arr = {10, 5, 2, 7, 1, -10};
        int k = 15;
        int result = obj.solve(arr, k);
        System.out.println("Test 1 - Result: " + result);
        assertEquals(6, result); // Subarray [10, 5, 2, 7, 1, -10] sum=15, length=6
    }

    @Test
    public void shouldReturn2ForSimpleCase() {
        LargestSubArrayWithSumK obj = new LargestSubArrayWithSumK();
        int[] arr = {1, 2, 3};
        int k = 5;
        int result = obj.solve(arr, k);
        System.out.println("Test 2 - Result: " + result);
        assertEquals(2, result); // [2,3] sum=5
    }

    @Test
    public void shouldReturn0WhenNoSubarraySumsToK() {
        LargestSubArrayWithSumK obj = new LargestSubArrayWithSumK();
        int[] arr = {1, 2, 3};
        int k = 10;
        int result = obj.solve(arr, k);
        System.out.println("Test 3 - Result: " + result);
        assertEquals(0, result);
    }

    @Test
    public void shouldReturn1WhenSingleElementEqualsK() {
        LargestSubArrayWithSumK obj = new LargestSubArrayWithSumK();
        int[] arr = {5, 1, 2};
        int k = 5;
        int result = obj.solve(arr, k);
        System.out.println("Test 4 - Result: " + result);
        assertEquals(1, result);
    }

    @Test
    public void shouldReturn0WhenArrayIsNull() {
        LargestSubArrayWithSumK obj = new LargestSubArrayWithSumK();
        int[] arr = null;
        int k = 5;
        int result = obj.solve(arr, k);
        System.out.println("Test 5 - Result: " + result);
        assertEquals(0, result);
    }

    @Test
    public void shouldReturn0WhenArrayIsEmpty() {
        LargestSubArrayWithSumK obj = new LargestSubArrayWithSumK();
        int[] arr = {};
        int k = 5;
        int result = obj.solve(arr, k);
        System.out.println("Test 6 - Result: " + result);
        assertEquals(0, result);
    }

    @Test
    public void shouldReturn0WhenKIsZero() {
        LargestSubArrayWithSumK obj = new LargestSubArrayWithSumK();
        int[] arr = {1, 2, 3};
        int k = 0;
        int result = obj.solve(arr, k);
        System.out.println("Test 7 - Result: " + result);
        assertEquals(0, result); // Assuming no empty subarray, or depending on problem
    }

    @Test
    public void shouldHandleZeros() {
        LargestSubArrayWithSumK obj = new LargestSubArrayWithSumK();
        int[] arr = {0, 1, 2, 0, 3};
        int k = 3;
        int result = obj.solve(arr, k);
        System.out.println("Test 8 - Result: " + result);
        assertEquals(4, result); // [0,1,2,0] sum=3, length=4
    }

    @Test
    public void shouldReturnCorrectForAllOnes() {
        LargestSubArrayWithSumK obj = new LargestSubArrayWithSumK();
        int[] arr = {1, 1, 1, 1};
        int k = 3;
        int result = obj.solve(arr, k);
        System.out.println("Test 9 - Result: " + result);
        assertEquals(3, result); // [1,1,1]
    }

    @Test
    public void shouldReturn1ForKEqualsElement() {
        LargestSubArrayWithSumK obj = new LargestSubArrayWithSumK();
        int[] arr = {2, 4, 6};
        int k = 4;
        int result = obj.solve(arr, k);
        System.out.println("Test 10 - Result: " + result);
        assertEquals(1, result);
    }

}