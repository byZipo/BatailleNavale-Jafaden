package graphique.placement;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modele.BatailleNavale;
import modele.Bateau;
import modele.epoque.Presentation.Type;

public class PanelPortion extends JPanel{
	
	private Bateau bateau;
	private int idPortion = -1;
	private Type type;
	
	public PanelPortion(){
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(VueJoueurPlacement.IMAGE_WATER, 0, 0, this.getWidth(), this.getHeight(),  null);
		if(bateau != null){
			Image image = BatailleNavale.getInstance().getEpoque().getPresentation().getPresentation(type,bateau.getTaille(), bateau.getDirection(), idPortion);
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
		}
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
}
