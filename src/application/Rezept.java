package application;

import java.util.ArrayList;

public class Rezept {

	public int id = 0;
	public String name;
	public String beschreibung;
	public int zeit;
	public boolean isFavorit;
	public ArrayList<String[]> zutatenList;

	public Rezept(
		int id,
		String name,
		String beschreibung,
		int zeit,
		ArrayList<String[]> zutatenList
	) {
		this.id = id;
		this.name = name;
		this.beschreibung = beschreibung;
		this.zeit = zeit;
		this.zutatenList = zutatenList;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return this.beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public int getZeit() {
		return this.zeit;
	}

	public void setZeit(int zeit) {
		this.zeit = zeit;
	}

	public boolean isIsFavorit() {
		return this.isFavorit;
	}

	public void setIsFavorit(boolean isFavorit) {
		this.isFavorit = isFavorit;
	}

	public ArrayList<String[]> getZutatenList() {
		return this.zutatenList;
	}

	public void setZutatenList(ArrayList<String[]> zutatenList) {
		this.zutatenList = zutatenList;
	}

}
