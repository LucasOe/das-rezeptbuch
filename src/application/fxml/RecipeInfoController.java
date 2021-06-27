package application.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Ingredient;
import application.recipe.Recipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RecipeInfoController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ToggleGroup menu;

	@FXML
	private Label recipeLabelName;

	@FXML
	private Label recipeLabelDescription;

	@FXML
	private ImageView recipeImageFavorite;

	@FXML
	private VBox ingredientListView;

	private Stage primaryStage;
	private Recipe recipe;

	@FXML
	void initialize() {
		setProperties();
	}

	public RecipeInfoController(Stage primaryStage, Recipe recipe) {
		this.primaryStage = primaryStage;
		this.recipe = recipe;
	}

	@FXML
	void clickReturnButton(MouseEvent event) {
		changeScene();
	}

	@FXML
	void clickSidebarList(MouseEvent event) {
		changeScene();
	}

	private void setProperties() {
		recipeLabelName.setText(recipe.getName());

		String desc = recipe.getDesc().replace("\\n", "\n\n"); // replace line breaks
		recipeLabelDescription.setText(desc);

		// add ingredients
		for (Ingredient ingredient : recipe.getIngredientList()) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("views/ingredientPaneView.fxml"));
				IngredientPanelController ingredientPanelController = new IngredientPanelController(ingredient);
				loader.setController(ingredientPanelController);
				HBox ingredientPane = loader.load();

				ingredientListView.getChildren().add(ingredientPane);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void changeScene() {
		// change scene to recipeListView
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("views/recipeListView.fxml"));
			RecipeListController recipeListController = new RecipeListController(primaryStage);
			loader.setController(recipeListController);
			Pane pane = loader.load();
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
