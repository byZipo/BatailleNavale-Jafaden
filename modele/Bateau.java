package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import modele.Bateau.Direction;
import modele.Bateau.Sens;

public class Bateau implements Serializable{
	
	private ArrayList<Portion> alPortion;
	private int taille;
	private int xDepart;
	private int yDepart;
	public enum Direction {H,B,D,G};
	public enum Sens {HORAIRE,ANTIHORAIRE};
	private Direction direction;
	private boolean couler;
	
	public Bateau(Direction d, int t, int x, int y){
		taille = t;
		xDepart = x;
		yDepart = y;
		direction = d;
		couler = false;
		alPortion = new ArrayList<Portion>();
		for (int i = 0; i < taille; i++) {
			switch(direction){
				case B :
					alPortion.add(new Portion(x, y+i, i, BatailleNavale.getInstance().getEpoque().getPuissance().getPuissance(taille)));
					break;
				case H :
					alPortion.add(new Portion(x, y-i, i, BatailleNavale.getInstance().getEpoque().getPuissance().getPuissance(taille)));
					break;
				case D :
					alPortion.add(new Portion(x+i, y, i, BatailleNavale.getInstance().getEpoque().getPuissance().getPuissance(taille)));
					break;
				case G :
					alPortion.add(new Portion(x-i, y, i, BatailleNavale.getInstance().getEpoque().getPuissance().getPuissance(taille)));
					break;
			}
		}
	}
	
	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getxDepart() {
		return xDepart;
	}

	public void setxDepart(int xDepart) {
		this.xDepart = xDepart;
	}

	public int getyDepart() {
		return yDepart;
	}

	public void setyDepart(int yDepart) {
		this.yDepart = yDepart;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public boolean isCouler() {
		return couler;
	}

	public void setCouler(boolean couler) {
		this.couler = couler;
	}

	public ArrayList<Portion> getPortions() {
		return alPortion;
	}

	public void deplacer(Direction d) {
		switch (d) {
			case B:
				yDepart++;
				for (Portion portion : alPortion) {
					portion.setY(portion.getY()+1);
				}
				break;
			case H:
				yDepart--;
				for (Portion portion : alPortion) {
					portion.setY(portion.getY()-1);
				}
				break;
			case D:
				xDepart++;
				for (Portion portion : alPortion) {
					portion.setX(portion.getX()+1);
				}
				break;
			case G:
				xDepart--;
				for (Portion portion : alPortion) {
					portion.setX(portion.getX()-1);
				}
				break;
		}
	}

	public void tourner(Sens sens) {
		int i = 0;
		for (Portion portion : alPortion) {
			if(i != 0){
				switch(direction){
					case H:
						if(sens==Sens.ANTIHORAIRE){
							portion.setX(xDepart-i);
						}else if(sens==Sens.HORAIRE){
							portion.setX(xDepart+i);
						}
						portion.setY(yDepart);
						break;
					case B:
						if(sens==Sens.ANTIHORAIRE){
							portion.setX(xDepart+i);
						}else if(sens==Sens.HORAIRE){
							portion.setX(xDepart-i);
						}
						portion.setY(yDepart);
						break;
					case D:
						portion.setX(xDepart);
						if(sens==Sens.ANTIHORAIRE){
							portion.setY(yDepart-i);
						}else if(sens==Sens.HORAIRE){
							portion.setY(yDepart+i);
						}
						break;
					case G:
						portion.setX(xDepart);
						if(sens==Sens.ANTIHORAIRE){
							portion.setY(yDepart+i);
						}else if(sens==Sens.HORAIRE){
							portion.setY(yDepart-i);
						}
						break;
				}
			}
			i++;
		}
		switch (direction) {
			case B:
				if(sens==Sens.ANTIHORAIRE){
					direction = Direction.D;
				}else if(sens==Sens.HORAIRE){
					direction = Direction.G;
				}
				break;
			case H:
				if(sens==Sens.ANTIHORAIRE){
					direction = Direction.G;
				}else if(sens==Sens.HORAIRE){
					direction = Direction.D;
				}
				break;
			case D:
				if(sens==Sens.ANTIHORAIRE){
					direction = Direction.H;
				}else if(sens==Sens.HORAIRE){
					direction = Direction.B;
				}
				break;
			case G:
				if(sens==Sens.ANTIHORAIRE){
					direction = Direction.B;
				}else if(sens==Sens.HORAIRE){
					direction = Direction.H;
				}
				break;
		}
	}
	
	public String toString(){
		if(BatailleNavale.getInstance().getEpoque()!=null)
			return BatailleNavale.getInstance().getEpoque().getPresentation().getNom(taille);
		else
			return "";
	}
}
