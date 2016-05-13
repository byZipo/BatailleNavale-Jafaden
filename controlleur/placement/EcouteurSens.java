package controlleur.placement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.BatailleNavale;
import modele.Bateau.Direction;
import modele.Bateau.Sens;

public class EcouteurSens implements ActionListener {

	private Sens sens;
	
	public EcouteurSens(Sens s) {
		sens = s;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(BatailleNavale.getInstance().peutEtreTourner(sens))
			BatailleNavale.getInstance().tournerBateauAPlacer(sens);
	}

}
