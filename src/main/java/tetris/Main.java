package tetris;

import vue.TetrisGUI;
import modele.TetrisModele;
import controleur.TetrisControleur;

public class Main {

	public static void main(String[] args) {
		
		TetrisModele tetrisModele = new TetrisModele();
		TetrisGUI tetrisGUI = new TetrisGUI(tetrisModele);
		new TetrisControleur(tetrisModele, tetrisGUI);
	}
}
