package application.recipe;

import java.util.ArrayList;

import application.Ingredient;
import application.category.Category;

public class RecipeMeat extends Recipe {

	public RecipeMeat(
		int id,
		String name,
		String desc,
		int time,
		ArrayList<Ingredient> ingredientList,
		ArrayList<Category> categoryList,
		String imageUrl
	) {
		super(id, name, desc, time, ingredientList, categoryList, imageUrl);
	}
	
	@Override
	public String getStylesheet() {
		return "application/fxml/stylesheetMeat.css";
	}
}
