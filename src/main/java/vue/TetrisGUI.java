package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.Grille;

public class TetrisGUI extends JFrame implements Observer {
	private Grille grille_courante ;
	
	  public TetrisGUI( Grille pGrille){
			this.grille_courante= pGrille;
		    this.setTitle("TETRIS");
		    this.setSize(400, 800);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		    this.setVisible(true);
		    //this.setContentPane(new Grille_panel(grille_courante));
		    this.add(new Grille_panel(grille_courante));

	  }
	  
	  public void update(Observable obs, Object obj) {
		 
			repaint(); 
	}    
	  
}