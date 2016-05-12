package modele.mode;

public class ModeGrilleInter extends ModeGrille {

	@Override
	public int getVaisseaux(int taille) {
		int rep = 0;
		if(taille<=getTailleMaxVaisseau()){
			switch(taille){
				case 1 :
					rep = 0;
					break;
				case 2 :
					rep = 3;
					break;
				case 3 :
					rep = 2;
					break;
				case 4 :
					rep = 1;
					break;
			}
		}
		return rep;
	}

	@Override
	public int getTailleMaxVaisseau() {
		return 4;
	}
	
	public String toString(){
		return "Mode Inter pgm";
	}

}
