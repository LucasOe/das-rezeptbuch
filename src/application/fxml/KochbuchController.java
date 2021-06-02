package application.fxml;

import application.*;

import java.net.URL;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class KochbuchController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

	@FXML
    private ListView rezeptTable;

    @FXML
    void initialize() {
		Main.connect();
		ArrayList<Rezept> rezeptList = Main.getRezeptList();

		ObservableList<String> observableList = FXCollections.observableArrayList();

		for (Rezept rezept : rezeptList) {
			observableList.add(rezept.getName());
		}

		rezeptTable.setItems(observableList);
    }
}