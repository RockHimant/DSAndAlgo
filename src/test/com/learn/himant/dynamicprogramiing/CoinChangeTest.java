package com.learn.himant.dynamicprogramiing;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CoinChangeTest {

    private final CoinChange solution = new CoinChange();

    @Test
    public void testBasicCase() {
        int[] coins = {1, 2, 5};
        assertEquals(3, solution.solve(coins, 11)); // 5 + 5 + 1
    }

    @Test
    public void testAmountZero() {
        int[] coins = {1, 2, 5};
        assertEquals(0, solution.solve(coins, 0));
    }

    @Test
    public void testNegativeAmount() {
        int[] coins = {1, 2, 5};
        assertEquals(-1, solution.solve(coins, -1));
    }

    @Test
    public void testEmptyCoins() {
        int[] coins = {};
        assertEquals(-1, solution.solve(coins, 1));
    }

    @Test
    public void testNullCoins() {
        assertEquals(-1, solution.solve(null, 1));
    }

    @Test
    public void testImpossibleAmount() {
        int[] coins = {2};
        assertEquals(-1, solution.solve(coins, 3)); // Can't make 3 with only 2s
    }

    @Test
    public void testSingleCoinType() {
        int[] coins = {3};
        assertEquals(2, solution.solve(coins, 6)); // 3 + 3
    }

    @Test
    public void testLargeAmount() {
        int[] coins = {1, 2, 5, 10};
        assertEquals(2, solution.solve(coins, 12)); // 10 + 2
    }

    @Test
    public void testNoCoinsNeeded() {
        int[] coins = {1, 2, 5};
        assertEquals(1, solution.solve(coins, 1)); // Just 1
    }
}