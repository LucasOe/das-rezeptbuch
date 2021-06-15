package application;

import java.util.ArrayList;

public class Recipe {

	public int id = 0;
	public String name;
	public String desc;
	public int time;
	public boolean isFavorite;
	public ArrayList<Ingredient> ingredientList;
	public ArrayList<Category> categoryList;

	public Recipe(
		int id,
		String name,
		String desc,
		int time,
		ArrayList<Ingredient> ingredientList,
		ArrayList<Category> categoryList
	) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.time = time;
		this.ingredientList = ingredientList;
		this.categoryList = categoryList;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getTime() {
		return this.time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public boolean isIsFavorite() {
		return this.isFavorite;
	}

	public void setIsFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

	public ArrayList<Ingredient> getIngredientList() {
		return this.ingredientList;
	}

	public void setIngredientList(ArrayList<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public ArrayList<Category> getCategoryList() {
		return this.categoryList;
	}

	public void setCategoryList(ArrayList<Category> categoryList) {
		this.categoryList = categoryList;
	}
}
