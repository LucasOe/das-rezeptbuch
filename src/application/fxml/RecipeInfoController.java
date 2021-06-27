package application.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.recipe.Recipe;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

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

	private Recipe recipe;

    @FXML
    void initialize() {
        recipeLabelName.setText(recipe.getName());
		// replace line breaks
		String desc = recipe.getDesc().replace("\\n", "\n\n");
		recipeLabelDescription.setText(desc);

		Main.debugPrintRecipe(recipe);
    }

	public RecipeInfoController(Recipe recipe) {
		this.recipe = recipe;
	}
	
}
