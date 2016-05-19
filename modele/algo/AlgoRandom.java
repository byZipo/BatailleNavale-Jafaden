package modele.algo;

import java.util.ArrayList;
import java.util.Random;

import modele.BatailleNavale;
import modele.Bateau;
import modele.Couple;
import modele.Joueur;
import modele.Joueur.Type;
import modele.Portion;

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
		
		boolean trouve = false;
		int x = 0;
		while(!trouve && x < ordinateur.getPositionsAdverse().length){
			int y = 0;
			while(!trouve && y < ordinateur.getPositionsAdverse()[x].length){
				Type toto = ordinateur.getPositionsAdverse()[x][y];
				System.out.println(toto);
				if(toto == Type.TOUCHE){
					rep = new Couple<Integer, Integer>(x, y);
					trouve = true;
				}
				y++;
			}
			x++;
		}
		if(!trouve){
			boolean bon = false;
			while(!bon){
				x = r.nextInt(BatailleNavale.TAILLE_PLATEAU);
				int y = r.nextInt(BatailleNavale.TAILLE_PLATEAU);
				rep = new Couple<Integer, Integer>(x, y);
				bon = ordinateur.getPositionsAdverse()[x][y] == Type.CACHE;
//				bon = !ordinateur.getPositionCouler().contains(rep);
			}
		}else{
			
		}
		return rep;
//		boolean bon = false;
//		while(!bon){
//			int x = r.nextInt(BatailleNavale.TAILLE_PLATEAU);
//			int y = r.nextInt(BatailleNavale.TAILLE_PLATEAU);
//			rep = new Couple<Integer, Integer>(x, y);
//			bon = ordinateur.getPositionsAdverse()[x][y] == 
//			bon = !ordinateur.getPositionCouler().contains(rep);
//		}
//		return rep;
	}
}
