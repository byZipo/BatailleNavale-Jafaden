package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.dao.DAOBatailleNavaleFile;

public class EcouteurSauvegarder implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		DAOBatailleNavaleFile.getInstance().saveBatailleNavale();
	}
}
