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
	
	private TetrisModele modele;
	private TetrisGUI tetrisGUI;
	private ControleurTimer controleurTimer;
	
	public TetrisControleur(TetrisModele modele, TetrisGUI tetrisGUI) {
		this.modele = modele;
		this.tetrisGUI = tetrisGUI;
		modele.addObserver(tetrisGUI);
		KeyboardFocusManager manager = KeyboardFocusManager
				.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new MyDispatcher());
	}

	private class MyDispatcher implements KeyEventDispatcher {
		
		public boolean dispatchKeyEvent(KeyEvent e) {
			if (e.getID() == KeyEvent.KEY_PRESSED) {
		// TODO Auto-generated method stub
		if(modele.getJeu().isJeuFini())
		{
			switch(e.getKeyCode())
			{
				case KeyEvent.VK_A:
					System.out.println("init");
					modele.setGrille(20, 10); // new Grille(lignes, colonnes)
					
//					for (int i = 0; i<21; i++)
//					{
//						for (int j=0 ; j<12; j++)
//						{
//							System.out.print(modele.getGrille().getiLaGrilleTab()[i][j]);
//						}
//						System.out.println("");
//					}
					

					tetrisGUI.InitialiserGrillePanel();
					tetrisGUI.goToGrille();
					controleurTimer = new ControleurTimer(modele, tetrisGUI);
					controleurTimer.initialiser_jeu();
					break;	
			}
		}
		else
		{
			switch (e.getKeyCode()) {

			case KeyEvent.VK_LEFT:
				System.out.println("gauche");
				if (modele.getGrille().peut_aller_a_gauche(modele.getPiece())) {
					System.out.println("Aller a gauche : OK");
					modele.getGrille().decaler_gauche(modele.getPiece());
				} else
					System.out.println("Aller a gauche : ECHEC");
				break;

			case KeyEvent.VK_RIGHT:
				if (modele.getGrille().peut_aller_a_droite(modele.getPiece())) {
					System.out.println("Aller a droite : OK");
					modele.getGrille().decaler_droite(modele.getPiece());
				} else
					System.out.println("Aller a droite : ECHEC");
				break;

			case KeyEvent.VK_UP:
				if (modele.getGrille().peut_pivoter(modele.getPiece())) {
					System.out.println("PIVOT : OK");
				} else
					System.out.println("PIVOT : ECHEC");
				break;

			case KeyEvent.VK_DOWN:
				while (modele.getGrille().peut_descendre(modele.getPiece())) {
					modele.getGrille().descendre_piece(modele.getPiece());
				}
				modele.getGrille().rafraichir_grille(modele.getPiece());
				break;
			}
		}
	}
	return false;
	}
		
}
}
