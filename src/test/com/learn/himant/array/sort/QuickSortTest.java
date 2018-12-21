package com.learn.himant.array.sort;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.lean.himant.array.sort.QuickSort;

public class QuickSortTest {

	private QuickSort quickSort;
	
	@Before
	public void setUp() {
		quickSort = new QuickSort();
	}
	
	@Test
	public void shouldSortSuccessfully() {
		final int[] arr = {5, 2, 6, 4, 8, 9, 0};
		final int[] sortedArray = {0, 2, 4, 5, 6, 8, 9};
		quickSort.sort(arr, 0, arr.length-1);
		assertArrayEquals(sortedArray, arr);
	}
	
	
	@Test
	public void shouldSortcorrectlyRepeatedElement() {
		final int[] arr = {4, 2, 6, 4, 8, 9, 9, 1};
		final int[] sortedArray = {1, 2, 4, 4, 6, 8, 9, 9};
		quickSort.sort(arr, 0, arr.length-1);
		assertArrayEquals(sortedArray, arr);
	}

}
