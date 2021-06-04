package application.fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class RecipeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label recipeLabelName;

    @FXML
    void initialize() {

    }

    @FXML
    void recipeClicked(MouseEvent event) {
		Pane recipePane = (Pane) event.getSource();
		int recipeId = Integer.parseInt(recipePane.getId());

		System.out.println("Click:" + recipeId);
    }
}
