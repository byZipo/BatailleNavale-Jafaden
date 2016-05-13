package graphique;

import graphique.menu.VueMenu;
import graphique.placement.VuePlacement;

import java.util.Observable;

import modele.BatailleNavale;

public class Main implements Vue{
	private VueMenu vueMenu;
	private VuePlacement vuePlacement;
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main(){
		vueMenu = new VueMenu();
		vuePlacement = new VuePlacement();
		BatailleNavale.getInstance().addObserver(this);
		BatailleNavale.getInstance().miseAJour();
	}

	@Override
	public void update(Observable o, Object arg) {
		switch(BatailleNavale.getInstance().getEtat()){
			case PARAM :
				if(!vueMenu.isShowing()){
					vueMenu.setVisible(true);
				}
				vuePlacement.setVisible(false);
				break;
			case PLACEMENT :
				if(!vuePlacement.isShowing()){
					vuePlacement.setVisible(true);
				}
				vueMenu.setVisible(false);
			default :
				vueMenu.setVisible(false);
		}
	}

}
