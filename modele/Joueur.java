package modele;

import java.util.ArrayList;

public class Joueur {
	private ArrayList<Bateau> alBateaux;
	public enum Type {CACHE,TOUCHE,COULER,VISIBLE}
	private Type[][] positionsAdverse;
	
	public Joueur(){
		alBateaux = new ArrayList<Bateau>();
		positionsAdverse = new Type[BatailleNavale.TAILLE_PLATEAU][BatailleNavale.TAILLE_PLATEAU];
		for (int i = 0; i < positionsAdverse.length; i++) {
			for (int j = 0; j < positionsAdverse[i].length; j++) {
				positionsAdverse[i][j] = Type.CACHE;
			}
		}
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
	
	public void setPosition(int x, int y, Type t){
		positionsAdverse[x][y] = t;
	}
	
	public Type[][] getPositionsAdverse(){
		return positionsAdverse;
	}
	
	public int getNbToucher(){
		int rep = 0;
		return 0;
	}
}
