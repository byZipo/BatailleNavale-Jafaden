package modele.epoque.xxsiecle;

import modele.epoque.EpoqueFactory;

public class XXFactory extends EpoqueFactory {
	
	public XXFactory(){
		presentation = new PresentationXXSiecle();
		puissance = new PuissanceXXSiecle();
	}
	
	public String toString(){
		return "XXFactory pgm";
	}
}
