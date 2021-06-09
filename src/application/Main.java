package application;
	
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	private static Database db;
	private static ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
	
	@Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/recipeListView.fxml"));
		Scene scene = new Scene(root, 1920, 1080);
        primaryStage.setScene(scene);
		primaryStage.setTitle("Das Rezeptbuch");
		primaryStage.getIcons().add(new Image("application/fxml/images/menu/Element 3@8x.png"));
		primaryStage.setResizable(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // create GUI
    }

	public static void connect() {
		db = new Database(
			"jdbc:mysql://localhost:3306/rezepte_test",
			"root",
			""
		);
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

	/*
		sortMode:
			0 = disabled
			1 = ascending Name
			2 = descending Name
			3 = ascending Time
			4 = descending Time
	*/
	public static ArrayList<Recipe> getRecipeList(int sortMode) {
		recipeList = db.readRecipes();
		if(sortMode == 0) return recipeList;

		Quicksort.sort(sortMode, recipeList, 0, recipeList.size()-1);
		return recipeList;
	}

	public static void debugPrintList(ArrayList<Recipe> recipeList) {
		System.out.println("Rezept Liste:");
		for (Recipe recipe : recipeList) {
			System.out.println(recipe.getName() + " Zutaten:");
			for (Ingredient ingredient : recipe.getIngredientList()) {
				System.out.println("\t" + ingredient.getIngredient() + ", " + ingredient.getAmount());
			}
		}
	}

	public static void debugPrintRecipe(Recipe recipe) {
		System.out.println(recipe.getName() + " Zutaten:");
		for (Ingredient ingredient : recipe.getIngredientList()) {
			System.out.println("\t" + ingredient.getIngredient() + ", " + ingredient.getAmount());
		}
	}
}
