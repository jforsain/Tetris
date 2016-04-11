package controleur;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import modele.Piece;
import modele.Grille;

public class ControleurClavier extends JFrame {
	private Grille grille_courante;
	private Piece piece_courante;

	public ControleurClavier(Grille pGrille, Piece pPiece) {
		this.grille_courante = pGrille;
		this.piece_courante = pPiece;
		KeyboardFocusManager manager = KeyboardFocusManager
				.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new MyDispatcher());
	}

	private class MyDispatcher implements KeyEventDispatcher {
		public boolean dispatchKeyEvent(KeyEvent e) {
			if (e.getID() == KeyEvent.KEY_PRESSED) {
				
				switch (e.getKeyCode()) {

					case KeyEvent.VK_LEFT:
						System.out.println("gauche");
						if (grille_courante.peut_aller_a_gauche(piece_courante)) {
							System.out.println("Aller a gauche : OK");
							grille_courante.decaler_gauche(piece_courante);
						} else
							System.out.println("Aller a gauche : ECHEC");
						break;
	
					case KeyEvent.VK_RIGHT:
						if (grille_courante.peut_aller_a_droite(piece_courante)) {
							System.out.println("Aller a droite : OK");
							grille_courante.decaler_droite(piece_courante);
						} else
							System.out.println("Aller a droite : ECHEC");
						break;
	
					case KeyEvent.VK_UP:
						if (grille_courante.peut_pivoter(piece_courante)) {
							System.out.println("PIVOT : OK");
						} else
							System.out.println("PIVOT : ECHEC");
						break;
	
					case KeyEvent.VK_DOWN:
						while (grille_courante.peut_descendre(piece_courante)) {
							grille_courante.descendre_piece(piece_courante);
						}
						grille_courante.rafraichir_grille(piece_courante);
						break;
				}
			}
			return false;
		}
	}

	public void set_piece(Piece p) {
		this.piece_courante = p;
	}

	public void set_grille(Grille g) {
		this.grille_courante = g;
	}
}
