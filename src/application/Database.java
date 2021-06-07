package application;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

public class Database {

	Connection connection;
	Statement stmt;

	public Database(String url, String user, String password) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			stmt = connection.createStatement();
			System.out.println("Connected");
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
		}
	}

	public ArrayList<Recipe> readRecipes() {
		ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

		try {
			ResultSet resultRecipes = stmt.executeQuery("SELECT * FROM rezeptliste");
			while(resultRecipes.next()) {
				ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

				// Get Attributes
				int id = resultRecipes.getInt("IdRezept");
				String name = resultRecipes.getString("Name");
				String desc = resultRecipes.getString("Beschreibung");
				int time = resultRecipes.getInt("Zeit");

				// Get Zutaten List
				Statement stmtInner = connection.createStatement();

				ResultSet resultIngredients = stmtInner.executeQuery("SELECT Zutat, Menge FROM zutaten LEFT JOIN rezeptliste r on r.IdRezept = zutaten.fkRezept WHERE fkRezept = " + id + ";");
				while(resultIngredients.next()) {
					String ingredient = resultIngredients.getString("Zutat");
					String amount = resultIngredients.getString("Menge");

					// Add Zutat to list
					ingredientList.add(new Ingredient(
						ingredient, 
						amount
					));
				}

				// Add Rezept to list
				recipeList.add(new Recipe(
					id,
					name,
					desc,
					time,
					ingredientList
				));
			}

			return recipeList;
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
			return null;
		}
	}

	public void addRecipe(Recipe recipe) {
		try {
			// Add Recipe
			stmt.execute("INSERT INTO rezeptliste (Name, Zeit, Favorit, Beschreibung) VALUES ('" + recipe.getName() + "', " + recipe.getTime() + ", '" + 0 + "', '" + recipe.getDesc() + "');");
			ResultSet result = stmt.executeQuery("select LAST_INSERT_ID() AS IdRezept");
			result.next();
			int id = result.getInt("IdRezept");
			
			// Add Ingredient
			for (Ingredient ingredient : recipe.getIngredientList()) {
				stmt.execute("INSERT INTO zutaten (Zutat, Menge, fkRezept) VALUES ('" + ingredient.getIngredient() + "', '" + ingredient.getAmount() + "', " + id + ")");
			}
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
		}
	}

	public Recipe getRecipe(int id) {
		try {
			ResultSet resultRecipe = stmt.executeQuery("SELECT * FROM rezeptliste WHERE IdRezept = " + id);
			resultRecipe.next();

			// Attributes
			ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
			String name = resultRecipe.getString("Name");
			String desc = resultRecipe.getString("Beschreibung");
			int time = resultRecipe.getInt("Zeit");

			// Get Zutaten List
			Statement stmtInner = connection.createStatement();

			ResultSet resultIngredients = stmtInner.executeQuery("SELECT Zutat, Menge FROM zutaten LEFT JOIN rezeptliste r on r.IdRezept = zutaten.fkRezept WHERE fkRezept = " + id + ";");
			while(resultIngredients.next()) {
				String ingredient = resultIngredients.getString("Zutat");
				String amount = resultIngredients.getString("Menge");

				// Add Zutat to list
				ingredientList.add(new Ingredient(
					ingredient, 
					amount
				));
			}

			return new Recipe(
				id,
				name,
				desc,
				time,
				ingredientList
			);
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
			return null;
		}
	}

	public void removeRecipe(int id) {
		try {
			// Delete Ingredients
			stmt.execute("DELETE FROM zutaten WHERE fkRezept = " + id);

			// Delete Recipe
			stmt.execute("DELETE FROM rezeptliste WHERE IdRezept = " + id);
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
		}
	}
}
