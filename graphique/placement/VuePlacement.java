package graphique.placement;

import graphique.MenuBar;
import graphique.Vue;

import java.awt.Dimension;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.BatailleNavale;
import modele.BatailleNavale.Etat;

public class VuePlacement extends JFrame implements Vue{
	
	public VuePlacement() {
		super("CAD - Bataille Navale");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BatailleNavale.getInstance().addObserver(this);
		this.setPreferredSize(new Dimension(500, 500));
		VueJoueurPlacement vueJoueurPlacement = new VueJoueurPlacement();
		VueCommandePlacement vueCommandePlacement = new VueCommandePlacement();
		this.setJMenuBar(new MenuBar());
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
		this.setVisible(BatailleNavale.getInstance().getEtat()==Etat.PLACEMENT);
	}

}
