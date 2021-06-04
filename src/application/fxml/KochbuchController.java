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

public class KochbuchController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

	@FXML
	private VBox rezeptListView;

    @FXML
    void initialize() {
		Main.connect();
		ArrayList<Rezept> rezeptList = Main.getRezeptList(1);

		addRezepte(rezeptList);
    }

	private void addRezepte(ArrayList<Rezept> rezeptList) {
		HBox hbox = null;
		for (int i = 0; i < rezeptList.size(); i++) {
			if(i % 2 == 0) {
				// create hbox
				hbox = new HBox();

				hbox.setSpacing(20);
				hbox.setPrefWidth(1246);

				rezeptListView.getChildren().add(hbox);

				// add Rezept
				addRezeptPane(hbox, rezeptList.get(i));
			} else {
				if( hbox != null) {
					// add Rezept
					addRezeptPane(hbox, rezeptList.get(i));
				}
			}
		}
	}

	private void addRezeptPane(HBox hbox, Rezept rezept) {
		try {
			Pane rezeptPane = FXMLLoader.load(getClass().getResource("rezept.fxml"));

			// set pane id
			rezeptPane.setId(String.valueOf(rezept.getId()));

			Label rezeptLabelName = (Label) rezeptPane.lookup("#rezeptLabelName");
			rezeptLabelName.setText(rezept.getName());

			hbox.getChildren().add(rezeptPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}