package com.learn.himant.slidingwindow;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import slidingwindow.MaxOfAllSubArrayofSizeK;

public class MaxOfAllSubArrayofSizeKTest {

    @Test
    public void shouldReturnMaxForEachSubarrayOfSize3() {
        MaxOfAllSubArrayofSizeK obj = new MaxOfAllSubArrayofSizeK();
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] expected = {3, 3, 5, 5, 6, 7};
        int[] result = obj.solve(arr, k);
        System.out.println("Test 1 - Result: " + java.util.Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnMaxForEachSubarrayOfSize1() {
        MaxOfAllSubArrayofSizeK obj = new MaxOfAllSubArrayofSizeK();
        int[] arr = {1, 2, 3, 4};
        int k = 1;
        int[] expected = {1, 2, 3, 4};
        int[] result = obj.solve(arr, k);
        System.out.println("Test 2 - Result: " + java.util.Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnMaxForEachSubarrayOfSizeEqualToLength() {
        MaxOfAllSubArrayofSizeK obj = new MaxOfAllSubArrayofSizeK();
        int[] arr = {1, 2, 3};
        int k = 3;
        int[] expected = {3};
        int[] result = obj.solve(arr, k);
        System.out.println("Test 3 - Result: " + java.util.Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnEmptyArrayWhenKGreaterThanLength() {
        MaxOfAllSubArrayofSizeK obj = new MaxOfAllSubArrayofSizeK();
        int[] arr = {1, 2};
        int k = 3;
        int[] expected = {};
        int[] result = obj.solve(arr, k);
        System.out.println("Test 4 - Result: " + java.util.Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnEmptyArrayWhenArrayIsNull() {
        MaxOfAllSubArrayofSizeK obj = new MaxOfAllSubArrayofSizeK();
        int[] arr = null;
        int k = 2;
        int[] expected = {};
        int[] result = obj.solve(arr, k);
        System.out.println("Test 5 - Result: " + java.util.Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnEmptyArrayWhenArrayIsEmpty() {
        MaxOfAllSubArrayofSizeK obj = new MaxOfAllSubArrayofSizeK();
        int[] arr = {};
        int k = 2;
        int[] expected = {};
        int[] result = obj.solve(arr, k);
        System.out.println("Test 6 - Result: " + java.util.Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnEmptyArrayWhenKIsZero() {
        MaxOfAllSubArrayofSizeK obj = new MaxOfAllSubArrayofSizeK();
        int[] arr = {1, 2, 3};
        int k = 0;
        int[] expected = {};
        int[] result = obj.solve(arr, k);
        System.out.println("Test 7 - Result: " + java.util.Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnEmptyArrayWhenKIsNegative() {
        MaxOfAllSubArrayofSizeK obj = new MaxOfAllSubArrayofSizeK();
        int[] arr = {1, 2, 3};
        int k = -1;
        int[] expected = {};
        int[] result = obj.solve(arr, k);
        System.out.println("Test 8 - Result: " + java.util.Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldHandleNegativeNumbers() {
        MaxOfAllSubArrayofSizeK obj = new MaxOfAllSubArrayofSizeK();
        int[] arr = {-1, -2, -3, -4};
        int k = 2;
        int[] expected = {-1, -2, -3};
        int[] result = obj.solve(arr, k);
        System.out.println("Test 9 - Result: " + java.util.Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldHandleDuplicates() {
        MaxOfAllSubArrayofSizeK obj = new MaxOfAllSubArrayofSizeK();
        int[] arr = {2, 2, 2, 2};
        int k = 2;
        int[] expected = {2, 2, 2};
        int[] result = obj.solve(arr, k);
        System.out.println("Test 10 - Result: " + java.util.Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test 
    public void shouldPassNeat150Input() {
        MaxOfAllSubArrayofSizeK obj = new MaxOfAllSubArrayofSizeK();
        int[] arr = {7,2,4};
        int k = 2;
        int[] expected = {7,4};
        int[] result = obj.solve(arr, k);
        System.out.println("Test Neat150 - Result: " + java.util.Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

}