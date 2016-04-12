package vue;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{
	
	private JButton oneplayer = new JButton("Player 1");
	private JButton twoplayers = new JButton("Player 2");
	
	public MenuPanel()
	{
		this.add(oneplayer);
		this.add(twoplayers);
	}
}
