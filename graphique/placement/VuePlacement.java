package graphique.placement;

import graphique.Vue;

import java.awt.Dimension;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.BatailleNavale;

public class VuePlacement extends JFrame implements Vue{
	
	public VuePlacement() {
		super("CAD - Bataille Navale");
		BatailleNavale.getInstance().addObserver(this);
		this.setPreferredSize(new Dimension(500, 500));
		VueJoueurPlacement vueJoueurPlacement = new VueJoueurPlacement();
		VueCommandePlacement vueCommandePlacement = new VueCommandePlacement();
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
	
		panel.add(vueJoueurPlacement);
		panel.add(vueCommandePlacement);
		add(panel);
		
	    pack() ;
        setVisible(false);
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
