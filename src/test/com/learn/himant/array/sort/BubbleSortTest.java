package com.learn.himant.array.sort;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lean.himant.array.sort.BubbleSort;

public class BubbleSortTest {

	@Test
	public void shouldSortInAcendingOrder() {
		BubbleSort bubbleSort = new BubbleSort();
		int arr[] = {3, 2, 7, 5, 1, 0};
		int sortedArr[] = {0, 1, 2, 3, 5, 7};
		bubbleSort.sort(arr);
		assertArrayEquals(sortedArr, arr);
	}
	
	@Test
	public void shouldSortRepeatingElementsToo() {
		BubbleSort bubbleSort = new BubbleSort();
		int arr[] = {3, 2, 7, 5, 1, 0, 7, 3};
		int sortedArr[] = {0, 1, 2, 3, 3, 5, 7, 7};
		bubbleSort.sort(arr);
		assertArrayEquals(sortedArr, arr);
	}
	
}
