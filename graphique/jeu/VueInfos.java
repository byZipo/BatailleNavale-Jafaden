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
		dernierCoupOrdi = new JLabel("Dernier Coup : ");
		add(dernierCoupOrdi);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(BatailleNavale.getInstance().getDernierCoupOrdi()!=null)
			dernierCoupOrdi.setText("Dernier Coup : "+BatailleNavale.getInstance().getDernierCoupOrdi());
	}
}
