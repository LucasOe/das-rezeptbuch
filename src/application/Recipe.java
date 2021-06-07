package application;

import java.util.ArrayList;

public class Recipe {

	public int id = 0;
	public String name;
	public String desc;
	public int time;
	public boolean isFavorite;
	public ArrayList<String[]> ingredientList;

	public Recipe(
		int id,
		String name,
		String desc,
		int time,
		ArrayList<String[]> ingredientList
	) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.time = time;
		this.ingredientList = ingredientList;
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

	public ArrayList<String[]> getIngredientList() {
		return this.ingredientList;
	}

	public void setIngredientList(ArrayList<String[]> ingredientList) {
		this.ingredientList = ingredientList;
	}
}