package com.learn.himant.array;

/**
 * Program to sort an given integer array using Bubble sort algorithm
 * @author Himant Dewangan
 *
 */
public class BubbleSort {

	public int[] sort(int[] arr) {
		for(int i = 0; i< arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
		return arr;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
