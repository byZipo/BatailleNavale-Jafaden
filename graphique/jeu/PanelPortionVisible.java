package graphique.jeu;

import graphique.jeu.VueJeu;
import graphique.jeu.VueJeuCacher;
import graphique.jeu.VueJeuVisible;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modele.BatailleNavale;
import modele.BatailleNavale.Etat;
import modele.Bateau;
import modele.Joueur;
import modele.epoque.Presentation.Type;

public class PanelPortionVisible extends JPanel{
	
	private Bateau bateau;
	private int idPortion = -1;
	private Type type;
	private boolean visible;
	private int x;
	private int y;
	
	public PanelPortionVisible(int x, int y){
		visible = false;
		this.x = x;
		this.y = y;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if(BatailleNavale.getInstance().getOrdinateur().getPositionsAdverse()[x][y] == Joueur.Type.CACHE){
			g.drawImage(VueJeu.IMAGE_FOG, 0, 0, this.getWidth(), this.getHeight(),  null);	
		}else{
			g.drawImage(VueJeu.IMAGE_WATER, 0, 0, this.getWidth(), this.getHeight(),  null);
		}

		if(bateau != null){
			Image image = BatailleNavale.getInstance().getEpoque().getPresentation().getPresentation(type,bateau.getTaille(), bateau.getDirection(), idPortion);
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);	
		}
//		
//		
//		g.drawImage(VueJeu.IMAGE_WATER, 0, 0, this.getWidth(), this.getHeight(),  null);
//		
//		
//
//		g.drawImage(VueJeu.IMAGE_FOG, 0, 0, this.getWidth(), this.getHeight(),  null);
//		if(BatailleNavale.getInstance().getEtat()==Etat.PLACEMENT)
//			g.drawImage(VueJeu.IMAGE_WATER, 0, 0, this.getWidth(), this.getHeight(),  null);
//		else if(BatailleNavale.getInstance().getEtat()==Etat.JEU){
//			if(type Type.)
//		}
//			
//		if(){
////			System.out.println(type);
//			if(type == Type.CACHER || type == Type.CACHER_JOUEUR)
//		}
//		if(bateau != null){
//			Image image = BatailleNavale.getInstance().getEpoque().getPresentation().getPresentation(type,bateau.getTaille(), bateau.getDirection(), idPortion);
//			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);	
//		}
	}
	
	public void update() {
		repaint();
	}

	public void setNull() {
		bateau = null;
		idPortion = -1;
	}

	public void setBateau(Bateau b, int id) {
		bateau = b;
		idPortion = id;
	}

	public void setType(Type t) {
		type = t;
	}

	public Type getType() {
		return type;
	}
}
