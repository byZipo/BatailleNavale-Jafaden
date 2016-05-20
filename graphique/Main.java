package graphique;

import graphique.jeu.VueJeu;
import graphique.menu.VueMenu;
import graphique.placement.VuePlacement;

import java.util.Observable;

import javax.swing.JOptionPane;

import modele.BatailleNavale;

public class Main implements Vue{
	private VueMenu vueMenu;
	private VuePlacement vuePlacement;
	private VueJeu vueJeu;
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main(){
		vueMenu = new VueMenu();
		vuePlacement = new VuePlacement();
		vueJeu = new VueJeu();
		BatailleNavale.getInstance().addObserver(this);
//		BatailleNavale.getInstance().miseAJour();
	}

	@Override
	public void update(Observable o, Object arg) {
		switch(BatailleNavale.getInstance().getEtat()){
			case GAGNER :
				JOptionPane.showMessageDialog(vueJeu,
					    "Vous avez gagné.",
					    "Bataille Navale",
					    JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
				break;
			case PERDU :
				JOptionPane.showMessageDialog(vueJeu,
					    "Vous avez perdu.",
					    "Bataille Navale",
					    JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
				break;
		}
	}

}
