package com.learn.himant.slidingwindow;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import slidingwindow.FindOccurancesOfAnagram;

public class FindOccurancesOfAnagramTest {

    @Test
    public void shouldReturn3ForForxxorfxdofr() {
        FindOccurancesOfAnagram obj = new FindOccurancesOfAnagram();
        String txt = "forxxorfxdofr";
        String pat = "for";
        int result = obj.solve(txt, pat);
        System.out.println("Test 1 - Result: " + result);
        assertEquals(3, result);
    }

    @Test
    public void shouldReturn4ForAabaabaa() {
        FindOccurancesOfAnagram obj = new FindOccurancesOfAnagram();
        String txt = "aabaabaa";
        String pat = "aaba";
        int result = obj.solve(txt, pat);
        System.out.println("Test 2 - Result: " + result);
        assertEquals(4, result);
    }

    @Test
    public void shouldReturn0WhenNoAnagramFound() {
        FindOccurancesOfAnagram obj = new FindOccurancesOfAnagram();
        String txt = "abcdefgh";
        String pat = "xyz";
        int result = obj.solve(txt, pat);
        System.out.println("Test 3 - Result: " + result);
        assertEquals(0, result);
    }

    @Test
    public void shouldReturn0WhenTextIsNull() {
        FindOccurancesOfAnagram obj = new FindOccurancesOfAnagram();
        String txt = null;
        String pat = "abc";
        int result = obj.solve(txt, pat);
        System.out.println("Test 4 - Result: " + result);
        assertEquals(0, result);
    }

    @Test
    public void shouldReturn0WhenPatternIsNull() {
        FindOccurancesOfAnagram obj = new FindOccurancesOfAnagram();
        String txt = "abcdef";
        String pat = null;
        int result = obj.solve(txt, pat);
        System.out.println("Test 5 - Result: " + result);
        assertEquals(0, result);
    }

    @Test
    public void shouldReturn0WhenPatternLongerThanText() {
        FindOccurancesOfAnagram obj = new FindOccurancesOfAnagram();
        String txt = "abc";
        String pat = "abcdef";
        int result = obj.solve(txt, pat);
        System.out.println("Test 6 - Result: " + result);
        assertEquals(0, result);
    }

    @Test
    public void shouldReturn1WhenSingleAnagram() {
        FindOccurancesOfAnagram obj = new FindOccurancesOfAnagram();
        String txt = "listen";
        String pat = "silent";
        int result = obj.solve(txt, pat);
        System.out.println("Test 7 - Result: " + result);
        assertEquals(1, result);
    }

    @Test
    public void shouldReturn2WhenRepeatedCharacters() {
        FindOccurancesOfAnagram obj = new FindOccurancesOfAnagram();
        String txt = "aaaaaa";
        String pat = "aa";
        int result = obj.solve(txt, pat);
        System.out.println("Test 8 - Result: " + result);
        assertEquals(5, result);
    }

    @Test
    public void shouldReturn1WhenExactMatch() {
        FindOccurancesOfAnagram obj = new FindOccurancesOfAnagram();
        String txt = "hello";
        String pat = "hello";
        int result = obj.solve(txt, pat);
        System.out.println("Test 9 - Result: " + result);
        assertEquals(1, result);
    }

    @Test
    public void shouldReturnCorrectCountWithMixedCharacters() {
        FindOccurancesOfAnagram obj = new FindOccurancesOfAnagram();
        String txt = "abab";
        String pat = "ab";
        int result = obj.solve(txt, pat);
        System.out.println("Test 10 - Result: " + result);
        assertEquals(3, result);
    }

}
