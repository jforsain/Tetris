package modele;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class GrilleTest extends TestCase{
	
	private int iLignes;
	private int iColonnes;
	private int iLaGrilleTab[][];
	private Piece pieceCourante;
	private int deltaX;
	private int deltaY;
	private Grille grille;
	
	@Before
	public void setUp()
	{
		this.iLignes = 20 + 1;
		this.iColonnes = 12+ 2;
		this.iLaGrilleTab = new int[iLignes][iColonnes];
		this.deltaX = 0;
		this.deltaY = 0;
	
	}
	
	@Test
	public void testInitialistionGrille()
	{
		/* GIVEN */
		this.iLignes = 20 + 1;
		this.iColonnes = 12+ 2;
		this.iLaGrilleTab = new int[iLignes][iColonnes];
		
		
		/* WHEN */
		
		/* THEN */		
		
	}
}
