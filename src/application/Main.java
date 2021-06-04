package application;
	
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private static Database db;
	private static ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
	
	@Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/recipeListView.fxml"));
		Scene scene = new Scene(root, 1920, 1080);
        primaryStage.setScene(scene);
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

	}

	public static void removeRecipe(int id) {

	}

	public static void printList() {
		recipeList = db.readRecipes();
		debugPrintList(recipeList);
	}

	/*
		sortMode:
			0 = disabled
			1 = ascending
			2 = descending
	*/
	public static ArrayList<Recipe> getRecipeList(int sortMode) {
		recipeList = db.readRecipes();
		if(sortMode == 0) return recipeList;

		Quicksort.sort(sortMode, recipeList, 0, recipeList.size()-1);
		return recipeList;
	}

	private static void debugPrintList(ArrayList<Recipe> recipeList) {
		System.out.println("Rezept Liste:");
		for (Recipe recipe : recipeList) {
			System.out.println(recipe.getName() + " Zutaten:");
			for (String[] ingredient : recipe.getIngredientList()) {
				System.out.println("\t" + ingredient[0] + ", " + ingredient[1]);
			}
		}
	}
}
