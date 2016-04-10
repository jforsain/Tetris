package controleur;

import java.util.Timer;
import modele.Grille;
import modele.PieceFactory;
import vue.TetrisGUI;
import modele.Piece;


public class ControleurTimer {
	

	public ControleurTimer(){
		Grille grille = new Grille(20,10);
		PieceFactory pf = new PieceFactory();
		
		Piece piece = pf.getPieceRandom();
		
		grille.apparition_piece(piece);
		
		TetrisGUI affich_tetris = new TetrisGUI(grille);
		
		grille.addObserver(affich_tetris);
		
		ControleurClavier clavier = new ControleurClavier(grille, piece);
		
		for (int i = 1; i<1000;i++){
			try{
				Thread.sleep(500);	
			}catch (Exception e){
				e.printStackTrace();
			}
			if (grille.peut_descendre(piece))
				grille.descendre_piece(piece);
			else {
				grille.poser_piece(piece);
				piece = pf.getPieceRandom();
				grille.apparition_piece(piece);
				clavier.set_piece(piece);
			}
		
		}
	}
	
	
}
