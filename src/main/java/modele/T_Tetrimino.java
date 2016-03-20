package modele;

public class T_Tetrimino extends Piece{
	
	private Couleur couleur;
	private int[][] matricePositionsTTetrimino = { 
			{0,1,0,0,0,1,1,0,0,1,0,0,0,0,0,0},
			{0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,0},
			{0,0,0,1,0,0,1,1,0,0,0,1,0,0,0,0},
			{0,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0} 
		}; 
	
	public T_Tetrimino() {
		super();
		this.couleur = Couleur.VIOLET;
	}
	
	@Override
	public int[] getiLaPieceTab() {
		return matricePositionsTTetrimino[this.getiPosition()];
	}
}
