package application;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Gui {

	JFrame jframe;
	JPanel panel;

	public Gui(String title) {
		jframe = new JFrame(title);

		jframe.setLayout(new GridBagLayout());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setPreferredSize(new Dimension(1200, 600));
		jframe.setMinimumSize(new Dimension(1200, 600));
		jframe.pack();
		jframe.setLocationRelativeTo(null);


		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		setVisible();
	}

	public void setVisible() {
		jframe.setVisible(true);
	}

	public void clearList() {
		Component[] components = panel.getComponents();
		for (Component rezeptPanel : components) {
			panel.remove(rezeptPanel);
		}

		panel.revalidate();
		panel.repaint();
	}

	public void createList(ArrayList<Rezept> rezeptList) {
		for (Rezept rezept : rezeptList) {
			JPanel rezeptPanel = new JPanel();
			rezeptPanel.add(new JLabel("Name: " + rezept.getName()));
			rezeptPanel.add(new JLabel("Beschreibung: " + rezept.getBeschreibung()));
			rezeptPanel.add(new JLabel("Zeit: " + rezept.getZeit()));
			rezeptPanel.add(new JLabel("Zutaten: "));

			for (String[] zutat : rezept.getZutatenList()) {
				rezeptPanel.add(new JLabel(zutat[1] + " " + zutat[0]));
			}

			JButton removeRezept = new JButton("Rezept entfernen");
			removeRezept.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					removeRezept(rezept.getId());
				}
			});
			rezeptPanel.add(removeRezept);

			rezeptPanel.setBackground(Color.gray);
			panel.add(rezeptPanel);
		}

		// Add Rezept Hinzufügen Button
		JButton addRezept = new JButton("Rezept Hinzufügen");
		addRezept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addRezept();
			}
		});
		panel.add(addRezept);

		jframe.add(panel);
		setVisible();
	}

	private void addRezept() {
		ArrayList<String[]> zutatenList = new ArrayList<String[]>();
		zutatenList.add(new String[]{"Zutat 1", "Menge 1"});
		zutatenList.add(new String[]{"Zutat 2", "Menge 2"});
		zutatenList.add(new String[]{"Zutat 3", "Menge 3"});

		Rezept rezept = new Rezept(
			0, // unset id
			"Neues Rezept", 
			"Beschreibung", 
			16, 
			zutatenList
		);

		Main.addRezept(rezept);
	}

	private void removeRezept(int id) {
		Main.removeRezept(id);
	}
}

