package modele.epoque;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

import modele.Bateau.Direction;

public abstract class Presentation {
	//les fichiers images sont des bmp 
	public enum Type {A_POSITIONNER, PLACER, TOUCHER, COULER};
	public static final String PATH_TO_IMG = Presentation.class.getResource("").getPath()+"../../../src/img/";
	public abstract Image getPresentation(Type t, int taille, Direction dir, int id);
	public abstract String getNom(int taille);
	public void getPath() {
		System.out.println(PATH_TO_IMG);
	}
}
