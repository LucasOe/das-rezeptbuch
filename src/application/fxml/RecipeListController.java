package application.fxml;

import application.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class RecipeListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

	@FXML
	private VBox recipeListView;

    @FXML
    void initialize() {
		Main.connect();
		ArrayList<Recipe> recipeList = Main.getRecipeList(1);

		addRecipes(recipeList);
    }

	private void addRecipes(ArrayList<Recipe> recipeList) {
		HBox hbox = null;
		for (int i = 0; i < recipeList.size(); i++) {
			if(i % 2 == 0) {
				// create hbox
				hbox = new HBox();

				hbox.setSpacing(20);
				hbox.setPrefWidth(1246);

				recipeListView.getChildren().add(hbox);

				// add Rezept
				addRecipePane(hbox, recipeList.get(i));
			} else {
				if( hbox != null) {
					// add Rezept
					addRecipePane(hbox, recipeList.get(i));
				}
			}
		}
	}

	private void addRecipePane(HBox hbox, Recipe recipe) {
		try {
			Pane recipePane = FXMLLoader.load(getClass().getResource("recipeView.fxml"));

			// set pane id
			recipePane.setId(String.valueOf(recipe.getId()));

			Label recipeLabelName = (Label) recipePane.lookup("#recipeLabelName");
			recipeLabelName.setText(recipe.getName());

			hbox.getChildren().add(recipePane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}