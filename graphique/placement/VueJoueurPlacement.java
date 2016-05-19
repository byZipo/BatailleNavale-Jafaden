package graphique.placement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import graphique.Vue;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.BatailleNavale;
import modele.BatailleNavale.Etat;
import modele.Bateau;
import modele.Portion;
import modele.epoque.Presentation;
import modele.epoque.Presentation.Type;

public class VueJoueurPlacement extends JPanel implements Vue {
	//[hauteur][largeur] graphiquement 
	private PanelPortion[][] tabPanel;
	
	public VueJoueurPlacement() {
		BatailleNavale.getInstance().addObserver(this);
		tabPanel = new PanelPortion[BatailleNavale.TAILLE_PLATEAU][BatailleNavale.TAILLE_PLATEAU];
		this.setLayout(new GridLayout(BatailleNavale.TAILLE_PLATEAU, BatailleNavale.TAILLE_PLATEAU));
		for (int i = 0; i < BatailleNavale.TAILLE_PLATEAU; i++) {
			for(int j = 0; j < BatailleNavale.TAILLE_PLATEAU; j++){
				PanelPortion panel = new PanelPortion();
				panel.setBorder(BorderFactory.createLineBorder(Color.black));
				panel.setBackground(Color.white);
//				JLabel label = new JLabel();
//				panel.add(label);
				add(panel);
				tabPanel[i][j] = panel;
			}
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(BatailleNavale.getInstance().getEtat()==Etat.PLACEMENT){
			for (int i = 0; i < BatailleNavale.TAILLE_PLATEAU; i++) {
				for(int j = 0; j < BatailleNavale.TAILLE_PLATEAU; j++){
					tabPanel[j][i].setNull();
					tabPanel[j][i].setBackground(Color.white);
				}
			}
			ArrayList<Bateau> al = BatailleNavale.getInstance().getBateauJoueur();
			for (Bateau bateau : al) {
				for (Portion portion : bateau.getPortions()) {
					tabPanel[portion.getY()][portion.getX()].setType(Type.PLACER);
					tabPanel[portion.getY()][portion.getX()].setBateau(bateau, portion.getId());
				}
			}
			if(BatailleNavale.getInstance().getBateauAPlacer() != null){
				Bateau bateau = BatailleNavale.getInstance().getBateauAPlacer();
				for (Portion portion : bateau.getPortions()) {
					tabPanel[portion.getY()][portion.getX()].setType(Type.A_POSITIONNER);
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
