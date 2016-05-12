package graphique;

import graphique.menu.VueMenu;

import java.util.Observable;

import modele.BatailleNavale;

public class Main implements Vue{
	private VueMenu vueMenu;
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main(){
		vueMenu = new VueMenu();
		BatailleNavale.getInstance().miseAJour();
	}

	@Override
	public void update(Observable o, Object arg) {
		switch(BatailleNavale.getInstance().getEtat()){
			case PARAM :
				if(!vueMenu.isShowing()){
					vueMenu.setVisible(true);
				}
				break;
		}
	}

}
