package controlleur.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.BatailleNavale;

public class EcouteurDemarrer implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		BatailleNavale.getInstance().validerOption();
	}

}
