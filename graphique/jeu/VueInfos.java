package graphique.jeu;

import java.awt.Dimension;
import java.util.Observable;

import graphique.Vue;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.BatailleNavale;

public class VueInfos extends JPanel implements Vue {

	private JLabel dernierCoupOrdi;
	public VueInfos() {
		BatailleNavale.getInstance().addObserver(this);
		this.setPreferredSize(new Dimension(300, 30));
		dernierCoupOrdi = new JLabel("A vous de jouer");
		add(dernierCoupOrdi);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(BatailleNavale.getInstance().getDernierCoupOrdi()!=null)
			dernierCoupOrdi.setText("L'ordinateur a tiré en : ("+BatailleNavale.getInstance().getDernierCoupOrdi().getPremier()+","+BatailleNavale.getInstance().getDernierCoupOrdi().getDeuxieme()+").");
	}
}
