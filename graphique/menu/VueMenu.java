package graphique.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import controlleur.menu.EcouteurChangementAlgo;
import controlleur.menu.EcouteurChangementEpoque;
import controlleur.menu.EcouteurChangementMode;
import controlleur.menu.EcouteurDemarrer;
import graphique.MenuBar;
import graphique.Vue;
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
	protected ImageIcon vueMenu = new ImageIcon(VueMenu.class.getResource("/img/vue-menu.png"));
	
	public VueMenu(){
		super("Battaille navale - Menu");
		
		Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int largeur = 500;
        int hauteur = 570;
        int dx = (centerPoint.x - windowSize.width / 2) - 250;
        int dy = (centerPoint.y - windowSize.height / 2) - 285;    
        setLocation(dx, dy);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BatailleNavale.getInstance().addObserver(this);
		this.setPreferredSize(new Dimension(largeur, hauteur));
		//this.setLayout(new FlowLayout());
		BorderLayout borderImage = new BorderLayout();
		this.setLayout(borderImage);
		
		this.setJMenuBar(new MenuBar());
		boutonDemarer = new JButton("JOUER !");
		Color colorDemarer = new Color(82,14,7);
		boutonDemarer.setBackground(colorDemarer);
		boutonDemarer.setForeground(Color.WHITE);
		Border thickBorder = new LineBorder(Color.BLACK, 3);
		boutonDemarer.setBorder(thickBorder);
		
		listeMode = new JComboBox<>(ModeGrille.getModes());
		listeEpoque = new JComboBox<>(EpoqueFactory.getEpoques());
		listeAlgo = new JComboBox<>(Algo.getAlgos());
		
		boutonDemarer.addActionListener(new EcouteurDemarrer());
		listeMode.addActionListener(new EcouteurChangementMode());
		listeEpoque.addActionListener(new EcouteurChangementEpoque());
		listeAlgo.addActionListener(new EcouteurChangementAlgo());
		
		JLabel imageMenu = new JLabel(vueMenu);
		add(BorderLayout.NORTH, imageMenu);
		
		JPanel modeJeu = new JPanel();
		BoxLayout boxLayoutModeJeu = new BoxLayout(modeJeu, BoxLayout.PAGE_AXIS);
		modeJeu.setLayout(boxLayoutModeJeu);
		JLabel jLabelModeJeu = new JLabel("Mode de jeu :");
		JPanel jPanelModeDeJeu = new JPanel();
		jPanelModeDeJeu.setLayout(new FlowLayout(FlowLayout.LEFT));
		jPanelModeDeJeu.add(jLabelModeJeu);
		modeJeu.add(jPanelModeDeJeu);
		modeJeu.add(listeMode);
		
		JPanel epoque = new JPanel();
		BoxLayout boxLayoutEpoque = new BoxLayout(epoque, BoxLayout.PAGE_AXIS);
		epoque.setLayout(boxLayoutEpoque);
		JLabel jLabelEpoque = new JLabel("Epoque :");
		JPanel jPanelEpoque = new JPanel();
		jPanelEpoque.setLayout(new FlowLayout(FlowLayout.LEFT));
		jPanelEpoque.add(jLabelEpoque);
		epoque.add(jPanelEpoque);
		epoque.add(listeEpoque);
		
		JPanel algo = new JPanel();
		BoxLayout boxLayoutAlgo = new BoxLayout(algo, BoxLayout.PAGE_AXIS);
		algo.setLayout(boxLayoutAlgo);
		JLabel jLabelAlgo = new JLabel("Algo ordi :");
		JPanel jPanelAlgo = new JPanel();
		jPanelAlgo.setLayout(new FlowLayout(FlowLayout.LEFT));
		jPanelAlgo.add(jLabelAlgo);
		algo.add(jPanelAlgo);
		algo.add(listeAlgo);
		
		JPanel menu = new JPanel();
		FlowLayout flowLayoutMenu = new FlowLayout();
		menu.setLayout(flowLayoutMenu);
		menu.add(modeJeu);
		menu.add(epoque);
		menu.add(algo);
		
		add(BorderLayout.CENTER, menu);
		add(BorderLayout.SOUTH, boutonDemarer);
		
	    pack() ;
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.setVisible(BatailleNavale.getInstance().getEtat()==Etat.PARAM);
	}

}
