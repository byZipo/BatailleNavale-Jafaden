package graphique;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controlleur.EcouteurCharger;
import controlleur.EcouteurSauvegarder;

public class MenuBar extends JMenuBar {
	private JMenu menuFichier;
	private JMenuItem itemSave;
	private JMenuItem itemLoad;
	
	public MenuBar(){
		menuFichier = new JMenu("Fichier");
		itemLoad = new JMenuItem("Charger");
		itemLoad.addActionListener(new EcouteurCharger());
		itemSave = new JMenuItem("Sauvegarder");
		itemSave.addActionListener(new EcouteurSauvegarder());
		menuFichier.add(itemLoad);
		menuFichier.add(itemSave);
		this.add(menuFichier);
	}
}
