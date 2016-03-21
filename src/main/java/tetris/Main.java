package tetris;

import vue.TetrisGUI;
import modele.Grille;
import modele.Piece;
import modele.I_Tetrimino;

public class Main {

	public static void main(String[] args) {
		
		Grille grille = new Grille(20,10);
		Piece piece = new I_Tetrimino();
		grille.apparition_piece(piece);

		TetrisGUI testwindow = new TetrisGUI(grille);
		
		for (int i = 1; i<10;i++){
			try{
				Thread.sleep(500);	
			}catch (Exception e){
				e.printStackTrace();
			}
		
		}
	}
	
}
