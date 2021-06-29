package application.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.Main.Sort;
import application.recipe.Recipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RecipeListController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private VBox recipeListView;

	@FXML
	private Pane sortNameLabel;

	@FXML
	private Pane sortTimeLabel;

	@FXML
	private Pane sortNameArrow;

	@FXML
	private Pane sortTimeArrow;

	private Stage primaryStage;

	private int sortMethod = 1; // 1 = Name, 2 = Time
	private boolean isNameAsc = true;
	private boolean isTimeAsc = true;

	private static final String CSS_SORT_SELECTED = "sortSelected";
	private static final String CSS_SORT_ASC = "asc";
	private static final String CSS_SORT_DESC = "desc";

	@FXML
	void initialize() {
		updateSortButtons(sortMethod, isNameAsc);
	}

	public RecipeListController(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	private void addRecipes(ArrayList<Recipe> recipeList) {
		HBox hbox = null;
		for (int i = 0; i < recipeList.size(); i++) {
			if (i % 2 == 0) {
				// create hbox
				hbox = new HBox();

				hbox.setSpacing(20);
				hbox.setPrefWidth(1246);

				recipeListView.getChildren().add(hbox);

				// add Rezept
				addRecipePane(hbox, recipeList.get(i));
			} else {
				// add Rezept
				addRecipePane(hbox, recipeList.get(i));
			}
		}
	}

	private void addRecipePane(HBox hbox, Recipe recipe) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("views/recipePanelView.fxml"));
			RecipePanelController recipePanelController = new RecipePanelController(primaryStage, recipe);
			loader.setController(recipePanelController);
			Pane recipePane = loader.load();

			hbox.getChildren().add(recipePane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void updateRecipePanes(Sort sort, boolean isAsc) {
		ArrayList<Recipe> recipeList = Main.getRecipeList(sort, isAsc);
		recipeListView.getChildren().clear(); // Remove all children
		addRecipes(recipeList);
	}

	private void updateSortButtons(int method, boolean isAsc) {
		sortMethod = method;
		switch (method) {
			case 1:
				removeSortClasses(method);
				sortNameLabel.getStyleClass().add(CSS_SORT_SELECTED);

				isNameAsc = isAsc;

				if (isAsc) {
					sortNameArrow.getStyleClass().add(CSS_SORT_ASC);
					updateRecipePanes(Sort.NAME, true);
				} else {
					sortNameArrow.getStyleClass().add(CSS_SORT_DESC);
					updateRecipePanes(Sort.NAME, false);
				}

				break;
			case 2:
				removeSortClasses(method);
				sortTimeLabel.getStyleClass().add(CSS_SORT_SELECTED);

				isTimeAsc = isAsc;

				if (isAsc) {
					sortTimeArrow.getStyleClass().add(CSS_SORT_ASC);
					updateRecipePanes(Sort.TIME, true);
				} else {
					sortTimeArrow.getStyleClass().add(CSS_SORT_DESC);
					updateRecipePanes(Sort.TIME, false);
				}

				break;
			default:
				return;
		}
	}

	private void removeSortClasses(int method) {
		sortNameLabel.getStyleClass().remove(CSS_SORT_SELECTED);
		sortTimeLabel.getStyleClass().remove(CSS_SORT_SELECTED);
		switch (method) {
			case 1:
				sortNameArrow.getStyleClass().remove(CSS_SORT_ASC);
				sortNameArrow.getStyleClass().remove(CSS_SORT_DESC);
				break;
			case 2:
				sortTimeArrow.getStyleClass().remove(CSS_SORT_ASC);
				sortTimeArrow.getStyleClass().remove(CSS_SORT_DESC);
				break;
			default:
				return;
		}
	}

	@FXML
	void clickSortNameLabel(MouseEvent event) {
		updateSortButtons(1, isNameAsc);
	}

	@FXML
	void clickSortTimeLabel(MouseEvent event) {
		updateSortButtons(2, isTimeAsc);
	}

	@FXML
	void clickSortNameArrow(MouseEvent event) {
		updateSortButtons(1, !isNameAsc);
	}

	@FXML
	void clickSortTimeArrow(MouseEvent event) {
		updateSortButtons(2, !isTimeAsc);
	}
}