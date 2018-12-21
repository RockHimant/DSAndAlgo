package com.lean.himant.array.sort;

/**
 * First select the partition index in order to sort the array.
 * For selecting partition index :
 * 	. First select the pivot value (the last element in the array)
 *  . Place the pivot in array such that, all the smaller values are to the left of the pivote and
 *    greater elements are to the right side of the pivot.
 *  . return the place of pivot
 *  
 * After selecting Partition, the pivot value is at correct place
 * then repeat the process for two section of the array
 * 
 * Sort(array, low, p-1)  --> where p is the position of pivot
 * sort(array, p+1, high)
 * 
 * The complexity is 0(n^2) in worst case scenario, best case O(n log(n))
 * 
 * @author Himant Dewangan
 *
 */
public class QuickSort {

	public void sort(final int[] arr, int low, int high) {
		if(high > low) {
			int p = partition(arr, low, high);
			sort(arr, low, p -1);
			sort(arr, p +1, high);
		}
	}

	private int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for(int j = low; j < high; j++) {
			if(arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int temp = arr[i + 1];
		arr[i + 1] = pivot;
		arr[high] = temp;
		return i + 1;
	}
}
