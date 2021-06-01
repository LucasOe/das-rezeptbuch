package application;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

public class Database {

	Connection connection;
	Statement stmt;

	public Database(String url, String user, String password) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			stmt = connection.createStatement();
			System.out.println("Connected");
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
		}
	}

	public ArrayList<Rezept> readRezepte() {
		ArrayList<Rezept> rezeptList = new ArrayList<Rezept>();

		try {
			ResultSet resultRezept = stmt.executeQuery("SELECT * FROM rezeptliste");
			while(resultRezept.next()) {
				ArrayList<String[]> zutatenList = new ArrayList<String[]>();

				// Get Attributes
				int id = resultRezept.getInt("IdRezept");
				String name = resultRezept.getString("Name");
				String beschreibung = resultRezept.getString("Beschreibung");
				int zeit = resultRezept.getInt("Zeit");

				// Get Zutaten List
				Statement stmtInner = connection.createStatement();

				ResultSet resultZutat = stmtInner.executeQuery("SELECT Zutat, Menge FROM zutaten LEFT JOIN rezeptliste r on r.IdRezept = zutaten.fkRezept WHERE fkRezept = " + id + ";");
				while(resultZutat.next()) {
					String zutat = resultZutat.getString("Zutat");
					String menge = resultZutat.getString("Menge");

					// Add Zutat to list
					zutatenList.add(new String[]{zutat, menge});
				}

				// Add Rezept to list
				rezeptList.add(new Rezept(
					id,
					name,
					beschreibung,
					zeit,
					zutatenList
				));
			}

			return rezeptList;
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
			return null;
		}
	}

	public void addRezept(Rezept rezept) {
		try {
			// Rezept Hinzufügen
			stmt.execute("INSERT INTO rezeptliste (Name, Zeit, Favorit, Beschreibung) VALUES ('" + rezept.getName() + "', " + rezept.getZeit() + ", '" + 0 + "', '" + rezept.getBeschreibung() + "');");
			ResultSet result = stmt.executeQuery("select LAST_INSERT_ID() AS IdRezept");
			result.next();
			int id = result.getInt("IdRezept");
			
			// Zutat Hinzufügen
			for (String[] zutat : rezept.getZutatenList()) {
				stmt.execute("INSERT INTO zutaten (Zutat, Menge, fkRezept) VALUES ('" + zutat[0] + "', '" + zutat[1] + "', " + id + ")");
			}
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
		}
	}

	public void removeRezept(int id) {
		try {
			// Zutaten Löschen
			stmt.execute("DELETE FROM zutaten WHERE fkRezept = " + id);

			// Rezept Löschen
			stmt.execute("DELETE FROM rezeptliste WHERE IdRezept = " + id);
		} catch(SQLException exception) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
		}
	}
}
