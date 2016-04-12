package tetris;

import modele.TetrisModele;
import controleur.ControleurTimer;

public class Main {

	public static void main(String[] args) {
		
		TetrisModele modele = new TetrisModele();
		
		ControleurTimer ct = new ControleurTimer();
		ct.initialiser_jeu();
	}
	
}
