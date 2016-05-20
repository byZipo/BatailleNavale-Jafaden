package graphique;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import modele.BatailleNavale;
import modele.BatailleNavale.Etat;
import modele.algo.Algo;
import controlleur.EcouteurCharger;
import controlleur.EcouteurMenuAlgo;
import controlleur.EcouteurSauvegarder;
import controlleur.menu.EcouteurChangementAlgo;

public class MenuBar extends JMenuBar implements Observer {
	private JMenu menuFichier;
	private JMenuItem itemSave;
	private JMenuItem itemLoad;
	private JMenu menuAlgo;
	
	public MenuBar(){
		BatailleNavale.getInstance().addObserver(this);
		menuFichier = new JMenu("Fichier");
		itemLoad = new JMenuItem("Charger");
		itemLoad.addActionListener(new EcouteurCharger());
		itemSave = new JMenuItem("Sauvegarder");
		itemSave.addActionListener(new EcouteurSauvegarder());
		menuFichier.add(itemLoad);
		menuFichier.add(itemSave);
		

		menuAlgo = new JMenu("Algorithme");
		menuAlgo.setEnabled(false);
		for(int i = 0; i < Algo.getAlgos().length; i++){
			JMenuItem item = new JMenuItem(Algo.getAlgos()[i]);
			item.addActionListener(new EcouteurMenuAlgo(i));
			menuAlgo.add(item);
		}
		this.add(menuFichier);
		this.add(menuAlgo);
	}

	@Override
	public void update(Observable o, Object arg) {
		menuAlgo.setEnabled(BatailleNavale.getInstance().getEtat() == Etat.JEU);
	}
}
