package application;

import java.util.ArrayList;
import java.util.Collections;

public class Quicksort {
	private static int rezeptToInt(Rezept rezept) {
		return Character.getNumericValue(rezept.getName().toCharArray()[0]);
	}

	// https://www.geeksforgeeks.org/java-program-for-quicksort/
	private static int partition(int sortMode, ArrayList<Rezept> array, int low, int high) {
		int pivot = rezeptToInt(array.get(high));
		int i = low-1;
		for(int j=low; j < high; j++) {
			// sort mode ascending
			if(sortMode == 1 && rezeptToInt(array.get(j)) <= pivot) {
				i++;
				Collections.swap(array, i, j); // swap array[i] and array[j]
			}
			// sort mode descending
			if(sortMode == 2 && rezeptToInt(array.get(j)) >= pivot) {
				i++;
				Collections.swap(array, i, j); // swap array[i] and array[j]
			}
		}

		// swap array[i+1] and array[high]
		Collections.swap(array, i+1, high);

		return i+1;
	}

	public static void sort(int sortMode, ArrayList<Rezept> array, int low, int high) {
		if(low < high) {
			// pi is partitioning index, arr[pi] is now at right place
			int pi = partition(sortMode, array, low, high);

			// Recursively sort elements before and after partition
			sort(sortMode, array, low, pi-1);
			sort(sortMode, array, pi+1, high);
		}
	}
}
