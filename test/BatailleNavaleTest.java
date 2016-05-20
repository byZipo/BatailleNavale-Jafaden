package test;

import static org.junit.Assert.*;
import modele.BatailleNavale;
import modele.Bateau;
import modele.Bateau.Direction;
import modele.Bateau.Sens;
import modele.Joueur.Type;
import modele.Portion;
import modele.algo.Algo;
import modele.algo.Algo.Algorithme;
import modele.algo.AlgoCroix;
import modele.algo.AlgoRandom;
import modele.epoque.EpoqueFactory;
import modele.epoque.EpoqueFactory.Epoque;
import modele.epoque.xixsiecle.XIXFactory;
import modele.epoque.xxsiecle.XXFactory;
import modele.mode.ModeGrille;
import modele.mode.ModeGrille.Mode;
import modele.mode.ModeGrilleInter;
import modele.mode.ModeGrilleSimple;
import modele.mode.ModeGrilleTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatailleNavaleTest {

	@Test
	public void testSetModeGrilleModeGrille() {
		BatailleNavale b = BatailleNavale.getInstance();
		assertEquals(true, b.getModeGrille() instanceof ModeGrilleTest);
		b.setModeGrille(ModeGrille.getInstance(Mode.SIMPLE));
		assertEquals(true, b.getModeGrille() instanceof ModeGrilleSimple);
	}

	@Test
	public void testSetModeGrilleInt() {
		BatailleNavale b = BatailleNavale.getInstance();
		b.setModeGrille(1);
		assertEquals(true, b.getModeGrille() instanceof ModeGrilleInter);
	}

	@Test
	public void testSetAlgoAlgo() {
		BatailleNavale b = BatailleNavale.getInstance();
		assertEquals(true, b.getAlgo() instanceof AlgoRandom);
		b.setAlgo(Algo.getInstance(Algorithme.CROIX));
		assertEquals(true, b.getAlgo() instanceof AlgoCroix);
	}

	@Test
	public void testSetAlgoInt() {
		BatailleNavale b = BatailleNavale.getInstance();
		b.setAlgo(0);
		assertEquals(true, b.getAlgo() instanceof AlgoRandom);
	}

	@Test
	public void testSetEpoqueEpoqueFactory() {
		BatailleNavale b = BatailleNavale.getInstance();
		b.setEpoque(EpoqueFactory.getInstance(Epoque.XX));
		assertEquals(true, b.getEpoque() instanceof XXFactory);
	}

	@Test
	public void testSetEpoqueInt() {
		BatailleNavale b = BatailleNavale.getInstance();
		assertEquals(true, b.getEpoque() instanceof XXFactory);
		b.setEpoque(1);
		assertEquals(true, b.getEpoque() instanceof XIXFactory);
	}

	@Test
	public void testPartie() {
		BatailleNavale b = BatailleNavale.getInstance();
		b.getJoueur().ajouterBateau(new Bateau(Direction.D, 1, 0, 0));
		b.getJoueur().ajouterBateau(new Bateau(Direction.D, 1, 1, 0));
		b.getOrdinateur().ajouterBateau(new Bateau(Direction.D, 1, 0, 0));
		b.getOrdinateur().ajouterBateau(new Bateau(Direction.D, 1, 1, 0));
		b.jouer(0, 0);
		assertEquals(false,b.getOrdinateur().isPerdu());
		b.jouer();
		int x = b.getDernierCoupOrdi().getPremier();
		int y = b.getDernierCoupOrdi().getDeuxieme();
		assertEquals(true, b.getOrdinateur().getPositionsAdverse()[x][y]!=Type.CACHE);
		
	}

}
