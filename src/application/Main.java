package application;

import java.util.ArrayList;

import application.category.Category;
import application.fxml.RecipeListController;
import application.recipe.Recipe;
import application.sort.Mergesort;
import application.sort.Quicksort;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	private static Database db;

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/views/recipeListView.fxml"));
		RecipeListController recipeListController = new RecipeListController(primaryStage);
		loader.setController(recipeListController);
		Parent root = loader.load();

		Scene scene = new Scene(root, 1920, 1080);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Das Rezeptbuch");
		primaryStage.getIcons().add(new Image("application/fxml/views/images/menu/Element 3@8x.png"));
		primaryStage.setResizable(true);
		primaryStage.show();
	}

	public static void main(String[] args) {
		connect("rezepte_test");
		launch(args); // create GUI
	}

	public static void connect(String dbName) {
		db = new Database(dbName, "root", "");
	}

	public static void addRecipe(Recipe recipe) {
		db.addRecipe(recipe);
	}

	public static void removeRecipe(int id) {
		db.removeRecipe(id);
	}

	public static Recipe getRecipe(int id) {
		return db.getRecipe(id);
	}

	public enum Sort {
		NAME, TIME
	}

	public static ArrayList<Recipe> getRecipeList(Sort sort, boolean isAsc) {
		ArrayList<Recipe> recipeList = db.getRecipeList();

		if (sort == Sort.NAME) {
			Quicksort.sort(isAsc, recipeList, 0, recipeList.size() - 1);
		}
		if (sort == Sort.TIME) {
			Mergesort.sort(isAsc, recipeList, 0, recipeList.size() - 1);
		}

		return recipeList;
	}

	public static void debugPrintList(ArrayList<Recipe> recipeList) {
		System.out.println("Rezept Liste:");
		for (Recipe recipe : recipeList) {
			debugPrintRecipe(recipe);
		}
	}

	public static void debugPrintRecipe(Recipe recipe) {
		System.out.println("Name: " + recipe.getName() + "\nBildUrl: " + recipe.getImageUrl() + "\nZutaten:");
		for (Ingredient ingredient : recipe.getIngredientList()) {
			System.out.println("\t" + ingredient.getIngredientName() + ", " + ingredient.getAmount());
		}
		System.out.println("Kategorien:");
		for (Category category : recipe.getCategoryList()) {
			System.out.println("\t" + category.getCategoryName());
		}
	}
}
