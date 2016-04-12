package controleur;

import modele.TetrisModele;
import modele.Piece;
import modele.PieceFactory;

public class ControleJeuThread extends Thread{
	
	private TetrisModele tetrisModele;

	public ControleJeuThread (TetrisModele tetrisModele)
	{
		this.tetrisModele = tetrisModele;
	}
	
	@Override
	public void run ()
	{
		while (!tetrisModele.getJeu().isJeuFini())
		{
			PieceFactory pf = new PieceFactory();
			try {
				Thread.sleep(tetrisModele.getJeu().get_temps_descente());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (tetrisModele.getGrille().peut_descendre(tetrisModele.getPiece()))
				tetrisModele.getGrille().descendre_piece(tetrisModele.getPiece());
			
			else {
				tetrisModele.getGrille().poser_piece(tetrisModele.getPiece());
				tetrisModele.getGrille().ligne_completee();
				Piece piece = pf.getPieceRandom();

				if (tetrisModele.getGrille().peut_apparaitre(piece)) {
					tetrisModele.getGrille().apparition_piece(piece);
					tetrisModele.setPiece(piece);
				}
				else {
					System.out.println("GAME OVER");
					tetrisModele.getJeu().setJeuFini(true);
				}
			}
		}
		
	}

}
