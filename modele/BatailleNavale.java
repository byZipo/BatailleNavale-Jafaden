package modele;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import modele.Bateau.Direction;
import modele.Bateau.Sens;
import modele.Joueur.Type;
import modele.algo.Algo;
import modele.algo.Algo.Algorithme;
import modele.epoque.EpoqueFactory;
import modele.epoque.EpoqueFactory.Epoque;
import modele.mode.ModeGrille;

public class BatailleNavale extends Observable{

	private static BatailleNavale instance = new BatailleNavale();
	private Etat etat = Etat.PARAM;

	private Random r;

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
		r = new Random();
		setEpoque(0);
		setModeGrille(0);
		setAlgo(0);
		bateauxAPlacer = new DefaultComboBoxModel<Bateau>();
		joueur = new Joueur();
		ordinateur = new Joueur();
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

	public void validerBateauAPlacer() {
		joueur.ajouterBateau(bateauAPlacer);
		bateauxAPlacer.removeElement(bateauAPlacer);
		if(bateauxAPlacer.getSize()==0){//fini on passe a la suite
			bateauAPlacer = null;
			etat = Etat.JEU;
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
	
	public void initialiserOrdinateur(){
		for (int i = 1; i <= modeGrille.getTailleMaxVaisseau(); i++) {
			for (int j = 0; j < modeGrille.getVaisseaux(i); j++) {
				Bateau b = makeBateauOdrinateurValide(i);
				ordinateur.ajouterBateau(b);
			}
		}
	}
	
	public Bateau makeBateauOdrinateurValide(int taille){
		Bateau rep = null;
		boolean bon = false;
		while(!bon){
			int x = r.nextInt(BatailleNavale.TAILLE_PLATEAU);
			int y = r.nextInt(BatailleNavale.TAILLE_PLATEAU);
			int indiceDirection = r.nextInt(Bateau.Direction.values().length);
			rep = new Bateau(Direction.values()[indiceDirection], taille, x, y);
			bon = !isColisionOtherBateauOrdi(rep) && isBienPlacer(rep);
		}
		return rep;
	}
	
	public boolean isBienPlacer(Bateau rep) {
		boolean bon = true;
		// TODO Auto-generated method stub
		int iPortion = 0;
		while(bon && iPortion < rep.getPortions().size()){
			Portion op = rep.getPortions().get(iPortion);
			if(op.getX() < 0 || op.getX() >= BatailleNavale.TAILLE_PLATEAU || op.getY() < 0 || op.getY() >= BatailleNavale.TAILLE_PLATEAU)
				bon = false;
			else
				iPortion++;
		}
		return bon;
	}

	public boolean isColisionOtherBateauOrdi(Bateau b){
		boolean colision = false;
		int iPortion = 0;
		while(!colision && iPortion < b.getPortions().size()){
			Portion p = b.getPortions().get(iPortion);
			if(isColisionOtherPortionOrdi(p)){
				colision = true;
			}else{
				iPortion++;
			}
		}
		return colision;
	}
	
	public boolean isColisionOtherPortionOrdi(Portion p){
		boolean colision = false;
		int iBateau = 0;
		while(!colision && iBateau < ordinateur.getBateaux().size()){
			Bateau b = ordinateur.getBateau(iBateau);
			int iPortion = 0;
			while(!colision && iPortion < b.getPortions().size()){
				Portion op = b.getPortions().get(iPortion);
				if(op.getX() == p.getX() && op.getY() == p.getY()){
					colision = true;
				}
				iPortion++;
			}
			iBateau++;
		}
		return colision;
	}
	
	public Portion getPortionAt(Joueur j, int x, int y){
		Portion rep = null;
		boolean trouve = false;
		int iBateau = 0;
		while(!trouve && iBateau < j.getBateaux().size()){
			Bateau b = j.getBateau(iBateau);
			int iPortion = 0;
			while(!trouve && iPortion < b.getPortions().size()){
				Portion p = b.getPortions().get(iPortion);
				if(x == p.getX() && y == p.getY()){
					trouve = true;
					rep = p;
				}
				iPortion++;
			}
			iBateau++;
		}
		return rep;
	}
	
	public void jouer(){
		Couple<Integer,Integer> coup = algo.getProchainCoup();
		Portion p = getPortionAt(joueur, coup.getPremier(), coup.getDeuxieme());
		Type t = Type.VISIBLE;
		if(p != null){
			p.toucher();
			t = Type.TOUCHE;
			if(p.isCoule()){
				t = Type.COULER;
			}
		}
		ordinateur.setPosition(coup.getPremier(), coup.getDeuxieme(), t);
	}
	
	public void jouer(int x, int y){
		Portion p = getPortionAt(ordinateur, x, y);
//		System.out.println(p.getX()+" "+p.getY());
//		System.out.println(p);
		if(p == null){
			joueur.setPosition(x, y, Type.VISIBLE);
		}else{
			joueur.setPosition(x, y, p.isTouche()?Type.TOUCHE:Type.COULER);
			p.toucher();
		}
		jouer();
		miseAJour();
	}
}
