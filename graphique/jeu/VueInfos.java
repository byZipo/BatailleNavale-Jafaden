package graphique.jeu;

import java.awt.Dimension;
import java.util.Observable;

import graphique.Vue;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.BatailleNavale;

public class VueInfos extends JPanel implements Vue {

	public VueInfos() {
		BatailleNavale.getInstance().addObserver(this);
		this.add(new JLabel("info"));
		this.setPreferredSize(new Dimension(300, 30));
		
	}
	
	@Override
	public void update(Observable o, Object arg) {

		// TODO Auto-generated method stub

	}

}
