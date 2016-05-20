package modele.epoque.xixsiecle;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
				rep = "Barque";
				break;
			case 2 :
				rep = "Gallion";
				break;
			case 3 :
				rep = "Pirate";
				break;
			case 4 :
				rep = "Caravelle";
				break;
			case 5 :
				rep = "OMG";
				break;
		}
		return rep+" : "+taille;
	}

	@Override
	public Image getPresentation(Type t, int taille, Direction dir, int id) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(PATH_TO_IMG+"XIX/"+t+"/"+dir+"/"+taille+"-"+id+".png"));
		} catch (IOException e) {
		}
		return img;
	}
}
