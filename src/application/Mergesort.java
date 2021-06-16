package application;

import java.util.ArrayList;

public class Mergesort {

	private Mergesort() {
		throw new IllegalStateException("Utility class");
	}

	// https://www.geeksforgeeks.org/merge-sort/
	private static void merge(int sortMode, ArrayList<Recipe> array, int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		// Create temp arrays
		Recipe[] leftArray = new Recipe[n1];
		Recipe[] rightArray = new Recipe[n2];

		// Copy data to temp array
		for(int i = 0; i < n1; ++i)
			leftArray[i] = array.get(l + i);
		for(int j = 0; j < n2; ++j)
			rightArray[j] = array.get(m + 1 + j);
		
		// Merge the temp arrays

		// Initial indexes of first and second subarrays
        int i = 0;
		int j = 0;

		// Initial index of merged subarry array
		int k = l;
		while(i < n1 && j < n2) {
			if(
				sortMode == 3 && leftArray[i].getTime() <= rightArray[j].getTime() ||
				sortMode == 4 && leftArray[i].getTime() >= rightArray[j].getTime()
			) {
				array.set(k, leftArray[i]);
				i++;
			}
			else {
				array.set(k, rightArray[j]);
				j++;
			}
			k++;
		}

		// Copy remaining elements of L[] if any
		while(i < n1) {
			array.set(k, leftArray[i]);
			i++;
			k++;
		}

		// Copy remaining elements of R[] if any
		while(j < n2) {
			array.set(k, rightArray[j]);
			j++;
			k++;
		}
	}

	/*
	sortMode:
		3 = ascending Time
		4 = descending Time
	*/
	public static void sort(int sortMode, ArrayList<Recipe> array, int l, int r) {
		if(l < r) {
			// Find the middle point
			int m = l+(r-l)/2;

			// Sort first and seconds halves
			sort(sortMode, array, l, m);
			sort(sortMode, array, m + 1, r);

			// Merge the sorted halves
			merge(sortMode, array, l, m, r);
		}
	}
}
