package controleur;

import vue.TetrisGUI;
import modele.TetrisModele;

public class Tetris2PThread extends Thread{
	
	private TetrisModele tetrisModele;
	private TetrisGUI tetrisGUI;
	
	public Tetris2PThread(TetrisModele pTetrisModele, TetrisGUI pTetrisGUI) {
		
		this.tetrisModele = pTetrisModele;
		this.tetrisGUI = pTetrisGUI;
	}
	
	public void run()
	{
		while(this.tetrisModele.getJeu().getJeu2PDemarre())
		{
			
		}
	}
	
	
}
