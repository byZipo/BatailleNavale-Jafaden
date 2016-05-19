package graphique.jeu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import graphique.Vue;
import graphique.placement.PanelPortion;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controlleur.jeu.EcouteurJouer;
import modele.BatailleNavale;
import modele.Bateau;
import modele.Joueur;
import modele.Portion;
import modele.BatailleNavale.Etat;
import modele.epoque.Presentation;
import modele.epoque.Presentation.Type;

public class VueJeuCacher extends JPanel implements Vue {
	//[hauteur][largeur] graphiquement 
	private PanelPortionCacher[][] tabPanel;
	
	public VueJeuCacher() {
		BatailleNavale.getInstance().addObserver(this);
		this.setPreferredSize(new Dimension(300, 300));
		tabPanel = new PanelPortionCacher[BatailleNavale.TAILLE_PLATEAU][BatailleNavale.TAILLE_PLATEAU];
		this.setLayout(new GridLayout(BatailleNavale.TAILLE_PLATEAU, BatailleNavale.TAILLE_PLATEAU));
		for (int i = 0; i < BatailleNavale.TAILLE_PLATEAU; i++) {
			for(int j = 0; j < BatailleNavale.TAILLE_PLATEAU; j++){
				PanelPortionCacher panel = new PanelPortionCacher(j,i);
				panel.setBorder(BorderFactory.createLineBorder(Color.black));
				panel.setBackground(Color.white);
				panel.addMouseListener(new EcouteurJouer(j, i));
//				JLabel label = new JLabel();
//				panel.add(label);
				add(panel);
				tabPanel[i][j] = panel;
			}
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(BatailleNavale.getInstance().getEtat()==Etat.JEU){
			ArrayList<Bateau> al = BatailleNavale.getInstance().getOrdinateur().getBateaux();
			for (Bateau bateau : al) {
				for (Portion portion : bateau.getPortions()) {
					
					Type t = Type.PLACER;
					if(portion.isTouche())
						t = Type.TOUCHER;
					else if(portion.isCoule())
						t = Type.COULER;
//					System.out.println(t);
					tabPanel[portion.getY()][portion.getX()].setType(t);
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
