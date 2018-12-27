package com.learn.himant.array.sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import com.lean.himant.array.sort.MergeSort;

public class MergeSortTest {
	
	private MergeSort mergeSort;
	
	

	@Before
	public void setUp() {
		mergeSort = new MergeSort();
	}
	
	@Test
	public void shouldSortSuccessFully() {
		int[] sampleArray = {4, 3, 8, 1, 6, 0, 9};
		int sortedArr[] = {0, 1, 3, 4, 6, 8, 9};
		mergeSort.sort(sampleArray, 0, sampleArray.length - 1);
		assertArrayEquals(sortedArr, sampleArray);
	}
	
	
	@Test
	public void shouldSortSuccessFullyWithRepeatedelement() {
		int[] sampleArray = {4, 3, 8,8, 1, 6, 0, 9};
		int sortedArr[] = {0, 1, 3, 4, 6, 8,8, 9};
		mergeSort.sort(sampleArray, 0, sampleArray.length - 1);
		assertArrayEquals(sortedArr, sampleArray);
	}

}
