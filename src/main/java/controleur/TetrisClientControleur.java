package controleur;

import modele.TetrisModele;
import vue.TetrisGUI;

public class TetrisClientControleur {

	private TetrisModele tetrisModele;
	private TetrisGUI tetrisGUI;
	
	public TetrisClientControleur (TetrisModele pTetrisModele, TetrisGUI pTetrisGUI){
		this.tetrisModele = pTetrisModele;
		this.tetrisGUI = pTetrisGUI;
	}
	
	public void connexionOK(){
		ControleurTimer controleurTimer = new ControleurTimer(tetrisModele, tetrisGUI);
		controleurTimer.initialiser_jeu();
	}
}
