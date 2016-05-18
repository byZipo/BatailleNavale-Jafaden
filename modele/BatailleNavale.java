package modele;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import modele.Bateau.Direction;
import modele.Bateau.Sens;
import modele.algo.Algo;
import modele.algo.Algo.Algorithme;
import modele.epoque.EpoqueFactory;
import modele.epoque.EpoqueFactory.Epoque;
import modele.mode.ModeGrille;

public class BatailleNavale extends Observable{

	private static BatailleNavale instance = new BatailleNavale();
	private Etat etat = Etat.PARAM;

	private Bateau bateauAPlacer;
	private Joueur joueur;
	private Joueur ordinateur;
	private ModeGrille modeGrille;
	private Algo algo;
	
	public static final int TAILLE_PLATEAU = 10; 

	private EpoqueFactory epoque;
//	private BatailleNavaleDAO daoBatailleNavale;
//	private ComboBoxBateauxModel bateauxAPlacer;
	private DefaultComboBoxModel<Bateau> bateauxAPlacer;

	public enum Etat {PARAM, PLACEMENT, JEU, GAGNER, PERDU};
	
	private BatailleNavale(){
		setEpoque(0);
		setModeGrille(0);
		setAlgo(0);
		bateauxAPlacer = new DefaultComboBoxModel<Bateau>();
		joueur = new Joueur();
	}
	
	public static BatailleNavale getInstance(){
		return instance;
	}
	
	public Etat getEtat(){
		return etat;
	}
	
	public void setEtat(Etat e) {
		etat = e;
		miseAJour();
	}

	public Bateau getBateauAPlacer() {
		return bateauAPlacer;
	}

	public void setBateauAPlacer(Bateau bateauAPlacer) {
		this.bateauAPlacer = bateauAPlacer;
	}

	public void miseAJour() {
		setChanged();
		notifyObservers();
	}

	
	

	public ModeGrille getModeGrille() {
		return modeGrille;
	}

	public void setModeGrille(ModeGrille m) {
		modeGrille = m;
		miseAJour();
	}
	
	public void setModeGrille(int selectedIndex) {
		modeGrille = ModeGrille.getInstance(ModeGrille.Mode.values()[selectedIndex]);
		miseAJour();
	}
	
	
	public Algo getAlgo() {
		return algo;
	}

	public void setAlgo(Algo a) {
		algo = a;
		miseAJour();
	}
	
	public void setAlgo(int selectedIndex) {
		algo = Algo.getInstance(Algo.Algorithme.values()[selectedIndex]);
		miseAJour();
	}
	
	public EpoqueFactory getEpoque() {
		return epoque;
	}

	public void setEpoque(EpoqueFactory epoque) {
		this.epoque = epoque;
	}
	
	public void setEpoque(int selectedIndex) {
//		etat = EpoqueFactory.getInstance(ModeGrille.Mode.values()[selectedIndex]);
		epoque = EpoqueFactory.getInstance(Epoque.values()[selectedIndex]);
		miseAJour();
	}

	public void validerOption() {
		etat = Etat.PLACEMENT;
//		bateauxAPlacer = new ComboBoxBateauxModel();
		for (int i = 1; i <= modeGrille.getTailleMaxVaisseau(); i++) {
			for (int j = 0; j < modeGrille.getVaisseaux(i); j++) {
				bateauxAPlacer.addElement(new Bateau(Direction.H, i, TAILLE_PLATEAU/2, TAILLE_PLATEAU/2));
			}
		}
		bateauAPlacer = (Bateau) bateauxAPlacer.getSelectedItem();
		miseAJour();
	}
	
	public Joueur getJoueur(){
		return joueur;
	}
	
	public Joueur getOrdinateur(){
		return ordinateur;
	}

	public ArrayList<Bateau> getBateauJoueur(){
		return joueur.getBateaux();
	}
	
	public void deplacerBateauAPlacer(Direction d){
		bateauAPlacer.deplacer(d);
		miseAJour();
	}

	public void tournerBateauAPlacer(Sens sens) {
		bateauAPlacer.tourner(sens);
		miseAJour();
	}

	public boolean peutEtreTourner(Sens s) {
		boolean rep = false;
		switch(s){
			case HORAIRE : 
				switch(bateauAPlacer.getDirection()){
					case H : 
						rep = bateauAPlacer.getxDepart()+(bateauAPlacer.getTaille()-1)<TAILLE_PLATEAU;
						break;
					case B : 
						rep = bateauAPlacer.getxDepart()-(bateauAPlacer.getTaille()-2)>0;
						break;
					case D : 
						rep = bateauAPlacer.getyDepart()+(bateauAPlacer.getTaille()-1)<TAILLE_PLATEAU;
						break;
					case G : 
						rep = bateauAPlacer.getyDepart()-(bateauAPlacer.getTaille()-2)>0;
						break;
				}
				break;
			case ANTIHORAIRE :
				switch(bateauAPlacer.getDirection()){
				case H : 
					rep = bateauAPlacer.getxDepart()-(bateauAPlacer.getTaille()-2)>0;
					break;
				case B : 
					rep = bateauAPlacer.getxDepart()+(bateauAPlacer.getTaille()-1)<TAILLE_PLATEAU;
					break;
				case D : 
					rep = bateauAPlacer.getyDepart()-(bateauAPlacer.getTaille()-2)>0;
					break;
				case G : 
					rep = bateauAPlacer.getyDepart()+(bateauAPlacer.getTaille()-1)<TAILLE_PLATEAU;
					break;
			}
				break;
		}
		return rep;
	}
	
	public boolean peutEtreDeplacer(Direction h) {
		boolean rep = false;
		switch (h) {
		case H:
			if(bateauAPlacer.getDirection()==Direction.H){
				rep = bateauAPlacer.getyDepart()-(bateauAPlacer.getTaille()-1)>0;
			}else{
				rep = bateauAPlacer.getyDepart()>0;
			}
			break;
		case B:
			if(bateauAPlacer.getDirection()==Direction.B){
				rep = bateauAPlacer.getyDepart()+(bateauAPlacer.getTaille()-1)<TAILLE_PLATEAU-1;
			}else{
				rep = bateauAPlacer.getyDepart()<TAILLE_PLATEAU-1;
			}
			break;
		case D:
			if(bateauAPlacer.getDirection()==Direction.D){
				rep = bateauAPlacer.getxDepart()+(bateauAPlacer.getTaille()-1)<TAILLE_PLATEAU-1;
			}else{
				rep = bateauAPlacer.getxDepart()<TAILLE_PLATEAU-1;
			}
			break;
		case G:
			if(bateauAPlacer.getDirection()==Direction.G){
				rep = bateauAPlacer.getxDepart()-(bateauAPlacer.getTaille()-1)>0;
			}else{
				rep = bateauAPlacer.getxDepart()>0;
			}
			break;

		default:
			break;
		}
		return rep;
	}
	
	private void initialiserOrdinateur(){
		
	}

	public void validerBateauAPlacer() {
		joueur.ajouterBateau(bateauAPlacer);
		bateauxAPlacer.removeElement(bateauAPlacer);
		if(bateauxAPlacer.getSize()==0){//fini on passe a la suite
			bateauAPlacer = null;
			etat = Etat.JEU;
			System.out.println(etat);
			initialiserOrdinateur();
		}else{
			bateauAPlacer = (Bateau) bateauxAPlacer.getSelectedItem();
		}
		setChanged();
		notifyObservers();
	}

	public DefaultComboBoxModel<Bateau> getBateauxAPlacerModel() {
		return bateauxAPlacer;
	}

	public void updateBateauAPlacer() {
		bateauAPlacer = (Bateau) bateauxAPlacer.getSelectedItem();
		try{
			miseAJour();
		}catch(Exception e){
			
		}
	}
}
