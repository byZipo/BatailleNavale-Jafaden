package modele.algo;

import modele.Couple;
import modele.Joueur;

public abstract class Algo {
	private static Algo instanceAlgoRandom = new AlgoRandom();
	
	public enum Algorithme {RANDOM};
	
	/**
	 * Renvoi un couple x,y corespondant au coup que l'ordi fait en fonction du joueur passer en parametre
	 * @return
	 */
	public abstract Couple<Integer,Integer> getProchainCoup();
	
	
	public static Algo getInstance(Algorithme m){
		Algo rep = null;
		switch(m){
			case RANDOM : 
				rep = instanceAlgoRandom;
				break;
		}
		return rep;
	}

	public static String[] getAlgos() {
		String[] rep = {"Random"};
		
		return rep;
	}
}
