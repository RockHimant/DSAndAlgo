package com.learn.himant.slidingwindow;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import slidingwindow.SumOfMinAndMaxInSubArray;

public class SumOfMinAndMaxInSubArrayTest {

    @Test
    public void shouldPass1() {
        SumOfMinAndMaxInSubArray obj = new SumOfMinAndMaxInSubArray();
        int[] arr = {2, 5, -1, 7, -3, -1, -2};
        int k = 4;
        int result = obj.solve(arr, k);
        System.out.println(result); 
        assertEquals(18, result);
    }

}
