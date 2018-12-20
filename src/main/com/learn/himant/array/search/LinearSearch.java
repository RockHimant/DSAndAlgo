package com.learn.himant.array.search;

/**
 * Program to search an element in an integer array. * 
 * @author himantd
 *
 */
public class LinearSearch {

	
	/**
	 * searches the element in given integer array.
	 * If element is found in the array, the index is returned.
	 * If element is not found it returns -1.
	 *
	 * @param arr the arr the input array.
	 * @param element the element to be searched
	 * @return the index of the element in the array.
	 */
	public int search(int[] arr, int element) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == element) {
				return i;
			}
		}
		return -1;
	}
}
