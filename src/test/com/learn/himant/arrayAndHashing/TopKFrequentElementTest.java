package com.learn.himant.arrayAndHashing;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TopKFrequentElementTest {

    private TopKFrequentElement topKFrequentElement;

    @Before
    public void setUp() {
        topKFrequentElement = new TopKFrequentElement();
    }

    @Test
    public void shouldReturnEmptyForNullInputWithPQ() {
        assertEquals(0, topKFrequentElement.solve(null, 3).length);
    }

    @Test
    public void shouldReturnEmptyForInvalidKWithPQ() {
        assertEquals(0, topKFrequentElement.solve(new int[] {1, 2, 3}, 0).length);
    }

    @Test
    public void shouldReturnTopKFrequentElementsWithPQ() {
        int[] actual = topKFrequentElement.solve(new int[] {1, 1, 1, 2, 2, 3}, 2);
        assertNotNull(actual);
        assertEquals(2, actual.length);
        assertArrayContainsSameElements(actual, 1, 2);
    }

    @Test
    public void shouldReturnTopKWithPQWhenMultipleFrequenciesShareSameRank() {
        int[] actual = topKFrequentElement.solve(new int[] {4, 4, 6, 6, 7, 8}, 2);
        assertNotNull(actual);
        assertEquals(2, actual.length);
        assertArrayContainsSameElements(actual, 4, 6);
    }

    @Test
    public void shouldReturnAllUniqueElementsWhenKExceedsUniqueCountWithPQ() {
        int[] actual = topKFrequentElement.solve(new int[] {5, 5, 6}, 5);
        assertNotNull(actual);
        assertEquals(2, actual.length);
        assertArrayContainsSameElements(actual, 5, 6);
    }

    @Test
    public void shouldReturnEmptyForNullInputWithoutPQ() {
        assertEquals(0, topKFrequentElement.solveWithoutPQ(null, 3).length);
    }

    @Test
    public void shouldReturnEmptyForInvalidKWithoutPQ() {
        assertEquals(0, topKFrequentElement.solveWithoutPQ(new int[] {1, 2, 3}, 0).length);
    }

    @Test
    public void shouldReturnTopKFrequentElementsWithoutPQ() {
        int[] actual = topKFrequentElement.solveWithoutPQ(new int[] {1, 1, 1, 2, 2, 3}, 2);
        assertNotNull(actual);
        assertEquals(2, actual.length);
        assertArrayContainsSameElements(actual, 1, 2);
    }

    @Test
    public void shouldReturnTopKWithoutPQWhenMultipleFrequenciesShareSameRank() {
        int[] actual = topKFrequentElement.solveWithoutPQ(new int[] {4, 4, 6, 6, 7, 8}, 2);
        assertNotNull(actual);
        assertEquals(2, actual.length);
        assertArrayContainsSameElements(actual, 4, 6);
    }

    @Test
    public void shouldReturnAllUniqueElementsWhenKExceedsUniqueCountWithoutPQ() {
        int[] actual = topKFrequentElement.solveWithoutPQ(new int[] {5, 5, 6}, 5);
        assertNotNull(actual);
        assertEquals(2, actual.length);
        assertArrayContainsSameElements(actual, 5, 6);
    }

    private void assertArrayContainsSameElements(int[] actual, int... expected) {
        List<Integer> actualList = new ArrayList<>();
        for (int num : actual) {
            actualList.add(num);
        }
        List<Integer> expectedList = new ArrayList<>();
        for (int num : expected) {
            expectedList.add(num);
        }
        assertEquals(expectedList.size(), actualList.size());
        assertTrue(actualList.containsAll(expectedList));
    }
}
