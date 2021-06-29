package application.sort;

import java.util.ArrayList;

import application.recipe.Recipe;

public class Mergesort {

	private Mergesort() {
		throw new IllegalStateException("Utility class");
	}

	// https://www.geeksforgeeks.org/merge-sort/
	private static void merge(boolean isAsc, ArrayList<Recipe> array, int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		// Create temp arrays
		Recipe[] leftArray = new Recipe[n1];
		Recipe[] rightArray = new Recipe[n2];

		// Copy data to temp array
		for (int i = 0; i < n1; ++i)
			leftArray[i] = array.get(l + i);
		for (int j = 0; j < n2; ++j)
			rightArray[j] = array.get(m + 1 + j);

		// Merge the temp arrays

		// Initial indexes of first and second subarrays
		int i = 0;
		int j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (isAsc && leftArray[i].getTime() <= rightArray[j].getTime() // sort by time asc
					|| !isAsc && leftArray[i].getTime() >= rightArray[j].getTime()) { // sort by time desc
				array.set(k, leftArray[i]);
				i++;
			} else {
				array.set(k, rightArray[j]);
				j++;
			}
			k++;
		}

		// Copy remaining elements of L[] if any
		while (i < n1) {
			array.set(k, leftArray[i]);
			i++;
			k++;
		}

		// Copy remaining elements of R[] if any
		while (j < n2) {
			array.set(k, rightArray[j]);
			j++;
			k++;
		}
	}

	public static void sort(boolean isAsc, ArrayList<Recipe> array, int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = l + (r - l) / 2;

			// Sort first and seconds halves
			sort(isAsc, array, l, m);
			sort(isAsc, array, m + 1, r);

			// Merge the sorted halves
			merge(isAsc, array, l, m, r);
		}
	}
}
