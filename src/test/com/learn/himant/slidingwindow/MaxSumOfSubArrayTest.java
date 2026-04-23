package com.learn.himant.slidingwindow;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import slidingwindow.MaxSumOfSubArray;

public class MaxSumOfSubArrayTest {

    @Test
    public void shouldPass1() {
        int[] arr = { 100, 200, 300, 400 };
        MaxSumOfSubArray maxSumOfSubArray = new MaxSumOfSubArray();
        int result = maxSumOfSubArray.solve(arr, 2);
        assertEquals(700, result);
    }

    @Test
    public void shouldPass2() {
        int[] arr = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
        MaxSumOfSubArray maxSumOfSubArray = new MaxSumOfSubArray();
        int result = maxSumOfSubArray.solve(arr, 4);
        assertEquals(39, result);
    }

}
