package application.fxml;

import application.*;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class RecipeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label recipeLabelName;

	@FXML
	private ImageView recipeImageView;

    @FXML
    void initialize() {
		clipImage();
    }

    @FXML
    void recipeClicked(MouseEvent event) {
		Pane recipePane = (Pane) event.getSource();
		int recipeId = Integer.parseInt(recipePane.getId());

		Recipe recipe = Main.getRecipe(recipeId);
		Main.debugPrintRecipe(recipe);
    }

	private void clipImage() {
		// create clip rectangle
		Rectangle clip = new Rectangle(
			recipeImageView.getFitWidth(), recipeImageView.getFitHeight()
		);
		clip.setArcWidth(30);
		clip.setArcHeight(30);
		// clip image to rectangle
		recipeImageView.setClip(clip);
	}
}
