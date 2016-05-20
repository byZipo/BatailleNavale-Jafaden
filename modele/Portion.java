package modele;

import java.io.Serializable;

public class Portion implements Serializable{
	private int x;
	private int y;
	private int idPortion;
	private int pdv;
	private final int maxPdv;
	
	public Portion(int x, int y, int id, int pdv){
		this.x = x;
		this.y=y;
		this.idPortion = id;
		this.pdv = pdv;
		maxPdv = pdv;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isTouche() {
		return pdv < maxPdv && !isCoule();
	}
	
	public boolean isCoule(){
		return pdv == 0;
	}
	
	public void toucher(){
		if(!isCoule())
			pdv--;
	}

	public int getId() {
		return idPortion;
	}
	
	public String toString(){
		return "pdv : "+pdv+" x : "+x+" y : "+y+" idPortion : "+idPortion;
	}

}
