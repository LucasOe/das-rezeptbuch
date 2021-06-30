package application.sort;

import java.util.ArrayList;
import java.util.Collections;

import application.recipe.Recipe;

public class Quicksort {

	private Quicksort() {
		throw new IllegalStateException("Utility class");
	}

	private static int partition(boolean isAsc, ArrayList<Recipe> array, int low, int high) {
		Recipe pivot = array.get(high);
		int i = low - 1;
		for (int j = low; j < high; j++) {
			// sort mode ascending name
			if (isAsc && array.get(j).getName().compareToIgnoreCase(pivot.getName()) <= 0 || // sort by name asc
					!isAsc && array.get(j).getName().compareToIgnoreCase(pivot.getName()) >= 0 // sort by name desc
			) {
				i++;
				Collections.swap(array, i, j); // swap array[i] and array[j]
			}
		}

		// swap array[i+1] and array[high]
		Collections.swap(array, i + 1, high);

		return i + 1;
	}

	/*
	sortMode:
		1 = ascending Name
		2 = descending Name
	*/
	public static void sort(boolean isAsc, ArrayList<Recipe> array, int low, int high) {
		if (low < high) {
			// pi is partitioning index, arr[pi] is now at right place
			int pi = partition(isAsc, array, low, high);

			// Recursively sort elements before and after partition
			sort(isAsc, array, low, pi - 1);
			sort(isAsc, array, pi + 1, high);
		}
	}
}
