package graphique.placement;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Observable;

import graphique.Vue;
import graphique.menu.VueMenu;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

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
	protected ImageIcon flecheHaut = new ImageIcon(VueMenu.class.getResource("/img/fleche-haut.png"));
	protected ImageIcon flecheBas = new ImageIcon(VueMenu.class.getResource("/img/fleche-bas.png"));
	protected ImageIcon flecheGauche = new ImageIcon(VueMenu.class.getResource("/img/fleche-gauche.png"));
	protected ImageIcon flecheDroite = new ImageIcon(VueMenu.class.getResource("/img/fleche-droite.png"));
	protected ImageIcon rotationHoraire = new ImageIcon(VueMenu.class.getResource("/img/rotation-horaire.png"));
	protected ImageIcon rotationAntiHoraire = new ImageIcon(VueMenu.class.getResource("/img/rotation-antihoraire.png"));
	
	public VueCommandePlacement() {
		Border thickBorder = new LineBorder(Color.BLACK, 3);
		BatailleNavale.getInstance().addObserver(this);
		btHaut = new JButton();
		btHaut.addActionListener(new EcouteurDirection(Direction.H));
		btHaut.setIcon(flecheHaut);
		btHaut.setFocusable(false);
		btHaut.setBackground(Color.WHITE);
		//btHaut.setBorder(thickBorder);
		
		btBas = new JButton();
		btBas.addActionListener(new EcouteurDirection(Direction.B));
		btBas.setIcon(flecheBas);
		btBas.setFocusable(false);
		btBas.setBackground(Color.WHITE);
		//btBas.setBorder(thickBorder);
		
		btDroite = new JButton();
		btDroite.addActionListener(new EcouteurDirection(Direction.D));
		btDroite.setIcon(flecheDroite);
		btDroite.setFocusable(false);
		btDroite.setBackground(Color.WHITE);
		//btDroite.setBorder(thickBorder);
		
		btGauche = new JButton();
		btGauche.addActionListener(new EcouteurDirection(Direction.G));
		btGauche.setIcon(flecheGauche);
		btGauche.setFocusable(false);
		btGauche.setBackground(Color.WHITE);
		//btGauche.setBorder(thickBorder);
		
		btValider = new JButton("Ok");
		btValider.addActionListener(new EcouteurValider());
		btValider.setFocusable(false);
		btValider.setBackground(Color.WHITE);
		//btValider.setBorder(thickBorder);
		
		btRotationAntiHoraire = new JButton();
		btRotationAntiHoraire.addActionListener(new EcouteurSens(Sens.ANTIHORAIRE));
		btRotationAntiHoraire.setIcon(rotationAntiHoraire);
		btRotationAntiHoraire.setFocusable(false);
		btRotationAntiHoraire.setBackground(Color.WHITE);
		
		btRotationHoraire = new JButton();
		btRotationHoraire.addActionListener(new EcouteurSens(Sens.HORAIRE));
		btRotationHoraire.setIcon(rotationHoraire);
		btRotationHoraire.setFocusable(false);
		btRotationHoraire.setBackground(Color.WHITE);
		
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
