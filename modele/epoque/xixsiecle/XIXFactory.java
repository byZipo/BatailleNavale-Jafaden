package modele.epoque.xixsiecle;

import modele.epoque.EpoqueFactory;

public class XIXFactory extends EpoqueFactory {
	
	public XIXFactory(){
		presentation = new PresentationXIXSiecle();
		puissance = new PuissanceXIXSiecle();
	}
	
	public String toString(){
		return "XIXFactory pgm";
	}
}
