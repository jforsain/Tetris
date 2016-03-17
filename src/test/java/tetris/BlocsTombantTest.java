package tetris;

import static org.junit.Assert.*;
import modele.Grille;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * @author jforsain
 * */

@RunWith(Enclosed.class)
public class BlocsTombantTest {
	
	private static Grille grille= new Grille(3, 3);
	
	public static class Une_nouvelle_grille {
		
		@Test
		public void est_vide() {
			assertEquals("" +
					"...\n" +
					"...\n" +
					"...\n", grille.toString());	
		}
		
		@Test
		public void a_pas_de_blocs_qui_tombent()
		{
			assertFalse(grille.blocsTombant());
		}
		
		
	}
}
