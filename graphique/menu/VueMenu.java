package graphique.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;

import graphique.Vue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import controlleur.menu.EcouteurChangementAlgo;
import controlleur.menu.EcouteurChangementEpoque;
import controlleur.menu.EcouteurChangementMode;
import controlleur.menu.EcouteurDemarrer;
import modele.BatailleNavale;
import modele.BatailleNavale.Etat;
import modele.algo.Algo;
import modele.epoque.EpoqueFactory;
import modele.mode.ModeGrille;

public class VueMenu extends JFrame implements Vue{

	private JButton boutonDemarer;
	private JComboBox listeEpoque;
	private JComboBox listeMode;
	private JComboBox listeAlgo;
	
	public VueMenu(){
		super("CAD - Bataille Navale");
		BatailleNavale.getInstance().addObserver(this);
		this.setPreferredSize(new Dimension(500, 500));
		this.setLayout(new FlowLayout());
		
		boutonDemarer = new JButton("Demarer");
		listeMode = new JComboBox<>(ModeGrille.getModes());
		listeEpoque = new JComboBox<>(EpoqueFactory.getEpoques());
		listeAlgo = new JComboBox<>(Algo.getAlgos());
		
		boutonDemarer.addActionListener(new EcouteurDemarrer());
		listeMode.addActionListener(new EcouteurChangementMode());
		listeEpoque.addActionListener(new EcouteurChangementEpoque());
		listeAlgo.addActionListener(new EcouteurChangementAlgo());
		
		add(listeMode);
		add(listeEpoque);
		add(listeAlgo);
		add(boutonDemarer);
		
	    pack() ;
        setVisible(true);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.setVisible(BatailleNavale.getInstance().getEtat()==Etat.PARAM);
	}

}
