package application;

import java.util.ArrayList;

import application.recipe.Recipe;

public class Search {

	private Search() {
		throw new IllegalStateException("Utility class");
	}

	public static ArrayList<Recipe> searchRecipe(ArrayList<Recipe> array, String searchText) {
		ArrayList<Recipe> output = new ArrayList<>();
		for (Recipe recipe : array) {
			if (recipe.getName().toLowerCase().contains(searchText.toLowerCase())) {
				output.add(recipe);
			}
		}
		return output;
	}
}
