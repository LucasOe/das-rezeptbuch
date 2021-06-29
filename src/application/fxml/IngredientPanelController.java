package application.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import application.Ingredient;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class IngredientPanelController {
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label ingredientLabelAmount;

	@FXML
	private Label ingredientLabelName;

	private Ingredient ingredient;

	@FXML
	void initialize() {
		setProperties();
	}

	public IngredientPanelController(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	private void setProperties() {
		ingredientLabelAmount.setText(ingredient.getAmount());
		ingredientLabelName.setText(ingredient.getIngredientName());
	}
}
