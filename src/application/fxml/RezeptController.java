package application.fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class RezeptController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label rezeptLabelName;

    @FXML
    void initialize() {

    }

    @FXML
    void rezeptClicked(MouseEvent event) {
		Pane rezeptPane = (Pane) event.getSource();
		int rezeptId = Integer.parseInt(rezeptPane.getId());

		System.out.println("Click:" + rezeptId);
    }
}
