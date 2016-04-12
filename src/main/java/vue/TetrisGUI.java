package vue;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.Grille;
import modele.TetrisModele;

public class TetrisGUI extends JFrame implements Observer {
	
	private TetrisModele tetrisModele;
	private Grille grille_courante;
	
	/* Panels */ 
	private MenuPanel menuPanel = new MenuPanel();
	private GrillePanel grillePanel;
	
	public TetrisGUI(TetrisModele modele) {
		this.tetrisModele = modele;
		
		/* Paramétrage JFrame */
		this.setTitle("TETRIS");
		this.setSize(400, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(menuPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	public void update(Observable obs, Object obj) {

		grillePanel.repaint();
	}
	
	public void InitialiserGrillePanel ()
	{

		this.grille_courante = tetrisModele.getGrille();
		this.grillePanel = new GrillePanel(grille_courante);
		
	}
	
	public void goToGrille()
	{	
		this.getContentPane().removeAll();
		this.add(grillePanel);
		this.setVisible(true);
		/*
		this.getContentPane().remove(menuPanel);
		this.add(grillePanel);
		this.invalidate();
		this.validate();*/
	}
	
	public void goToMenu()
	{		
		this.removeAll();
		this.setContentPane(menuPanel);
	}
}