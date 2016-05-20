package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import modele.BatailleNavale;

public class EcouteurMenuAlgo implements ActionListener {

	private int index;
	
	public EcouteurMenuAlgo(int i) {
		index = i;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		BatailleNavale.getInstance().setAlgo(index);
	}
}
