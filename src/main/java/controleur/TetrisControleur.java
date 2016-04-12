package controleur;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.JFrame;

import controleur.ControleurClavier.MyDispatcher;
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
		if(this.modele.getJeu().isJeuFini())
		{
			switch(e.getKeyCode())
			{
				case KeyEvent.VK_A:
					this.modele.setGrille(20, 10); // new Grille(lignes, colonnes)
					this.controleurTimer = new ControleurTimer(modele, tetrisGUI);
					this.controleurTimer.initialiser_jeu();
					this.tetrisGUI.setContentPane();
					break;	
			}
		}
		else
		{
			switch (e.getKeyCode()) {

			case KeyEvent.VK_LEFT:
				System.out.println("gauche");
				if (this.modele.getGrille().peut_aller_a_gauche(this.modele.getPiece())) {
					System.out.println("Aller a gauche : OK");
					this.modele.getGrille().decaler_gauche(this.modele.getPiece());
				} else
					System.out.println("Aller a gauche : ECHEC");
				break;

			case KeyEvent.VK_RIGHT:
				if (this.modele.getGrille().peut_aller_a_droite(this.modele.getPiece())) {
					System.out.println("Aller a droite : OK");
					this.modele.getGrille().decaler_droite(this.modele.getPiece());
				} else
					System.out.println("Aller a droite : ECHEC");
				break;

			case KeyEvent.VK_UP:
				if (this.modele.getGrille().peut_pivoter(this.modele.getPiece())) {
					System.out.println("PIVOT : OK");
				} else
					System.out.println("PIVOT : ECHEC");
				break;

			case KeyEvent.VK_DOWN:
				while (this.modele.getGrille().peut_descendre(this.modele.getPiece())) {
					this.modele.getGrille().descendre_piece(this.modele.getPiece());
				}
				this.modele.getGrille().rafraichir_grille(this.modele.getPiece());
				break;
			}
		}
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
