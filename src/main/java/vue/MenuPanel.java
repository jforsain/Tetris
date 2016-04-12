package vue;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{
	
	private JButton oneplayer = new JButton("Tapez 'a' pour jouer en solo");
	private JButton twoplayers = new JButton("Tapez 'b' pour jouer en multijoueurs");
	
	public MenuPanel()
	{
		this.add(oneplayer);
		this.add(twoplayers);
	}
}
