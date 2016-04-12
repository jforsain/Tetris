package tetris;

import vue.TetrisGUI;
import modele.TetrisModele;
import controleur.ControleurTimer;
import controleur.TetrisControleur;

public class Main {

	public static void main(String[] args) {
		
		TetrisModele modele = new TetrisModele();
		TetrisGUI tetrisGUI = new TetrisGUI(modele);
		TetrisControleur controleur = new TetrisControleur(modele, tetrisGUI);

		ControleurTimer ct = new ControleurTimer();
		ct.initialiser_jeu();
	}
	
}
