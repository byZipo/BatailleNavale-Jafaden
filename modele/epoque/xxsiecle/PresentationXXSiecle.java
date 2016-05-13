package modele.epoque.xxsiecle;

import javax.swing.ImageIcon;

import modele.epoque.Presentation;

public class PresentationXXSiecle extends Presentation {
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
				rep = "Petit";
				break;
			case 2 :
				rep = "Moins Petit";
				break;
			case 3 :
				rep = "Moyen";
				break;
			case 4 :
				rep = "Grand";
				break;
			case 5 :
				rep = "Enorme";
				break;
		}
		return rep+" "+taille;
	}
}
