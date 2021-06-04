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
				ArrayList<String[]> ingredientList = new ArrayList<String[]>();

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
					ingredientList.add(new String[]{
						ingredient, amount
					});
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
			for (String[] ingredient : recipe.getIngredientList()) {
				stmt.execute("INSERT INTO zutaten (Zutat, Menge, fkRezept) VALUES ('" + ingredient[0] + "', '" + ingredient[1] + "', " + id + ")");
			}
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
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
