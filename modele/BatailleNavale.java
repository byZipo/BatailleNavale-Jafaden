package modele;

import java.util.Observable;

import modele.epoque.EpoqueFactory;
import modele.epoque.EpoqueFactory.Epoque;
import modele.mode.ModeGrille;

public class BatailleNavale extends Observable{

	private static BatailleNavale instance = new BatailleNavale();
	private Etat etat = Etat.PARAM;

	//	private Bateau bateauAPlacer;
//	private Joueur joueur;
//	private Joueur ordinateur;
	private ModeGrille modeGrille;

	private EpoqueFactory epoque;
//	private BatailleNavaleDAO daoBatailleNavale;

	public enum Etat {PARAM, PLACEMENT, JEU, GAGNER, PERDU};
	
	private BatailleNavale(){
		
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
}
