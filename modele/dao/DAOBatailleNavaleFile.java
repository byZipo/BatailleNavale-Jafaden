package modele.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import modele.BatailleNavale;

public class DAOBatailleNavaleFile extends DAOBatailleNavale {

	@Override
	public void saveBatailleNavale() {
		String fichier = "";
		JFileChooser fileChooser = new JFileChooser();
		File file = new File(new File(System.getProperty("user.home")).getAbsolutePath());
		fileChooser.setCurrentDirectory(file);
		int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
			fichier = selectedFile.getAbsolutePath();
			try {
				FileOutputStream fileOut = new FileOutputStream(fichier);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(BatailleNavale.getInstance());
				out.close();
				fileOut.close();
				JOptionPane.showMessageDialog(null,
					    "Votre partie à bien été sauvegardé.",
					    "Bataille Navale",
					    JOptionPane.PLAIN_MESSAGE);
			} catch (IOException i) {
				i.printStackTrace();
			}
		}
	}

	@Override
	public void loadBatailleNavale() {
		String fichier = "";
		JFileChooser fileChooser = new JFileChooser();
		File file = new File(new File(System.getProperty("user.home")).getAbsolutePath());
		fileChooser.setCurrentDirectory(file);
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
			fichier = selectedFile.getAbsolutePath();
			BatailleNavale b = null;
			try {
				FileInputStream fileIn = new FileInputStream(fichier);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				b = (BatailleNavale) in.readObject();
				BatailleNavale.getInstance().loadInstance(b);
				in.close();
				fileIn.close();
				JOptionPane.showMessageDialog(null,
				    "Votre partie à bien été chargé.",
				    "Bataille Navale",
				    JOptionPane.PLAIN_MESSAGE);
			} catch (IOException i) {
				i.printStackTrace();
			} catch (ClassNotFoundException c) {
				c.printStackTrace();
			}
		}
	}

}
