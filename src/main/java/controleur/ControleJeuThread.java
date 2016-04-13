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
		while (!tetrisModele.getJeu().isGameOver())
		{
			PieceFactory pf = new PieceFactory();
			int nbLignesCompletees = 0;
			try {
				Thread.sleep(tetrisModele.getJeu().get_temps_descente());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (tetrisModele.getGrille().peut_descendre(tetrisModele.getPiece()))
				tetrisModele.getGrille().descendre_piece(tetrisModele.getPiece());
			
			else {
				tetrisModele.getGrille().poser_piece(tetrisModele.getPiece());
				nbLignesCompletees = tetrisModele.getGrille().ligne_completee();
				tetrisModele.getJeu().setScore(tetrisModele.getJeu().getScore()+(100*nbLignesCompletees));
				tetrisModele.getJeu().setLignesCompletees((tetrisModele.getJeu().getLignesCompletees()+nbLignesCompletees));
				Piece piece = tetrisModele.getPieceSuivante();

				if (tetrisModele.getGrille().peut_apparaitre(piece)) {
					tetrisModele.getGrille().apparition_piece(piece);
					tetrisModele.setPiece(piece);
					Piece pieceSuivante = pf.getPieceRandom();
					tetrisModele.setPieceSuivante(pieceSuivante);
				}
				else {
					System.out.println("GAME OVER");
					tetrisModele.getJeu().setGameOver(true);
					tetrisModele.getJeu().setJeuNonDemarre(true);
					tetrisModele.getGrille().rafraichir_grille(piece);
					tetrisModele.getMeilleursScoresDAO().nouveauScore(tetrisModele.getJeu().getScore());
				}
			}
		}	
	}
}
