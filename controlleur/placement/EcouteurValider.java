package controlleur.placement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.BatailleNavale;

public class EcouteurValider implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		BatailleNavale.getInstance().validerBateauAPlacer();
	}

}
