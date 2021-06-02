package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private static Database db;
	private static ArrayList<Rezept> rezeptList = new ArrayList<Rezept>();
	
	@Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/kochbuch.fxml"));
		Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // create GUI
    }

	public static void connect() {
		db = new Database(
			"jdbc:mysql://localhost:3306/rezepte_test",
			"root",
			""
		);
	}

	public static void addRezept(Rezept rezept) {

	}

	public static void removeRezept(int id) {

	}

	public static void printList() {
		rezeptList = db.readRezepte();
		debugPrintList(rezeptList);
	}

	public static ArrayList<Rezept> getRezeptList() {
		return db.readRezepte();
	}

	private static void debugPrintList(ArrayList<Rezept> rezeptList) {
		System.out.println("rezeptList:");
		for (Rezept rezept : rezeptList) {
			System.out.println(rezept.getName() + " Zutaten:");
			for (String[] zutat : rezept.getZutatenList()) {
				System.out.println("\t" + zutat[0] + ", " + zutat[1]);
			}
		}
	}
}
