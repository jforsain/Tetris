package vue;

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
		this.grille_courante = modele.getGrille();
		this.grillePanel = new GrillePanel(grille_courante);
		
		/* Paramétrage JFrame */
		this.setTitle("TETRIS");
		this.setSize(400, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(menuPanel);
		this.setVisible(true);
	}

	public void update(Observable obs, Object obj) {

		repaint();
	}
	
	public void setContentPane()
	{
		if(this.getContentPane().equals(menuPanel))
		{
			this.remove(menuPanel);
			this.setContentPane(grillePanel);
		}
		else
		{
			this.remove(grillePanel);
			this.setContentPane(menuPanel);
		}
	}
}