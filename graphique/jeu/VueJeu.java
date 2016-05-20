package graphique.jeu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

import graphique.MenuBar;
import graphique.Vue;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.BatailleNavale;
import modele.BatailleNavale.Etat;
import modele.epoque.Presentation;

public class VueJeu extends JFrame implements Vue{

	public static Image IMAGE_WATER;
	public static Image IMAGE_FOG;
	
	public VueJeu() {
		super("CAD - Bataille Navale");

		this.setJMenuBar(new MenuBar());
		try {
			IMAGE_WATER = ImageIO.read(new File(Presentation.PATH_TO_IMG+"water.png"));
			IMAGE_FOG = ImageIO.read(new File(Presentation.PATH_TO_IMG+"fog.png"));
		} catch (IOException e) {
		}
		
		
		BatailleNavale.getInstance().addObserver(this);
		this.setPreferredSize(new Dimension(300, 630));
		VueJeuCacher vueJoueur = new VueJeuCacher();
		VueJeuVisible vueOrdinateur = new VueJeuVisible();
		VueInfos vueInfos = new VueInfos();
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		GridBagConstraints gbc = new GridBagConstraints();
		 
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		 
		gbc.fill = GridBagConstraints.VERTICAL;
		 
		gbc.insets = new Insets(30, 30, 30, 30);
		panel.add(vueJoueur, gbc);
		panel.add(vueInfos, gbc);
		panel.add(vueOrdinateur, gbc);
		add(panel);
		
	    pack() ;
        setVisible(false);
	}
	@Override
	public void update(Observable o, Object arg) {
		this.setVisible(BatailleNavale.getInstance().getEtat()==Etat.JEU);
	}

}
