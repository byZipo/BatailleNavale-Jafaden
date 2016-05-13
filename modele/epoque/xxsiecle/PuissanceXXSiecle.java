package modele.epoque.xxsiecle;

import modele.epoque.Puissance;

public class PuissanceXXSiecle extends Puissance {

	@Override
	public int getPuissance(int taille) {
		int rep = 0;
		switch(taille){
			case 1 : 
				rep = 3;
				break;
			case 2 : 
				rep = 2;
				break;
			case 3 : 
				rep = 2;
				break;
			case 4 : 
				rep = 2;
				break;
			case 5 : 
				rep = 1;
				break;
		}
		return rep;
	}
}
