package modele;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.Timer;

public class TetrisModele extends Observable {
	
	private Timer timer;
	private boolean enCours;
	ActionListener taskPerformer;
	

	public TetrisModele() {
		this.enCours = false;
		this.taskPerformer = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		timer = new Timer(1000, taskPerformer);
	}
	
	public boolean getEnCours()
	{
		return this.enCours;
	}
	
	public void changeState()
	{
		setChanged();
	}
}
