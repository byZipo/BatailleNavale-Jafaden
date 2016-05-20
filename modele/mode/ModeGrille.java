package modele.mode;

import java.io.Serializable;

public abstract class ModeGrille implements Serializable{
	private static ModeGrille instanceModeInter = new ModeGrilleInter();
	private static ModeGrille instanceModeSimple = new ModeGrilleSimple();
	private static ModeGrille instanceModeTest = new ModeGrilleTest();
	
	public enum Mode {TEST, INTER, SIMPLE};
	
	/**
	 * Renvoi le nombre de vaisseau de la taille passer en parametre pour ce mode
	 * @param taille taille des vaisseaux
	 * @return 
	 */
	public abstract int getVaisseaux(int taille);
	
	/**
	 * Renvoi la taille maximum d'un vaisseau dans ce mode
	 * @return
	 */
	public abstract int getTailleMaxVaisseau();
	
	public abstract int getNbVaisseau();
	
	public static ModeGrille getInstance(Mode m){
		ModeGrille rep = null;
		switch(m){
			case TEST : 
				rep = instanceModeTest;
				break;
			case INTER : 
				rep = instanceModeInter;
				break;
			case SIMPLE :
				rep = instanceModeSimple;
				break;
		}
		return rep;
	}

	public static String[] getModes() {
		String[] rep = {"Test", "Intermediaire", "Simple"};
		
		return rep;
	}
}
