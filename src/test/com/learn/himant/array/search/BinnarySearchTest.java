package com.learn.himant.array.search;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BinnarySearchTest {

	private BinnarySearch binnarySearch;
	
	@Before
	public void setUp() {
		binnarySearch = new BinnarySearch();
	}
	
	@Test
	public void shouldSearchElementSuccessfully() {
		final int[] arr = {1, 2,3 ,4 ,5 ,6,7};
		final int result = binnarySearch.search(arr, 3, 0, arr.length-1);
		assertEquals(2, result);
	}
	
	@Test
	public void shouldReturnMinusOneIfElementNotFound() {
		final int []arr = {1, 2,3 ,4 ,5 ,6,7};
		final int result = binnarySearch.search(arr, 9, 0, arr.length-1);
		assertEquals(-1, result);
	}
}
