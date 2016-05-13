package graphique.placement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import graphique.Vue;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.BatailleNavale;
import modele.BatailleNavale.Etat;
import modele.Bateau;
import modele.Portion;

public class VueJoueurPlacement extends JPanel implements Vue {
	//[hauteur][largeur] graphiquement 
	private JPanel[][] tabPanel;
	
	public VueJoueurPlacement() {
		BatailleNavale.getInstance().addObserver(this);
		tabPanel = new JPanel[15][15];
		this.setLayout(new GridLayout(15, 15));
		for (int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++){
				JPanel panel = new JPanel();
				panel.add(new JLabel());
				panel.setBorder(BorderFactory.createLineBorder(Color.black));
				panel.setBackground(Color.white);
				add(panel);
				tabPanel[i][j] = panel;
			}
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		if(BatailleNavale.getInstance().getEtat()==Etat.PLACEMENT){
			for (int i = 0; i < 15; i++) {
				for(int j = 0; j < 15; j++){
					tabPanel[j][i].setBackground(Color.white);
				}
			}
			ArrayList<Bateau> al = BatailleNavale.getInstance().getBateauJoueur();
			for (Bateau bateau : al) {
				for (Portion portion : bateau.getPortions()) {
					tabPanel[portion.getY()][portion.getX()].setBackground(Color.green);
				}
			}
			if(BatailleNavale.getInstance().getBateauAPlacer() != null){
				for (Portion portion : BatailleNavale.getInstance().getBateauAPlacer().getPortions()) {
//					System.out.println(portion.getX()+" "+portion.getY());
					tabPanel[portion.getY()][portion.getX()].setBackground(Color.red);
				}
			}
		}
	}

}
