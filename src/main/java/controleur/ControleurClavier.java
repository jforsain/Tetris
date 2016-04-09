package controleur;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import modele.Piece;
import modele.Grille;

public class ControleurClavier extends JFrame{
	private Grille grille_courante ;
	private Piece piece_courante ;
	
	public ControleurClavier(Grille pGrille, Piece pPiece){
		this.grille_courante = pGrille ;
		this.piece_courante = pPiece;
		 KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
	        manager.addKeyEventDispatcher(new MyDispatcher());
	}
	
	private class MyDispatcher implements KeyEventDispatcher {
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
            	switch (e.getKeyCode()) {
    			case KeyEvent.VK_LEFT : 
    				System.out.println("gauche");
    				grille_courante.decaler_gauche(piece_courante);
    				
    				
    				break;
    			case KeyEvent.VK_RIGHT : 
    				System.out.println("droite");
    				grille_courante.decaler_droite(piece_courante);
    				break;}
        }
            return false;
        }
	
				/*
			case KeyEvent.VK_UP : if (p != null) {
					p.tourned(grille);
					repaint();
				}
			case KeyEvent.VK_DOWN : if (p != null) {
	                                p.descend(grille);
	                                repaint();
				}
	                break;*/
			//default : repaint();
		}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
