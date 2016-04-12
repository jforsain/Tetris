package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import vue.TetrisGUI;
import modele.TetrisModele;

public class Controleur implements ActionListener, KeyListener{
	
	private TetrisModele modele;
	private TetrisGUI tetrisGUI;
	
	public Controleur(TetrisModele modele, TetrisGUI tetrisGUI) {
		super();
		this.modele = modele;
		this.tetrisGUI = tetrisGUI;
		modele.addObserver(tetrisGUI);
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
