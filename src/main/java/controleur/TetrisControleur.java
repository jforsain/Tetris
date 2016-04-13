package controleur;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.JFrame;

import vue.TetrisGUI;
import modele.TetrisModele;

public class TetrisControleur {
	
	private TetrisModele tetrisModele;
	private TetrisGUI tetrisGUI;
	private ControleurTimer controleurTimer;
	
	public TetrisControleur(TetrisModele tetrisModele, TetrisGUI tetrisGUI) {
		this.tetrisModele = tetrisModele;
		this.tetrisGUI = tetrisGUI;
		tetrisModele.addObserver(tetrisGUI);
		KeyboardFocusManager manager = KeyboardFocusManager
				.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new MyDispatcher());
	}

	private class MyDispatcher implements KeyEventDispatcher {
		
		public boolean dispatchKeyEvent(KeyEvent e) {
			if (e.getID() == KeyEvent.KEY_PRESSED) {
		// TODO Auto-generated method stub
		if(tetrisModele.getJeu().isJeuNonDemarre())
		{
			switch(e.getKeyCode())
			{
				case KeyEvent.VK_A:
					
					tetrisModele.getJeu().setModeJeu(1);
					tetrisGUI.getStatsPanel().layoutModeJeu();
					tetrisGUI.goToGrille();
					controleurTimer = new ControleurTimer(tetrisModele, tetrisGUI);
					controleurTimer.initialiser_jeu();
					break;	

				case KeyEvent.VK_B:

					tetrisModele.getJeu().setModeJeu(2);
					tetrisGUI.getStatsPanel().layoutModeJeu();
					tetrisGUI.goToGrille();
					controleurTimer = new ControleurTimer(tetrisModele, tetrisGUI);
					controleurTimer.initialiser_jeu();
					break;	
			}
		}
		else
		{
			switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					System.out.println("gauche");
					if (tetrisModele.getGrille().peut_aller_a_gauche(tetrisModele.getPiece())) {
						System.out.println("Aller a gauche : OK");
						tetrisModele.getGrille().decaler_gauche(tetrisModele.getPiece());
					} else
						System.out.println("Aller a gauche : ECHEC");
					break;
	
				case KeyEvent.VK_RIGHT:
					if (tetrisModele.getGrille().peut_aller_a_droite(tetrisModele.getPiece())) {
						System.out.println("Aller a droite : OK");
						tetrisModele.getGrille().decaler_droite(tetrisModele.getPiece());
					} else
						System.out.println("Aller a droite : ECHEC");
					break;
	
				case KeyEvent.VK_UP:
					if (tetrisModele.getGrille().peut_pivoter(tetrisModele.getPiece())) {
						System.out.println("PIVOT : OK");
					} else
						System.out.println("PIVOT : ECHEC");
					break;
	
				case KeyEvent.VK_DOWN:
					while (tetrisModele.getGrille().peut_descendre(tetrisModele.getPiece())) {
						tetrisModele.getGrille().descendre_piece(tetrisModele.getPiece());
					}
					tetrisModele.getGrille().rafraichir_grille(tetrisModele.getPiece());
					break;
			}
		}
	}
	return false;
	}
		
}
}
