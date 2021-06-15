package application;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

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
		ArrayList<Integer> recipeIdList = new ArrayList<Integer>();

		try {
			ResultSet resultIds = stmt.executeQuery("SELECT IdRezept FROM rezeptliste;");
			while(resultIds.next()) {
				int idRecipe = resultIds.getInt("IdRezept");

				recipeIdList.add(idRecipe);
			}
			
			return recipeIdList;
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
			return null;
		}
	}

	public void addRecipe(Recipe recipe) {
		try {
			// Add Recipe
			stmt.execute("INSERT INTO rezeptliste (Name, Zeit, Favorit, Beschreibung) VALUES ('" + recipe.getName() + "', " + recipe.getTime() + ", '" + 0 + "', '" + recipe.getDesc() + "');");
			ResultSet resultId = stmt.executeQuery("select LAST_INSERT_ID() AS IdRezept");
			resultId.next();
			int idRecipe = resultId.getInt("IdRezept");
			
			// Add Ingredient
			for (Ingredient ingredient : recipe.getIngredientList()) {
				stmt.execute("INSERT INTO zutaten (Zutat, Menge, fkRezept) VALUES ('" + ingredient.getIngredient() + "', '" + ingredient.getAmount() + "', " + idRecipe + ")");
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
			String name = resultRecipe.getString("Name");
			String desc = resultRecipe.getString("Beschreibung");
			int time = resultRecipe.getInt("Zeit");
			
			// Get Zutaten List
			ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
			ingredientList = getIngredientList(idRecipe);
			
			// Get Category List
			ArrayList<Category> categoryList = new ArrayList<Category>();
			categoryList = getCategoryList(idRecipe);
			
			return new Recipe(
				idRecipe,
				name,
				desc,
				time,
				ingredientList,
				categoryList
			);
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
			return null;
		}
	}

	private ArrayList<Ingredient> getIngredientList(int idRecipe) {
		ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

		try {
			ResultSet resultIngredients = stmtInner.executeQuery("SELECT Zutat, Menge FROM zutaten LEFT JOIN rezeptliste r on r.IdRezept = zutaten.fkRezept WHERE fkRezept = " + idRecipe + ";");
			while(resultIngredients.next()) {
				String ingredient = resultIngredients.getString("Zutat");
				String amount = resultIngredients.getString("Menge");
	
				// Add Ingredient to ingredientList
				ingredientList.add(new Ingredient(
					ingredient, 
					amount
				));
			}
	
			return ingredientList;
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
			return null;
		}
	}

	private ArrayList<Category> getCategoryList(int idRecipe) {
		ArrayList<Category> categoryList = new ArrayList<Category>();

		try {
			ResultSet resultCategories = stmtInner.executeQuery("SELECT Kategorie FROM kategorien LEFT JOIN rezeptliste r on r.IdRezept = kategorien.fkRezept WHERE fkRezept = " + idRecipe + ";");
			while(resultCategories.next()) {
				String category = resultCategories.getString("Kategorie");

				// Add Category to categoryList
				categoryList.add(new Category(
					category
				));
			}
	
			return categoryList;
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
			return null;
		}
	}

	public ArrayList<Recipe> getRecipeList() {
		ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

		ArrayList<Integer> recipeIdList = getRecipeIdList();
		for (Integer idRecipe : recipeIdList) {
			Recipe recipe = getRecipe(idRecipe);

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
