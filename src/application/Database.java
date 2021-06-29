package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import application.category.Category;
import application.category.CategoryDessert;
import application.category.CategoryDrink;
import application.category.CategoryFish;
import application.category.CategoryMeat;
import application.category.CategorySoup;
import application.category.CategoryVegan;
import application.category.CategoryVegetarian;
import application.recipe.Recipe;
import application.recipe.RecipeMeat;
import application.recipe.RecipeVegetarian;

public class Database {

	Connection connection;
	Statement stmt;
	Statement stmtInner;

	private static final String DB_URL = "jdbc:mysql://localhost:3306/";

	public Database(String dbName, String user, String password, boolean forceOverwite) {
		if (forceOverwite)
			initializeDatabase(user, password);

		try {
			connection = DriverManager.getConnection(DB_URL + dbName, user, password);
			stmt = connection.createStatement();
			stmtInner = connection.createStatement();

			System.out.println("Connected");
		} catch (SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
		}
	}

	private void initializeDatabase(String user, String password) {
		try (Connection initConnection = DriverManager.getConnection(DB_URL, user, password);
				Statement initStmt = initConnection.createStatement();) {
			initStmt.execute("DROP SCHEMA IF EXISTS rezepte_test");
			initStmt.execute("CREATE SCHEMA IF NOT EXISTS rezepte_test");
			initStmt.execute("USE rezepte_test");
			ArrayList<String> lines = readFile("db/init.sql");
			for (String line : lines) {
				if (line.length() > 0) {
					initStmt.addBatch(line);
				}
			}
			initStmt.executeBatch();
		} catch (SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
		}
	}

	private ArrayList<String> readFile(String pathString) {
		ArrayList<String> lines = new ArrayList<>();
		Path path = Paths.get(pathString);
		try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}

			return lines;
		} catch (IOException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
			return new ArrayList<>();
		}
	}

	private ArrayList<Integer> getRecipeIdList() {
		ArrayList<Integer> recipeIdList = new ArrayList<>();

		try {
			ResultSet resultIds = stmt.executeQuery("SELECT IdRezept FROM rezeptliste;");
			while (resultIds.next()) {
				var idRecipe = resultIds.getInt("IdRezept");

				recipeIdList.add(idRecipe);
			}

			return recipeIdList;
		} catch (SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
			return new ArrayList<>();
		}
	}

	public void addRecipe(Recipe recipe) {
		try {
			// Add Recipe
			stmt.execute("INSERT INTO rezeptliste (Name, Zeit, Favorit, Beschreibung, BildUrl) VALUES ('"
					+ recipe.getName() + "', " + recipe.getTime() + ", '" + 0 + "', '" + recipe.getDesc() + "', "
					+ recipe.getImageUrl() + "');");
			ResultSet resultId = stmt.executeQuery("select LAST_INSERT_ID() AS IdRezept");
			resultId.next();
			var idRecipe = resultId.getInt("IdRezept");

			// Add Ingredient
			for (Ingredient ingredient : recipe.getIngredientList()) {
				stmt.execute("INSERT INTO zutaten (Zutat, Menge, fkRezept) VALUES ('" + ingredient.getIngredientName()
						+ "', '" + ingredient.getAmount() + "', " + idRecipe + ")");
			}

			// Add Category
			for (Category category : recipe.getCategoryList()) {
				stmt.execute("INSERT INTO kategorien (Kategorie, fkRezept) VALUES ('" + category.getCategoryName()
						+ "', " + idRecipe + ")");
			}
		} catch (SQLException exception) {
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
			var imageUrl = resultRecipe.getString("BildUrl");
			ArrayList<Ingredient> ingredientList = getIngredientList(idRecipe);
			ArrayList<Category> categoryList = getCategoryList(idRecipe);

			if (hasCategory(categoryList, "Fleischgericht")) {
				return new RecipeMeat(idRecipe, name, desc, time, ingredientList, categoryList, imageUrl);
			} else {
				return new RecipeVegetarian(idRecipe, name, desc, time, ingredientList, categoryList, imageUrl);
			}

		} catch (SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
			return null;
		}
	}

	private boolean hasCategory(ArrayList<Category> categoryList, String categoryName) {
		for (Category category : categoryList) {
			if (category.getCategoryName().equals(categoryName)) {
				return true;
			}
		}
		return false;
	}

	private ArrayList<Ingredient> getIngredientList(int idRecipe) {
		ArrayList<Ingredient> ingredientList = new ArrayList<>();

		try {
			ResultSet resultIngredients = stmtInner.executeQuery(
					"SELECT Zutat, Menge FROM zutaten LEFT JOIN rezeptliste r on r.IdRezept = zutaten.fkRezept WHERE fkRezept = "
							+ idRecipe + ";");
			while (resultIngredients.next()) {
				var ingredient = resultIngredients.getString("Zutat");
				var amount = resultIngredients.getString("Menge");

				// Add Ingredient to ingredientList
				ingredientList.add(new Ingredient(ingredient, amount));
			}

			return ingredientList;
		} catch (SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
			return new ArrayList<>();
		}
	}

	private ArrayList<Category> getCategoryList(int idRecipe) {
		ArrayList<Category> categoryList = new ArrayList<>();

		try {
			ResultSet resultCategories = stmtInner.executeQuery(
					"SELECT Kategorie FROM kategorien LEFT JOIN rezeptliste r on r.IdRezept = kategorien.fkRezept WHERE fkRezept = "
							+ idRecipe + ";");
			while (resultCategories.next()) {
				var category = resultCategories.getString("Kategorie");

				// Add Category to categoryList
				categoryList.add(getCategoryClass(category));
			}

			return categoryList;
		} catch (SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
			return new ArrayList<>();
		}
	}

	private Category getCategoryClass(String category) {
		switch (category) {
			case "Dessert":
				return new CategoryDessert(category);
			case "Getränk":
				return new CategoryDrink(category);
			case "Fischgericht":
				return new CategoryFish(category);
			case "Fleischgericht":
				return new CategoryMeat(category);
			case "Suppe":
				return new CategorySoup(category);
			case "Vegan":
				return new CategoryVegan(category);
			case "Vegetarisch":
				return new CategoryVegetarian(category);
			default:
				return null;
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
		} catch (SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
		}
	}
}
