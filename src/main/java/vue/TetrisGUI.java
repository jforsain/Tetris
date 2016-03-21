package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.Grille;

public class TetrisGUI extends JFrame {
	private Grille grille_courante ;
	
	  public TetrisGUI( Grille pGrille){
			this.grille_courante= pGrille;
		    this.setTitle("Ma première fenêtre Java");
		    this.setSize(400, 800);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		    this.setVisible(true);
		    this.setContentPane(new Grille_panel(grille_courante));
		
	  }
	  
}



