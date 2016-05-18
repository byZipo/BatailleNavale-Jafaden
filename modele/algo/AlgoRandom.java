package modele.algo;

import java.util.ArrayList;
import java.util.Random;

import modele.BatailleNavale;
import modele.Couple;
import modele.Joueur;

public class AlgoRandom extends Algo {
	private Random r;
	
	public AlgoRandom(){
		r = new Random();
	}
	
	@Override
	public Couple<Integer,Integer> getProchainCoup() {
		Couple<Integer, Integer> rep = null;
		Joueur joueur = BatailleNavale.getInstance().getJoueur();
		Joueur ordinateur = BatailleNavale.getInstance().getOrdinateur();
		if(ordinateur.getPositionConnus().size() != 0){
			rep = ordinateur.getPositionConnus().get(0);
		}else{
			boolean bon = false;
			while(!bon){
				int x = r.nextInt(BatailleNavale.TAILLE_PLATEAU);
				int y = r.nextInt(BatailleNavale.TAILLE_PLATEAU);
				rep = new Couple<Integer, Integer>(x, y);
				bon = !ordinateur.getPositionCouler().contains(rep);
			}
		}
		return rep;
	}
}
