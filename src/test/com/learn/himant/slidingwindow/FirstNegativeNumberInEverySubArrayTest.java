package com.learn.himant.slidingwindow;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import slidingwindow.FirstNegativeNumberInEverySubArray;

public class FirstNegativeNumberInEverySubArrayTest {

    @Test
    public void shouldPass1() {
        FirstNegativeNumberInEverySubArray obj = new FirstNegativeNumberInEverySubArray();
        int[] arr = {2, -1, 3, -4, 5, -6};
        int k = 3;
        int[] result = obj.solve(arr, k);
        for (int num : result) {
            System.out.print(num + " ");
        }

        assertArrayEquals(new int[]{-1, -1, -4, -4}, result);
    }

     @Test
    public void shouldPass2() {
        FirstNegativeNumberInEverySubArray obj = new FirstNegativeNumberInEverySubArray();
        int[] arr ={12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        int[] result = obj.solve(arr, k);
        for (int num : result) {
            System.out.print(num + " ");
        }

        assertArrayEquals(new int[]{-1, -1, -7, -15, -15, 0}, result);
    }

    @Test
    public void shouldPasswithAllZero() {
        FirstNegativeNumberInEverySubArray obj = new FirstNegativeNumberInEverySubArray();
        int[] arr = {12, 1, 3, 5};
        int k = 2;
        int[] result = obj.solve(arr, k);
        for (int num : result) {
            System.out.print(num + " ");
        }

        assertArrayEquals(new int[]{0, 0, 0}, result);
    }

}
