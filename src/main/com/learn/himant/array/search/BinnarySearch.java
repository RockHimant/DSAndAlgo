package com.learn.himant.array.search;

public class BinnarySearch {

	public int search(int []arr, int element, int start, int end) {
		
		if (end >= start) {
		
			int mid = start + (end - start) / 2;
			
			if(arr[mid] == element)
				return mid;
			
			if(element > arr[mid])
				return search(arr, element, mid+1, end);
			if(element < arr[mid])
				return search(arr, element, start, mid-1);
			
		}
		
		return -1;
	}
}
