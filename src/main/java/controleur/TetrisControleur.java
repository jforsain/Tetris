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
	private TetrisServeurControleur tetrisServeurControleur;
	private TetrisClientControleur tetrisClientControleur;
	
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
							tetrisServeurControleur = new TetrisServeurControleur(tetrisModele, tetrisGUI);
							break;
		
							
						case KeyEvent.VK_C:
		
							tetrisModele.getJeu().setModeJeu(2);
							tetrisClientControleur = new TetrisClientControleur(tetrisModele, tetrisGUI);
							break;	
					}
				}
				else if (!tetrisModele.getJeu().isMalus3EnCours())
				{
					switch (e.getKeyCode()) {
		
						case KeyEvent.VK_LEFT:
							if (tetrisModele.getGrille().peut_aller_a_gauche(tetrisModele.getPiece())) {
								tetrisModele.getGrille().decaler_gauche(tetrisModele.getPiece());
							}
							break;
			
						case KeyEvent.VK_RIGHT:
							if (tetrisModele.getGrille().peut_aller_a_droite(tetrisModele.getPiece())) {
								tetrisModele.getGrille().decaler_droite(tetrisModele.getPiece());
							}
							break;
			
						case KeyEvent.VK_UP:
							if (tetrisModele.getGrille().peut_pivoter(tetrisModele.getPiece()))
							break;
			
						case KeyEvent.VK_SPACE:
							while (tetrisModele.getGrille().peut_descendre(tetrisModele.getPiece())) {
								tetrisModele.getGrille().descendre_piece(tetrisModele.getPiece());
							}
							tetrisModele.getGrille().rafraichir_grille(tetrisModele.getPiece());
							break;
						
						case KeyEvent.VK_DOWN:
							tetrisModele.getJeu().setTempsDescente(75);
							break;
					}
				}
			}
			else if (e.getID() == KeyEvent.KEY_RELEASED){
				if(!tetrisModele.getJeu().isJeuNonDemarre() && !tetrisModele.getJeu().isMalus3EnCours())
				{
					switch(e.getKeyCode())
					{
						case KeyEvent.VK_DOWN: 
							int niveauTemp = tetrisModele.getJeu().getNiveau();
							int tempsDescenteTemp = 1000;
							for (int i =1; i < niveauTemp; i++){
								tempsDescenteTemp = (int) (tempsDescenteTemp * 0.9);
							}
							tetrisModele.getJeu().setTempsDescente(tempsDescenteTemp);
							break;
					}
				}
			}
	return false;
	}
		
}
}
