package test;

import static org.junit.Assert.*;
import modele.Portion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PortionTest {

	@Test
	public void testPortion() {
		Portion p = new Portion(0, 0, 0, 2);
		assertEquals(0, p.getX());
		assertEquals(0, p.getY());
		assertEquals(0, p.getId());
		assertEquals(false, p.isTouche());
		p.toucher();
		assertEquals(true, p.isTouche());
		assertEquals(false, p.isCoule());
		p.toucher();
		assertEquals(false, p.isTouche());
		assertEquals(true, p.isCoule());
	}

}
