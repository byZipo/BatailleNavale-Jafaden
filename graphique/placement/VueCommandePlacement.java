package graphique.placement;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Observable;

import graphique.Vue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import controlleur.menu.EcouteurChangementMode;
import controlleur.placement.EcouteurChangerBateau;
import controlleur.placement.EcouteurDirection;
import controlleur.placement.EcouteurSens;
import controlleur.placement.EcouteurValider;
import modele.BatailleNavale;
import modele.BatailleNavale.Etat;
import modele.Bateau;
import modele.Bateau.Direction;
import modele.Bateau.Sens;

public class VueCommandePlacement extends JPanel implements Vue {

	private JButton btHaut;
	private JButton btBas;
	private JButton btDroite;
	private JButton btGauche;
	private JButton btValider;
	private JButton btRotationHoraire;
	private JButton btRotationAntiHoraire;
	private JComboBox listeBateau;
	
	public VueCommandePlacement() {
		BatailleNavale.getInstance().addObserver(this);
		btHaut = new JButton("^");
		btHaut.addActionListener(new EcouteurDirection(Direction.H));
		btBas = new JButton("v");
		btBas.addActionListener(new EcouteurDirection(Direction.B));
		btDroite = new JButton(">");
		btDroite.addActionListener(new EcouteurDirection(Direction.D));
		btGauche = new JButton("<");
		btGauche.addActionListener(new EcouteurDirection(Direction.G));
		btValider = new JButton("Ok");
		btValider.addActionListener(new EcouteurValider());
		btRotationAntiHoraire = new JButton("<u");
		btRotationAntiHoraire.addActionListener(new EcouteurSens(Sens.ANTIHORAIRE));
		btRotationHoraire = new JButton("c>");
		btRotationHoraire.addActionListener(new EcouteurSens(Sens.HORAIRE));
		listeBateau = new JComboBox<Bateau>(BatailleNavale.getInstance().getBateauxAPlacerModel());
		listeBateau.addActionListener(new EcouteurChangerBateau());
		
		JPanel panelBouton1 = new JPanel();
		panelBouton1.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panelBouton1.add(btHaut, c);
		c.gridx = 1;
		c.gridy = 2;
		panelBouton1.add(btBas, c);
		c.gridx = 2;
		c.gridy = 1;
		panelBouton1.add(btDroite, c);
		c.gridx = 0;
		c.gridy = 1;
		panelBouton1.add(btGauche, c);
		c.gridx = 1;
		c.gridy = 1;
		panelBouton1.add(btValider, c);
		this.add(panelBouton1);
		
		JPanel panelBouton2 = new JPanel();
		panelBouton2.setLayout(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 0;
		panelBouton2.add(btRotationHoraire, c);
		c.gridx = 0;
		c.gridy = 1;
		panelBouton2.add(btRotationAntiHoraire, c);
		this.add(panelBouton2);
		
		JPanel panelBouton3 = new JPanel();
		panelBouton3.add(listeBateau);
		this.add(panelBouton3);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(BatailleNavale.getInstance().getEtat()==Etat.PLACEMENT){
			BatailleNavale b = BatailleNavale.getInstance();
			btHaut.setEnabled(b.peutEtreDeplacer(Direction.H));
			btBas.setEnabled(b.peutEtreDeplacer(Direction.B));
			btDroite.setEnabled(b.peutEtreDeplacer(Direction.D));
			btGauche.setEnabled(b.peutEtreDeplacer(Direction.G));
			btRotationAntiHoraire.setEnabled(b.peutEtreTourner(Sens.ANTIHORAIRE));
			btRotationHoraire.setEnabled(b.peutEtreTourner(Sens.HORAIRE));
			btValider.setEnabled(BatailleNavale.getInstance().bateauAPlacerBienPlacer());
		}
	}

}
