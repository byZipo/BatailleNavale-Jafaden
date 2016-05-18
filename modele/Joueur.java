package modele;

import java.util.ArrayList;

public class Joueur {
	private ArrayList<Bateau> alBateaux;
	private ArrayList<Couple<Integer,Integer>> alPositionConnu;
	private ArrayList<Couple<Integer,Integer>> alPositionCouler;
	
	public Joueur(){
		alBateaux = new ArrayList<Bateau>();
		alPositionConnu = new ArrayList<Couple<Integer,Integer>>();
		alPositionCouler = new ArrayList<Couple<Integer,Integer>>();
	}
	
	public void ajouterBateau(Bateau b){
		alBateaux.add(b);
	}
	
	public boolean isPerdu(){
		return alBateaux.size() == 0; 
	}
	
	public Bateau getBateau(int indice){
		return alBateaux.get(indice);
	}
	
	public int nbBateaux(){
		return alBateaux.size();
	}

	public ArrayList<Bateau> getBateaux() {
		return alBateaux;
	}
	
	public ArrayList<Couple<Integer,Integer>> getPositionConnus(){
		return alPositionConnu;
	}
	
	public ArrayList<Couple<Integer,Integer>> getPositionCouler(){
		return alPositionCouler;
	}
	
}
