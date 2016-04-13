package controleur;

import modele.TetrisModele;
import vue.TetrisGUI;

public class Tetris2PStartGameThread extends Thread{
	
	private TetrisModele tetrisModele;
	private TetrisGUI tetrisGUI;
	
	public Tetris2PStartGameThread(TetrisModele pTetrisModele, TetrisGUI pTetrisGUI)
	{
		
	}
	
	public void run()
	{
		while(this.tetrisModele.getJeu().getJeu2PDemarre())
		{
			
		}
	}
}
