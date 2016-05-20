package modele;

import java.io.Serializable;
import java.util.ArrayList;

public class Joueur implements Serializable{
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
		boolean perdu = true;
		int iBateau = 0;
		while(perdu && iBateau < alBateaux.size()){
			Bateau b = alBateaux.get(iBateau);
			int iPortion = 0;
			while(perdu && iPortion < b.getPortions().size()){
				Portion p = b.getPortions().get(iPortion);
				if(!p.isCoule()){
					perdu = false;
				}
				iPortion++;
			}
			iBateau++;
		}
		return perdu; 
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
}
