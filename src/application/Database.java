package application;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

import application.recipe.*;

public class Database {

	Connection connection;
	Statement stmt;
	Statement stmtInner;

	public Database(String url, String user, String password) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			stmt = connection.createStatement();
			stmtInner = connection.createStatement();

			System.out.println("Connected");
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
		}
	}

	private ArrayList<Integer> getRecipeIdList() {
		ArrayList<Integer> recipeIdList = new ArrayList<>();

		try {
			ResultSet resultIds = stmt.executeQuery("SELECT IdRezept FROM rezeptliste;");
			while(resultIds.next()) {
				var idRecipe = resultIds.getInt("IdRezept");

				recipeIdList.add(idRecipe);
			}
			
			return recipeIdList;
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
			return new ArrayList<>();
		}
	}

	public void addRecipe(Recipe recipe) {
		try {
			// Add Recipe
			stmt.execute("INSERT INTO rezeptliste (Name, Zeit, Favorit, Beschreibung) VALUES ('" + recipe.getName() + "', " + recipe.getTime() + ", '" + 0 + "', '" + recipe.getDesc() + "');");
			ResultSet resultId = stmt.executeQuery("select LAST_INSERT_ID() AS IdRezept");
			resultId.next();
			var idRecipe = resultId.getInt("IdRezept");
			
			// Add Ingredient
			for (Ingredient ingredient : recipe.getIngredientList()) {
				stmt.execute("INSERT INTO zutaten (Zutat, Menge, fkRezept) VALUES ('" + ingredient.getIngredientName() + "', '" + ingredient.getAmount() + "', " + idRecipe + ")");
			}

			// Add Category
			for (Category category : recipe.getCategoryList()) {
				stmt.execute("INSERT INTO kategorien (Kategorie, fkRezept) VALUES ('" + category.getCategoryName() + "', " + idRecipe + ")");
			}
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
		}
	}

	public Recipe getRecipe(int idRecipe) {
		try {
			ResultSet resultRecipe = stmt.executeQuery("SELECT * FROM rezeptliste WHERE IdRezept = " + idRecipe);
			resultRecipe.next();

			// Attributes
			var name = resultRecipe.getString("Name");
			var desc = resultRecipe.getString("Beschreibung");
			var time = resultRecipe.getInt("Zeit");
			ArrayList<Ingredient> ingredientList =  getIngredientList(idRecipe);
			ArrayList<Category> categoryList = getCategoryList(idRecipe);
			
			if(hasCategory(categoryList, "Fleischgericht")) {
				return new RecipeMeat(
					idRecipe,
					name,
					desc,
					time,
					ingredientList,
					categoryList
				);
			} else {
				return new RecipeVegetarian(
					idRecipe,
					name,
					desc,
					time,
					ingredientList,
					categoryList
				);
			}

		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
			return null;
		}
	}

	private boolean hasCategory(ArrayList<Category> categoryList, String categoryName) {
		for (Category category : categoryList) {
			if(category.getCategoryName().equals(categoryName)) {
				return true;
			}
		}
		return false;
	}

	private ArrayList<Ingredient> getIngredientList(int idRecipe) {
		ArrayList<Ingredient> ingredientList = new ArrayList<>();

		try {
			ResultSet resultIngredients = stmtInner.executeQuery("SELECT Zutat, Menge FROM zutaten LEFT JOIN rezeptliste r on r.IdRezept = zutaten.fkRezept WHERE fkRezept = " + idRecipe + ";");
			while(resultIngredients.next()) {
				var ingredient = resultIngredients.getString("Zutat");
				var amount = resultIngredients.getString("Menge");
	
				// Add Ingredient to ingredientList
				ingredientList.add(new Ingredient(
					ingredient, 
					amount
				));
			}
	
			return ingredientList;
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
			return new ArrayList<>();
		}
	}

	private ArrayList<Category> getCategoryList(int idRecipe) {
		ArrayList<Category> categoryList = new ArrayList<>();

		try {
			ResultSet resultCategories = stmtInner.executeQuery("SELECT Kategorie FROM kategorien LEFT JOIN rezeptliste r on r.IdRezept = kategorien.fkRezept WHERE fkRezept = " + idRecipe + ";");
			while(resultCategories.next()) {
				var category = resultCategories.getString("Kategorie");

				// Add Category to categoryList
				categoryList.add(new Category(
					category
				));
			}
	
			return categoryList;
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
			return new ArrayList<>();
		}
	}

	public ArrayList<Recipe> getRecipeList() {
		ArrayList<Recipe> recipeList = new ArrayList<>();

		ArrayList<Integer> recipeIdList = getRecipeIdList();
		for (Integer idRecipe : recipeIdList) {
			var recipe = getRecipe(idRecipe);

			recipeList.add(recipe);
		}

		return recipeList;
	}

	public void removeRecipe(int idRecipe) {
		try {
			// Delete Ingredients
			stmt.execute("DELETE FROM zutaten WHERE fkRezept = " + idRecipe);

			// Delete Category
			stmt.execute("DELETE FROM kategorien WHERE fkRezept = " + idRecipe);

			// Delete Recipe
			stmt.execute("DELETE FROM rezeptliste WHERE IdRezept = " + idRecipe);
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
		}
	}
}
