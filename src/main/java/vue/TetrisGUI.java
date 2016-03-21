package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TetrisGUI extends JFrame {
	  public TetrisGUI(){
		    this.setTitle("Ma première fenêtre Java");
		    this.setSize(400, 800);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		    this.setVisible(true);
		    this.setContentPane(new Grille_panel());
		
	  }
}



