package application;

import java.util.ArrayList;
import java.util.Collections;

public class Quicksort {
	// https://www.geeksforgeeks.org/java-program-for-quicksort/
	private static int partition(int sortMode, ArrayList<Recipe> array, int low, int high) {
		Recipe pivot = array.get(high);
		int i = low-1;
		for(int j=low; j < high; j++) {
			// sort mode ascending name
			if(sortMode == 1 && array.get(j).getName().compareToIgnoreCase(pivot.getName()) <= 0) {
				i++;
				Collections.swap(array, i, j); // swap array[i] and array[j]
			}
			// sort mode descending name
			else if(sortMode == 2 && array.get(j).getName().compareToIgnoreCase(pivot.getName()) >= 0) {
				i++;
				Collections.swap(array, i, j); // swap array[i] and array[j]
			}
			// sort mode ascending time
			else if(sortMode == 3 && array.get(j).getTime() <= pivot.getTime()) {
				i++;
				Collections.swap(array, i, j); // swap array[i] and array[j]
			}
			// sort mode descending time
			else if(sortMode == 4 && array.get(j).getTime() >= pivot.getTime()) {
				i++;
				Collections.swap(array, i, j); // swap array[i] and array[j]
			}
		}

		// swap array[i+1] and array[high]
		Collections.swap(array, i+1, high);

		return i+1;
	}

	/*
	sortMode:
		0 = disabled
		1 = ascending Name
		2 = descending Name
		3 = ascending Time
		4 = descending Time
	*/
	public static void sort(int sortMode, ArrayList<Recipe> array, int low, int high) {
		if(low < high) {
			// pi is partitioning index, arr[pi] is now at right place
			int pi = partition(sortMode, array, low, high);

			// Recursively sort elements before and after partition
			sort(sortMode, array, low, pi-1);
			sort(sortMode, array, pi+1, high);
		}
	}
}
