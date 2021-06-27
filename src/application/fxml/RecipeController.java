package application.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.category.Category;
import application.recipe.Recipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RecipeController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Pane recipePane;

	@FXML
	private Label recipeLabelName;

	@FXML
	private Label recipeLabelTime;

	@FXML
	private ImageView recipeImageView;

	@FXML
	private HBox recipeCategoryList;

	private Stage primaryStage;
	private Recipe recipe;

	@FXML
	void initialize() {
		clipImage();

		recipeLabelName.setText(recipe.getName());
		recipeLabelTime.setText(String.valueOf(recipe.getTime()) + "min");

		Image recipeImage = new Image("application/fxml/images/recipes/" + recipe.getImageUrl());
		recipeImageView.setImage(recipeImage);

		// set background color
		recipePane.getStylesheets().add(recipe.getStylesheet());

		// add categories
		for (Category category : recipe.getCategoryList()) {
			Image categoryImage = new Image(category.getCategoryImageUrl());
			ImageView imageView = new ImageView();
			imageView.setImage(categoryImage);
			imageView.setFitWidth(47);
			imageView.setFitHeight(47);
			imageView.setPreserveRatio(true);
			imageView.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, new Color(0, 0, 0, 0.25), 10, 0, 0, 0));

			// Tooltip workaround
			Label tooltipLabel = new Label();
			tooltipLabel.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
			tooltipLabel.setGraphic(imageView);
			tooltipLabel.setTooltip(new Tooltip(category.getCategoryName()));
			recipeCategoryList.getChildren().add(tooltipLabel);
		}
	}

	public RecipeController(Stage primaryStage, Recipe recipe) {
		this.primaryStage = primaryStage;
		this.recipe = recipe;
	}

	@FXML
	void clickRecipe(MouseEvent event) {
		// change scene to recipeInfoView
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("recipeInfoView.fxml"));
			RecipeInfoController recipeInfoController = new RecipeInfoController(recipe);
			loader.setController(recipeInfoController);
			Pane pane = loader.load();
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void clipImage() {
		// create clip rectangle
		Rectangle clip = new Rectangle(recipeImageView.getFitWidth(), recipeImageView.getFitHeight());
		clip.setArcWidth(30);
		clip.setArcHeight(30);
		// clip image to rectangle
		recipeImageView.setClip(clip);
	}
}
