package modele;

import java.util.ArrayList;

public class Joueur {
	private ArrayList<Bateau> alBateaux;
	
	public Joueur(){
		alBateaux = new ArrayList<Bateau>();
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
	
}
