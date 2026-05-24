package com.learn.himant.arrayAndHashing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {@link ContainsDuplicate}.
 *
 * @author Himant
 */
public class ContainsDuplicateTest {

    private ContainsDuplicate containsDuplicate;

    @Before
    public void setUp() {
        containsDuplicate = new ContainsDuplicate();
    }

    @Test
    public void shouldReturnFalseForNullArray() {
        assertFalse(containsDuplicate.solve(null));
    }

    @Test
    public void shouldReturnFalseForEmptyArray() {
        assertFalse(containsDuplicate.solve(new int[] {}));
    }

    @Test
    public void shouldReturnFalseForSingleElementArray() {
        assertFalse(containsDuplicate.solve(new int[] {42}));
    }

    @Test
    public void shouldReturnFalseWhenNoDuplicatesExist() {
        final int[] nums = {1, 2, 3, 4, 5};
        assertFalse(containsDuplicate.solve(nums));
    }

    @Test
    public void shouldReturnTrueWhenDuplicateElementsAppear() {
        final int[] nums = {1, 2, 3, 4, 3};
        assertTrue(containsDuplicate.solve(nums));
    }

    @Test
    public void shouldReturnTrueWhenDuplicateElementsAppearAtStart() {
        final int[] nums = {7, 7, 8, 9};
        assertTrue(containsDuplicate.solve(nums));
    }

    @Test
    public void shouldHandleNegativeNumbersAndReturnTrueForDuplicates() {
        final int[] nums = {-1, 0, -2, -1};
        assertTrue(containsDuplicate.solve(nums));
    }

    @Test
    public void shouldHandleNegativeNumbersAndReturnFalseWhenUnique() {
        final int[] nums = {-1, 0, -2, 3};
        assertFalse(containsDuplicate.solve(nums));
    }
}
