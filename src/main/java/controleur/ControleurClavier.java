package controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import modele.Piece;
import modele.Grille;

public class ControleurClavier extends JFrame implements KeyListener{
	private Grille grille_courante ;
	private Piece piece_courante ;
	
	public ControleurClavier(Grille pGrille, Piece pPiece){
		this.grille_courante = pGrille ;
		this.piece_courante = pPiece;
		 addKeyListener (this);
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT : 
				piece_courante.pivoterGauche();
				System.out.println("gauche");
				
				break;
			case KeyEvent.VK_RIGHT : 
				piece_courante.pivoterDroit();
				System.out.println("droite");
				
				break;}
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
