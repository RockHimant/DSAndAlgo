package com.learn.himant.array.search;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class to test Linear Search.
 * @author Himant Dewangan
 *
 */
public class LinearSearchTest {

	private LinearSearch linearSearch;
	
	@Before
	public void setUp() {
		linearSearch = new LinearSearch();
	}
	
	@Test
	public void shouldSearchElementSuccessfully() {
		final int[] arr = {3, 5, 1, 6, 8, 9, 0, 4};
		int result = linearSearch.search(arr, 5);
		assertEquals(1, result);
		
	}
	
	@Test
	public void shouldReturnFirstOccuredElementIfRepeatedElementPresentInArray() {
		final int[] arr = {3, 5, 1, 6, 8, 9, 0, 4, 1};
		int result = linearSearch.search(arr, 1);
		assertEquals(2, result);
	}
	
	@Test
	public void shouldTestIfElementNotPresent() {
		final int[] arr = {3, 5, 1, 6, 8, 9, 0, 4, 1};
		int result = linearSearch.search(arr, 32);
		assertEquals(-1, result);
	}
}
