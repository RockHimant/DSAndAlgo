package com.learn.himant.slidingwindow;

import org.junit.Test;
import slidingwindow.LongestSubStringWithKUniqueChars;

import static org.junit.Assert.assertEquals;

public class LongestSubStringWithKUniqueCharsTest {

    private final LongestSubStringWithKUniqueChars solution = new LongestSubStringWithKUniqueChars();

    @Test
    public void testBasicCase() {
        assertEquals(7, solution.solve("aabacbebebe", 3));
    }

    @Test
    public void testAllUniqueLessThanK() {
        assertEquals(0, solution.solve("abc", 4));
    }

    @Test
    public void testAllSameChar() {
        assertEquals(0, solution.solve("aaaaa", 2));
    }

    @Test
    public void testKEqualsOne() {
        assertEquals(4, solution.solve("aabbbb", 1));
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, solution.solve("", 1));
    }

    @Test
    public void testNullString() {
        assertEquals(0, solution.solve(null, 1));
    }

    @Test
    public void testKZero() {
        assertEquals(0, solution.solve("abc", 0));
    }

    @Test
    public void testExactK() {
        assertEquals(6, solution.solve("abcabc", 3));
    }

    @Test
    public void testMoreThanKUnique() {
        assertEquals(3, solution.solve("abcd", 3));
    }
}
