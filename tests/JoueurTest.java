package tests;

import static org.junit.Assert.*;
import modele.Bateau;
import modele.Bateau.Direction;
import modele.Bateau.Sens;
import modele.Joueur;
import modele.Portion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JoueurTest {

	@Test
	public void testAjoutBateauToucherEtPerdu() {
		Joueur j = new Joueur();
		assertEquals(true, j.isPerdu());
		j.ajouterBateau(new Bateau(Direction.D, 1, 2, 2));
		assertEquals(false, j.isPerdu());
		assertEquals(1, j.getBateaux().size());
		j.getBateau(0).getPortions().get(0).toucher();
		j.getBateau(0).getPortions().get(0).toucher();
		j.getBateau(0).getPortions().get(0).toucher();
		assertEquals(true, j.isPerdu());
	}

}
