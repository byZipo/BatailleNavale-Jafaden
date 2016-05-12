package modele.epoque;

import modele.epoque.xixsiecle.XIXFactory;
import modele.epoque.xxsiecle.XXFactory;
import modele.mode.ModeGrille;
import modele.mode.ModeGrille.Mode;


public abstract class EpoqueFactory {

	private static EpoqueFactory instanceEpoqueXX = new XXFactory();
	private static EpoqueFactory instanceEpoqueXIX = new XIXFactory();
	public enum Epoque {XX, XIX};
	
	protected static EpoqueFactory instance;
	protected Puissance puissance;
	protected Presentation presentation;
	
	public Puissance getPuissance(){
		return puissance;
	}
	
	public Presentation getPresentation(){
		return presentation;
	}
	
	public static EpoqueFactory getInstance(Epoque m){
		EpoqueFactory rep = null;
		switch(m){
			case XX : 
				rep = instanceEpoqueXX;
				break;
			case XIX :
				rep = instanceEpoqueXIX;
				break;
		}
		return rep;
	}
	
	public static String[] getEpoques() {
		String[] rep = {"XX eme Siecle", "XIX eme Siecle"};
		return rep;
	}
}
