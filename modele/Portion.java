package modele;

public class Portion {
	private int x;
	private int y;
	private boolean touche;
	
	public Portion(int x, int y){
		this.x = x;
		this.y=y;
		touche = false;
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
		return touche;
	}
	
	public void setTouche(){
		touche = true;
	}

}
