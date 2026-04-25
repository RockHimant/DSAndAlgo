package com.learn.himant.slidingwindow;

import org.junit.Test;
import slidingwindow.LongestSubStringWithoutRepeatingCharacters;

import static org.junit.Assert.assertEquals;

public class LongestSubStringWithoutRepeatingCharactersTest {

    private final LongestSubStringWithoutRepeatingCharacters solution = new LongestSubStringWithoutRepeatingCharacters();

    @Test
    public void testBasicCase() {
        assertEquals(3, solution.solve("abcabcbb"));
    }

    @Test
    public void testAllRepeating() {
        assertEquals(1, solution.solve("bbbbb"));
    }

    @Test
    public void testAllUnique() {
        assertEquals(5, solution.solve("abcde"));
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, solution.solve(""));
    }

    @Test
    public void testNullString() {
        assertEquals(0, solution.solve(null));
    }

    @Test
    public void testSingleCharacter() {
        assertEquals(1, solution.solve("a"));
    }

    @Test
    public void testWithSpaces() {
        assertEquals(3, solution.solve("a b c d"));
    }

    @Test
    public void testComplexCase() {
        assertEquals(3, solution.solve("pwwkew"));
    }
}