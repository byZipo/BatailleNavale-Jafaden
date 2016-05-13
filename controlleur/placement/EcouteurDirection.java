package controlleur.placement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.BatailleNavale;
import modele.Bateau.Direction;

public class EcouteurDirection implements ActionListener {

	private Direction dir;
	
	public EcouteurDirection(Direction d) {
		dir = d;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(BatailleNavale.getInstance().peutEtreDeplacer(dir))
			BatailleNavale.getInstance().deplacerBateauAPlacer(dir);
	}

}
