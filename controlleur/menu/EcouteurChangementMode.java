package controlleur.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import modele.BatailleNavale;

public class EcouteurChangementMode implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JComboBox jcMode = (JComboBox<String>)arg0.getSource();
		BatailleNavale.getInstance().setModeGrille(jcMode.getSelectedIndex());
	}
}
