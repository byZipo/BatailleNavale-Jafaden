package controlleur.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import modele.BatailleNavale;

public class EcouteurChangementEpoque implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JComboBox jcEpoque = (JComboBox<String>)arg0.getSource();
		BatailleNavale.getInstance().setEpoque(jcEpoque.getSelectedIndex());
	}
}
