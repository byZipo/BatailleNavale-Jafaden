package tests;

import static org.junit.Assert.*;
import modele.Bateau;
import modele.Bateau.Direction;
import modele.Bateau.Sens;
import modele.Portion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BateauTest {

	@Test
	public void testDeplacementEtTourner() {
		Bateau b = new Bateau(Direction.B, 3, 0, 0);
		b.tourner(Sens.ANTIHORAIRE);
		assertEquals(Direction.D, b.getDirection());
		b.tourner(Sens.HORAIRE);
		assertEquals(Direction.B, b.getDirection());
		b.deplacer(Direction.B);
		assertEquals(0, b.getxDepart());
		assertEquals(1, b.getyDepart());
		b.deplacer(Direction.D);
		assertEquals(1, b.getxDepart());
		assertEquals(1, b.getyDepart());
		b.deplacer(Direction.H);
		assertEquals(1, b.getxDepart());
		assertEquals(0, b.getyDepart());
		b.deplacer(Direction.G);
		assertEquals(0, b.getxDepart());
		assertEquals(0, b.getyDepart());
	}

}
