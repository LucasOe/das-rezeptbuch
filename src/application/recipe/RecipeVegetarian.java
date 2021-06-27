package application.recipe;

import java.util.ArrayList;

import application.Ingredient;
import application.category.Category;

public class RecipeVegetarian extends Recipe {

	public RecipeVegetarian(int id, String name, String desc, int time, ArrayList<Ingredient> ingredientList,
			ArrayList<Category> categoryList, String imageUrl) {
		super(id, name, desc, time, ingredientList, categoryList, imageUrl);
	}

	@Override
	public String getStylesheet() {
		return "application/fxml/stylesheets/stylesheetVegetarian.css";
	}
}
