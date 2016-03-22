package tetris;

import static org.junit.Assert.*;
import modele.Grille;

import org.junit.Test;

import junit.framework.TestCase;

public class GrilleTest extends TestCase{
	
	@Test
	public void testInitialistionGrille()
	{
		Grille grille = new Grille(20, 10);
		int[][] matrice = grille.getiLaGrilleTab();
		for (int i = 0; i < grille.getiLignes(); i++) {
			for (int j = 0; j < grille.getiColonnes(); j++) {
				assertEquals(0, matrice[i][j]);
			}
		}
	}
	
	
}
