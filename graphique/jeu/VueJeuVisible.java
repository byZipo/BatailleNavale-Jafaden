package graphique.jeu;

import graphique.Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.BatailleNavale;
import modele.BatailleNavale.Etat;
import modele.Bateau;
import modele.Portion;
import modele.epoque.Presentation;
import modele.epoque.Presentation.Type;

public class VueJeuVisible extends JPanel implements Vue {

	//[hauteur][largeur] graphiquement 
	private PanelPortionVisible[][] tabPanel;
	
	public VueJeuVisible() {
		BatailleNavale.getInstance().addObserver(this);
		this.setPreferredSize(new Dimension(300, 300));
		tabPanel = new PanelPortionVisible[BatailleNavale.TAILLE_PLATEAU][BatailleNavale.TAILLE_PLATEAU];
		this.setLayout(new GridLayout(BatailleNavale.TAILLE_PLATEAU, BatailleNavale.TAILLE_PLATEAU));
		for (int i = 0; i < BatailleNavale.TAILLE_PLATEAU; i++) {
			for(int j = 0; j < BatailleNavale.TAILLE_PLATEAU; j++){
				PanelPortionVisible panel = new PanelPortionVisible(j,i);
				panel.setBorder(BorderFactory.createLineBorder(Color.black));
				tabPanel[i][j] = panel;
				add(panel);
			}
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(BatailleNavale.getInstance().getEtat()==Etat.JEU){
			ArrayList<Bateau> al = BatailleNavale.getInstance().getJoueur().getBateaux();
			for (Bateau bateau : al) {
				for (Portion portion : bateau.getPortions()) {
					tabPanel[portion.getY()][portion.getX()].setType(Type.A_POSITIONNER);
					if(portion.isTouche()){
						tabPanel[portion.getY()][portion.getX()].setType(Type.TOUCHER);
					}else if(portion.isCoule()){
						tabPanel[portion.getY()][portion.getX()].setType(Type.COULER);
					}
					tabPanel[portion.getY()][portion.getX()].setBateau(bateau, portion.getId());
				}
			}
			for (int i = 0; i < BatailleNavale.TAILLE_PLATEAU; i++) {
				for(int j = 0; j < BatailleNavale.TAILLE_PLATEAU; j++){
					tabPanel[j][i].update();
				}
			}
		}
	}

}
