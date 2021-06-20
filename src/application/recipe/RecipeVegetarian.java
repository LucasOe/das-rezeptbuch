package application.recipe;

import java.util.ArrayList;

import application.Ingredient;
import application.category.Category;

public class RecipeVegetarian extends Recipe {

	public RecipeVegetarian(
		int id,
		String name,
		String desc,
		int time,
		ArrayList<Ingredient> ingredientList,
		ArrayList<Category> categoryList) {
		super(id, name, desc, time, ingredientList, categoryList);
	}

	@Override
	public String getStylesheet() {
		return "application/fxml/stylesheetVegetarian.css";
	}
}
