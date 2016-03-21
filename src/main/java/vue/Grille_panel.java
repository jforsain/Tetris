package vue;

import java.awt.Graphics;
import javax.swing.JPanel;
 

public class Grille_panel extends JPanel { 
	  public void paintComponent(Graphics g){
		    //x1, y1, x2, y2
		  
		  for (int i=0;i<10;i++){
		    g.drawLine(i*this.getWidth()/10, 0, i*this.getWidth()/10, this.getHeight());
		  }
		  for (int j=0;j<20;j++){
			    g.drawLine(0, j*this.getHeight()/20, this.getWidth(), j*this.getHeight()/20);
		  }
		  
	  }               
}