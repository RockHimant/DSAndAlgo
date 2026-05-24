package com.learn.himant.arrayAndHashing;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {@link ProductOfArrayExceptForSelf}.
 *
 * @author Himant
 */
public class ProductOfArrayExceptForSelfTest {

    private ProductOfArrayExceptForSelf solver;

    @Before
    public void setUp() {
        solver = new ProductOfArrayExceptForSelf();
    }

    @Test
    public void shouldReturnEmptyForNullInput() {
        assertEquals(0, solver.solve(null).length);
    }

    @Test
    public void shouldReturnEmptyForEmptyArray() {
        assertEquals(0, solver.solve(new int[] {}).length);
    }

    @Test
    public void shouldReturnOneForSingleElementArray() {
        assertArrayEquals(new int[] {1}, solver.solve(new int[] {7}));
    }

    @Test
    public void shouldReturnProductExceptSelfForPositiveValues() {
        assertArrayEquals(new int[] {24, 12, 8, 6}, solver.solve(new int[] {1, 2, 3, 4}));
    }

    @Test
    public void shouldReturnProductExceptSelfWhenOneZeroIsPresent() {
        assertArrayEquals(new int[] {0, 0, 8, 0}, solver.solve(new int[] {1, 2, 0, 4}));
    }

    @Test
    public void shouldReturnZerosWhenMultipleZerosPresent() {
        assertArrayEquals(new int[] {0, 0, 0, 0}, solver.solve(new int[] {0, 2, 0, 4}));
    }

    @Test
    public void shouldReturnProductExceptSelfWithNegativeValues() {
        assertArrayEquals(new int[] {0, 0, 9, 0, 0}, solver.solve(new int[] {-1, 1, 0, -3, 3}));
    }
}
