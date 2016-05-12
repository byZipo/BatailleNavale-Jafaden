package modele.mode;

public abstract class ModeGrille {
	private static ModeGrille instanceModeInter = new ModeGrilleInter();
	private static ModeGrille instanceModeSimple = new ModeGrilleSimple();
	
	public enum Mode {INTER, SIMPLE};
	
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
	
	public static ModeGrille getInstance(Mode m){
		ModeGrille rep = null;
		switch(m){
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
		String[] rep = {"Intermediaire", "Simple"};
		return rep;
	}
}
