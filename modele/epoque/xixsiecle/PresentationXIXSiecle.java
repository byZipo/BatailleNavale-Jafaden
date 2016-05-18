package modele.epoque.xixsiecle;

import java.awt.Image;

import javax.swing.ImageIcon;

import modele.Bateau.Direction;
import modele.epoque.Presentation;
import modele.epoque.Presentation.Type;

public class PresentationXIXSiecle extends Presentation {
	
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
		return rep+" : "+taille;
	}

	@Override
	public Image getPresentation(Type t, int taille, Direction dir, int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
