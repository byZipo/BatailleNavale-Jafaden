package modele.algo;

import java.util.ArrayList;
import java.util.Random;

import modele.BatailleNavale;
import modele.Bateau;
import modele.Couple;
import modele.Joueur;
import modele.Joueur.Type;
import modele.Portion;

public class AlgoCroix extends Algo {
	private Random r;
	private ArrayList<Couple<Integer,Integer>> alCoupAFaire;
	
	public AlgoCroix(){
		alCoupAFaire = new ArrayList<Couple<Integer, Integer>>();
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
				Type t = ordinateur.getPositionsAdverse()[x][y];
				if(t == Type.TOUCHE){
					rep = new Couple<Integer, Integer>(x, y);
					trouve = true;
				}
				y++;
			}
			x++;
		}
		if(!trouve){
			if(alCoupAFaire.size()==0){
				boolean bon = false;
				while(!bon){
					x = r.nextInt(BatailleNavale.TAILLE_PLATEAU);
					int y = r.nextInt(BatailleNavale.TAILLE_PLATEAU);
					rep = new Couple<Integer, Integer>(x, y);
					bon = ordinateur.getPositionsAdverse()[x][y] == Type.CACHE;
				}
			}else{
				rep = alCoupAFaire.get(0);
				alCoupAFaire.remove(0);
			}
		}
		Portion p = BatailleNavale.getInstance().getPortionAt(joueur, rep.getPremier(), rep.getDeuxieme());
		if(p!=null){
			if(!p.isCoule() && !p.isTouche()){
				ajouterCroix(rep);
			}
		}
		return rep;
	}

	private void ajouterCroix(Couple<Integer, Integer> rep) {
		int x = rep.getPremier();
		int y = rep.getDeuxieme();
			
		for(int i = 1; i < BatailleNavale.getInstance().getModeGrille().getTailleMaxVaisseau(); i++){
			Couple<Integer, Integer> c = new Couple<Integer, Integer>(x+i, y);
			if(c.getPremier() >= 0 && c.getPremier() < BatailleNavale.TAILLE_PLATEAU && c.getDeuxieme() >= 0 && c.getDeuxieme() < BatailleNavale.TAILLE_PLATEAU ){
				Type t = BatailleNavale.getInstance().getOrdinateur().getPositionsAdverse()[c.getPremier()][c.getDeuxieme()];
				if(t == Type.CACHE);
					if(!alCoupAFaire.contains(c))
						alCoupAFaire.add(c);
			}
		}	
		for(int i = 1; i < BatailleNavale.getInstance().getModeGrille().getTailleMaxVaisseau(); i++){
			Couple<Integer, Integer> c = new Couple<Integer, Integer>(x-i, y);
			if(c.getPremier() >= 0 && c.getPremier() < BatailleNavale.TAILLE_PLATEAU && c.getDeuxieme() >= 0 && c.getDeuxieme() < BatailleNavale.TAILLE_PLATEAU ){
				Type t = BatailleNavale.getInstance().getOrdinateur().getPositionsAdverse()[c.getPremier()][c.getDeuxieme()];
				if(t == Type.CACHE);
					if(!alCoupAFaire.contains(c))
						alCoupAFaire.add(alCoupAFaire.size(),c);
			}
		}	
		for(int i = 1; i < BatailleNavale.getInstance().getModeGrille().getTailleMaxVaisseau(); i++){
			Couple<Integer, Integer> c = new Couple<Integer, Integer>(x, y+i);
			if(c.getPremier() >= 0 && c.getPremier() < BatailleNavale.TAILLE_PLATEAU && c.getDeuxieme() >= 0 && c.getDeuxieme() < BatailleNavale.TAILLE_PLATEAU ){
				Type t = BatailleNavale.getInstance().getOrdinateur().getPositionsAdverse()[c.getPremier()][c.getDeuxieme()];
				if(t == Type.CACHE);
					if(!alCoupAFaire.contains(c))
						alCoupAFaire.add(c);
			}
		}	
		for(int i = 1; i < BatailleNavale.getInstance().getModeGrille().getTailleMaxVaisseau(); i++){
			Couple<Integer, Integer> c = new Couple<Integer, Integer>(x, y-i);
			if(c.getPremier() >= 0 && c.getPremier() < BatailleNavale.TAILLE_PLATEAU && c.getDeuxieme() >= 0 && c.getDeuxieme() < BatailleNavale.TAILLE_PLATEAU ){
				Type t = BatailleNavale.getInstance().getOrdinateur().getPositionsAdverse()[c.getPremier()][c.getDeuxieme()];
				if(t == Type.CACHE);
					if(!alCoupAFaire.contains(c))
						alCoupAFaire.add(c);
			}
		}
	}
}
