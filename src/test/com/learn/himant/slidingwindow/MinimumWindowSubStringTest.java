package com.learn.himant.slidingwindow;

import org.junit.Test;
import slidingwindow.MinimumWindowSubString;

import static org.junit.Assert.assertEquals;

public class MinimumWindowSubStringTest {

    private final MinimumWindowSubString solution = new MinimumWindowSubString();

    @Test
    public void testBasicCase() {
        assertEquals("BANC", solution.solve("ADOBECODEBANC", "ABC"));
    }

    @Test
    public void testNoWindow() {
        assertEquals("", solution.solve("a", "aa"));
    }

    @Test
    public void testDuplicates() {
        assertEquals("aa", solution.solve("aa", "aa"));
    }

    @Test
    public void testEmptyStrings() {
        assertEquals("", solution.solve("", "a"));
        assertEquals("", solution.solve("a", ""));
    }

    @Test
    public void testNullInputs() {
        assertEquals("", solution.solve(null, "a"));
        assertEquals("", solution.solve("a", null));
    }

    @Test
    public void testSingleCharacter() {
        assertEquals("a", solution.solve("a", "a"));
    }

    @Test
    public void testLargerWindow() {
        assertEquals("abc", solution.solve("aabcbcdbca", "abc"));
    }
}