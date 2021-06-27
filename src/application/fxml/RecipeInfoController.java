package application.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Ingredient;
import application.recipe.Recipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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

	private Recipe recipe;

    @FXML
    void initialize() {
        recipeLabelName.setText(recipe.getName());

		String desc = recipe.getDesc().replace("\\n", "\n\n"); // replace line breaks
		recipeLabelDescription.setText(desc);

		// add ingredients
		for(Ingredient ingredient : recipe.getIngredientList()) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("views/ingredientPaneView.fxml"));
				//RecipePanelController recipeController = new RecipePanelController(ingredient);
				//loader.setController(recipeController);
				HBox ingredientPane = loader.load();

				System.out.println(ingredientPane.getWidth());
				System.out.println(ingredientPane.getMaxWidth());
				System.out.println(ingredientPane.getPrefWidth());

				ingredientListView.getChildren().add(ingredientPane);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }

	public RecipeInfoController(Recipe recipe) {
		this.recipe = recipe;
	}
	
}
