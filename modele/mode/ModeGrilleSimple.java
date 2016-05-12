package modele.mode;

public class ModeGrilleSimple extends ModeGrille {

	@Override
	public int getVaisseaux(int taille) {
		int rep = 0;
		if(taille<=getTailleMaxVaisseau()){
			switch(taille){
				case 1 :
					rep = 0;
					break;
				case 2 :
					rep = 0;
					break;
				case 3 :
					rep = 6;
					break;
			}
		}
		return rep;
	}

	@Override
	public int getTailleMaxVaisseau() {
		return 3;
	}
	
	public String toString(){
		return "Mode Simple pgm";
	}


}
