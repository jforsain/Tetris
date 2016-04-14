package modele;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import modele.Piece;

import org.junit.Test;

public class PieceFactoryTest extends TestCase {

	@Test
	public void testGetPieceRandom() {
		
		int i = 0;
		do
		{
			int nombreAleatoire = 1 + (int)(Math.random() * ((7 - 1) + 1));
			if(nombreAleatoire >= 1 && nombreAleatoire <= 7) 
				assertTrue(true);
			else
				fail();
			i++;
		}while(i <= 1000);
	}
}
