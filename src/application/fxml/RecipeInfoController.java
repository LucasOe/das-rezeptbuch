package application.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.recipe.Recipe;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

public class RecipeInfoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup menu;

    @FXML
    private Text text;

	private Recipe recipe;

    @FXML
    void initialize() {
        text.setText(recipe.getName());

		Main.debugPrintRecipe(recipe);
    }

	public RecipeInfoController(Recipe recipe) {
		this.recipe = recipe;
	}
	
}
