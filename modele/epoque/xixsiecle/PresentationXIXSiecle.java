package modele.epoque.xixsiecle;

import javax.swing.ImageIcon;

import modele.epoque.Presentation;

public class PresentationXIXSiecle extends Presentation {
	@Override
	public ImageIcon getPresentation(int taille) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getNom(int taille) {
		String rep = null;
		switch(taille){
			case 1 :
				rep = "Chtio";
				break;
			case 2 :
				rep = "Moins Chtio";
				break;
			case 3 :
				rep = "La Base";
				break;
			case 4 :
				rep = "Big";
				break;
			case 5 :
				rep = "OMG";
				break;
		}
		return rep+" "+taille;
	}
}
